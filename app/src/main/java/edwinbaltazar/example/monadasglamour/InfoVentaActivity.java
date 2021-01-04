package edwinbaltazar.example.monadasglamour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import edwinbaltazar.example.monadasglamour.Model.ActualizarPost;
import edwinbaltazar.example.monadasglamour.Model.ActualizarResponse;
import edwinbaltazar.example.monadasglamour.Model.ListaDeVentas;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static edwinbaltazar.example.monadasglamour.R.drawable.button_info2;
import static edwinbaltazar.example.monadasglamour.VentasActivity.CANTIDAD_PRODUCTO;
import static edwinbaltazar.example.monadasglamour.VentasActivity.DIRECCION_CLIENTE;
import static edwinbaltazar.example.monadasglamour.VentasActivity.EMAIL_CLIENTE;
import static edwinbaltazar.example.monadasglamour.VentasActivity.ESTADO_PRO;
import static edwinbaltazar.example.monadasglamour.VentasActivity.FECHA_CLIENTE;
import static edwinbaltazar.example.monadasglamour.VentasActivity.ID_VENTA;
import static edwinbaltazar.example.monadasglamour.VentasActivity.NOMBRE_PRODUCTO;
import static edwinbaltazar.example.monadasglamour.VentasActivity.PAGO_CLIENTE;

public class InfoVentaActivity extends AppCompatActivity {

    TextView nombreProdu,emailCliet,cantProduc,direcClient,pagoClient,fechaClient;
    Button butonActu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_venta);
        Intent intent=getIntent();
        String nombre_producto=intent.getStringExtra(NOMBRE_PRODUCTO);
        String email_cliente=intent.getStringExtra(EMAIL_CLIENTE);
        String cant_producto=intent.getStringExtra(CANTIDAD_PRODUCTO);
        String direc_cliente=intent.getStringExtra(DIRECCION_CLIENTE);
        String pago_cliente=intent.getStringExtra(PAGO_CLIENTE);
        String fecha_cliente=intent.getStringExtra(FECHA_CLIENTE);
        String id_venta=intent.getStringExtra(ID_VENTA);
        String estado_produc=String.valueOf(intent.getStringExtra(ESTADO_PRO));

        //Botón
        butonActu=findViewById(R.id.button_actualizar);

        nombreProdu=findViewById(R.id.nombre_producto);
        emailCliet=findViewById(R.id.cliente_correo);
        cantProduc=findViewById(R.id.cantidad_producto);
        direcClient=findViewById(R.id.cliente_direccion);
        pagoClient=findViewById(R.id.total);
        fechaClient=findViewById(R.id.compra_fecha);
        //enviado datos ala vista
        nombreProdu.setText(nombre_producto);
        emailCliet.setText(email_cliente);
        cantProduc.setText(" "+cant_producto);
        direcClient.setText(direc_cliente);
        pagoClient.setText("S/. "+pago_cliente);
        fechaClient.setText(fecha_cliente);
        //Estilo de los botones de acuerdo a su estado
        Drawable d1 = getResources().getDrawable(R.drawable.button_info);
        Drawable d2 = getResources().getDrawable(R.drawable.button_info2);

        if(estado_produc.equals("2")) {
            butonActu.setBackground(d2);
            butonActu.setText("Enviando producto");
        }else {
            butonActu.setBackground(d1);
            butonActu.setText("Enviar producto");
        }
        //Onclick del boton para cambiar su estilo
        butonActu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                actualizar(id_venta,estado_produc);

            }
        });
    }
    public void actualizar(String idVenta, String estado){
        int id_venta=Integer.valueOf(idVenta);
        int estadoFinal=Integer.valueOf(estado);
        int enviarEstado=estadoFinal+1;
        if (enviarEstado==3){
            enviarEstado=2;
        }else if (enviarEstado==1){
            enviarEstado=2;
        }


        ActualizarPost actualizarPost =new ActualizarPost();
        actualizarPost.setId_venta(id_venta);
        actualizarPost.setEstado(enviarEstado);

        Call<ActualizarResponse> ActualizarResponseCall= ApiPut.getAtualizarService().putVenta(actualizarPost);
        ActualizarResponseCall.enqueue(new Callback<ActualizarResponse>() {
            @Override
            public void onResponse(Call<ActualizarResponse> call, Response<ActualizarResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(InfoVentaActivity.this,"Se Actualizo",Toast.LENGTH_LONG).show();
                    ActualizarResponse actualizarResponse= response.body();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ActualizarResponse actualizarResponse= response.body();
                            startActivity(new Intent(InfoVentaActivity.this, ListaDeVentas.class).putExtra("Message",actualizarResponse.getMessage()));

                        }
                    },500);
                }else{
                        Toast.makeText(InfoVentaActivity.this,"Error",Toast.LENGTH_LONG).show();
                    }
                }
            @Override
            public void onFailure(Call<ActualizarResponse> call, Throwable t) {
                Toast.makeText(InfoVentaActivity.this,"Throwable"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}