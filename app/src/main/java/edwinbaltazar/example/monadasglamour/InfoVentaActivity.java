package edwinbaltazar.example.monadasglamour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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
        int cambio =0;
        Drawable d1 = getResources().getDrawable(R.drawable.button_info);
        Drawable d2 = getResources().getDrawable(R.drawable.button_info2);
        if(estado_produc.equals("1")) {

            cambio = R.drawable.button_info;
            butonActu.setBackground(d1);
            butonActu.setText("Enviar producto");

        }else {
            cambio= R.drawable.button_info2;
            butonActu.setBackground(d2);
            butonActu.setText("Enviando producto");

        }


    }
}