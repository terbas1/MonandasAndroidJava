package edwinbaltazar.example.monadasglamour.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import edwinbaltazar.example.monadasglamour.Model.ListaDeVentas;
import edwinbaltazar.example.monadasglamour.Model.MasVendidoPost;
import edwinbaltazar.example.monadasglamour.R;

import static edwinbaltazar.example.monadasglamour.R.layout.ventas_layout;

public class ListaDeVentasAdapter extends ArrayAdapter<ListaDeVentas> {

    private Context context;
    private List<ListaDeVentas> listaDeVentass;




    public  ListaDeVentasAdapter(Context context ,List<ListaDeVentas> listaDeVentass){
        super(context,ventas_layout,listaDeVentass);
        this.context=context;
        this.listaDeVentass=listaDeVentass;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater =LayoutInflater.from(context);
        convertView=layoutInflater.inflate(ventas_layout,parent,false);

        ListaDeVentas listaDeVentas=listaDeVentass.get(position);
        TextView pago=convertView.findViewById(R.id.txt_pago);
        pago.setText(""+listaDeVentas.getPago());
        TextView fecha=convertView.findViewById(R.id.txt_fecha);
        fecha.setText(listaDeVentas.getFecha().substring(0,9));
        TextView proceso=convertView.findViewById(R.id.proceso);


        proceso.setText(String.valueOf(listaDeVentas.getEnvioText()) );




        return convertView;
    }
}



