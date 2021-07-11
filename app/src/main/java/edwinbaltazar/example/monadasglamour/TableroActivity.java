package edwinbaltazar.example.monadasglamour;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import edwinbaltazar.example.monadasglamour.Adapter.MasVendidoListAdapter;
import edwinbaltazar.example.monadasglamour.Interface.MasVendidosService;
import edwinbaltazar.example.monadasglamour.Interface.ProductosService;
import edwinbaltazar.example.monadasglamour.Interface.UsuariosService;
import edwinbaltazar.example.monadasglamour.Interface.VentasService;
import edwinbaltazar.example.monadasglamour.Interface.VisitasService;
import edwinbaltazar.example.monadasglamour.Model.MasVendidoPost;
import edwinbaltazar.example.monadasglamour.Model.ProductoPost;
import edwinbaltazar.example.monadasglamour.Model.UsuarioPost;
import edwinbaltazar.example.monadasglamour.Model.VentaPost;
import edwinbaltazar.example.monadasglamour.Model.VisitaPost;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TableroActivity extends AppCompatActivity {

    TextView perfil,ventas,visitas,usuarios,productos;
    ListView listProduct;
    List<MasVendidoPost> list;
    MasVendidoListAdapter adapter;
    MasVendidoPost masVendidoPost;
    LinearLayout irVentas;
    ImageView bottonLogut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);

        ventas=findViewById(R.id.txt_ventas);
        perfil=findViewById(R.id.perfil);
        visitas=findViewById(R.id.txt_vistas);
        usuarios=findViewById(R.id.txt_usuarios);
        productos=findViewById(R.id.txt_product);
        listProduct=(ListView) findViewById(R.id.list_produtosvendidos);
        irVentas=findViewById(R.id.cuadro_ventas);
        bottonLogut=findViewById(R.id.logout);


        Intent intent= getIntent();
        if (intent.getExtras() != null){
            String Aperfil= intent.getStringExtra("data");
            perfil.setText("Tablero del "+Aperfil);
            getVenta();
            getVisitas();
            getUsuarios();
            getProductos();
            getMasVendidos();
        }
        irVentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(v.getContext(),VentasActivity.class);
                startActivityForResult(intent2,0);

            }
        });
        bottonLogut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();

            }
        });

    }
    // Consumir api para las ventas
    private void getVenta(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api2.bellasmonadas.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        VentasService ventasService=retrofit.create(VentasService.class);
        Call<List<VentaPost>> call=ventasService.getVenta();
        call.enqueue(new Callback<List<VentaPost>>() {
            @Override
            public void onResponse(Call<List<VentaPost>> call, Response<List<VentaPost>> response) {
                if(!response.isSuccessful()){
                    ventas.setText(response.code());
                    return;
                }
                List<VentaPost> ventaList = response.body();
                for (VentaPost ventapost:ventaList){
                    double content=0;
                    content=Math.round(ventapost.getVentas()*100.0)/100.0;

                    ventas.append(""+content);
                }

            }

            @Override
            public void onFailure(Call<List<VentaPost>> call, Throwable t) {
                ventas.setText(t.getMessage());
            }
        });

    }
    //Consumir api para la visitas

    private void getVisitas(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api2.bellasmonadas.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        VisitasService visitasService=retrofit.create(VisitasService.class);
        Call<List<VisitaPost>> call= visitasService.getVisitas();
        call.enqueue(new Callback<List<VisitaPost>>() {
            @Override
            public void onResponse(Call<List<VisitaPost>> call, Response<List<VisitaPost>> response) {
                if(!response.isSuccessful()){
                    visitas.setText(response.code());
                    return;
                }
                List<VisitaPost> visitaList = response.body();
                for (VisitaPost visitaPost:visitaList){
                    int content=0;
                    content=visitaPost.getVisitas();

                    visitas.append(""+content);
                }

            }

            @Override
            public void onFailure(Call<List<VisitaPost>> call, Throwable t) {
                visitas.setText(t.getMessage());
            }
        });
    }
    //Consumir api para la cantidad de usuarios
    private void getUsuarios(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api2.bellasmonadas.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UsuariosService usuariosService=retrofit.create(UsuariosService.class);
        Call<List<UsuarioPost>> call= usuariosService.getUsuarios();
        call.enqueue(new Callback<List<UsuarioPost>>() {
            @Override
            public void onResponse(Call<List<UsuarioPost>> call, Response<List<UsuarioPost>> response) {
                if(!response.isSuccessful()){
                    usuarios.setText(response.code());
                    return;
                }
                List<UsuarioPost> usuarioList = response.body();
                for (UsuarioPost usuarioPost:usuarioList){
                    int content=0;
                    content=usuarioPost.getUsuarios();

                    usuarios.append(""+content);
                }
            }

            @Override
            public void onFailure(Call<List<UsuarioPost>> call, Throwable t) {
                usuarios.setText(t.getMessage());
            }
        });

    }
    // Consumir api para las ventas
    private void getProductos(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api2.bellasmonadas.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ProductosService productosService=retrofit.create(ProductosService.class);
        Call<List<ProductoPost>> call= productosService.getProductos();
        call.enqueue(new Callback<List<ProductoPost>>() {
            @Override
            public void onResponse(Call<List<ProductoPost>> call, Response<List<ProductoPost>> response) {
                if(!response.isSuccessful()){
                    productos.setText(response.code());
                    return;
                }
                List<ProductoPost> productoList = response.body();
                for (ProductoPost productoPost:productoList){
                    int content=0;
                    content=productoPost.getProductos();

                    productos.append(""+content);
                }
            }

            @Override
            public void onFailure(Call<List<ProductoPost>> call, Throwable t) {
                productos.setText(t.getMessage());
            }
        });
    }

    //Lista
    private void getMasVendidos(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api2.bellasmonadas.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MasVendidosService masVendidosService=retrofit.create(MasVendidosService.class);
        Call<List<MasVendidoPost>> call= masVendidosService.getMasVendidos();

        call.enqueue(new Callback<List<MasVendidoPost>>() {
            @Override
            public void onResponse(Call<List<MasVendidoPost>> call, Response<List<MasVendidoPost>> response) {

                list=(List<MasVendidoPost>)response.body();

                listProduct.setAdapter(new MasVendidoListAdapter(getApplicationContext(),list));

            }

            @Override
            public void onFailure(Call<List<MasVendidoPost>> call, Throwable t) {
                Toast.makeText(TableroActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
    private void logout(){
        AlertDialog.Builder builder=new
                AlertDialog.Builder(this,R.style.Theme_AppCompat_Dialog_Alert);

        builder.setTitle("Sesión");
        builder.setMessage("¿Desea Cerrar Sesión?");
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Mensaje","CAncelo el cerrrar sesión");
            }
        });
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                acceptorLough();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    private  void acceptorLough(){
        Intent intent3=new Intent(this,MainActivity.class);
        intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent3);
    }
}