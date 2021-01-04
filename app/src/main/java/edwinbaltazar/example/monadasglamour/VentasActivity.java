package edwinbaltazar.example.monadasglamour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import edwinbaltazar.example.monadasglamour.Adapter.ListaDeVentasAdapter;
import edwinbaltazar.example.monadasglamour.Adapter.MasVendidoListAdapter;
import edwinbaltazar.example.monadasglamour.Interface.ListaDeVentasService;
import edwinbaltazar.example.monadasglamour.Interface.MasVendidosService;
import edwinbaltazar.example.monadasglamour.Model.ListaDeVentas;
import edwinbaltazar.example.monadasglamour.Model.MasVendidoPost;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VentasActivity extends AppCompatActivity  {

    public static final String NOMBRE_PRODUCTO="detalle";
    public static final String EMAIL_CLIENTE="email";
    public static final String CANTIDAD_PRODUCTO="cantidad";
    public static final String DIRECCION_CLIENTE="direccion";
    public static final String PAGO_CLIENTE="pago";
    public static final String FECHA_CLIENTE="fecha";
    public static final String ID_VENTA="idVenta";
    public static final String ESTADO_PRO="estado";


    private ListView listViewVentas;
    private List<ListaDeVentas> listaDeVentass;
    private ListaDeVentasAdapter listaDeVentasAdapter;
    int id_prod=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);

        listViewVentas=(ListView) findViewById(R.id.venta_list);

        getMasVendidos();

        Intent detallInten=new Intent(this,InfoVentaActivity.class);

        listViewVentas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListaDeVentas listaDeVentas=listaDeVentass.get(position);
                int pos=listaDeVentas.getId();

                if (position==position){

                    detallInten.putExtra(NOMBRE_PRODUCTO,listaDeVentas.getDetalle());
                    detallInten.putExtra(EMAIL_CLIENTE,listaDeVentas.getEmail());
                    detallInten.putExtra(CANTIDAD_PRODUCTO,String.valueOf(listaDeVentas.getCantidad()));
                    detallInten.putExtra(DIRECCION_CLIENTE,listaDeVentas.getDireccion());
                    detallInten.putExtra(PAGO_CLIENTE,listaDeVentas.getPago());
                    detallInten.putExtra(ID_VENTA,String.valueOf(listaDeVentas.getId()));
                    detallInten.putExtra(ESTADO_PRO,String.valueOf(listaDeVentas.getEnvio()));

                    String feacha1=listaDeVentas.getFecha();
                    String feacha2=feacha1.substring(0,9);

                    detallInten.putExtra(FECHA_CLIENTE,feacha2);
                    startActivity(detallInten);
                }else {
                    Toast.makeText(VentasActivity.this,"No funciono",Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    //Lista
    private void getMasVendidos(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ecommerce121942.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ListaDeVentasService listaDeVentasService=retrofit.create(ListaDeVentasService.class);
        Call<List<ListaDeVentas>> call =listaDeVentasService.getListaVentas();
        call.enqueue(new Callback<List<ListaDeVentas>>() {
            @Override
            public void onResponse(Call<List<ListaDeVentas>> call, Response<List<ListaDeVentas>> response) {

                listaDeVentass=(List<ListaDeVentas>) response.body();
                listViewVentas.setAdapter(new ListaDeVentasAdapter(getApplicationContext(),listaDeVentass));

            }

            @Override
            public void onFailure(Call<List<ListaDeVentas>> call, Throwable t) {
                Toast.makeText(VentasActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


    }




}