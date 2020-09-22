package edwinbaltazar.example.monadasglamour.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import edwinbaltazar.example.monadasglamour.Model.MasVendidoPost;
import edwinbaltazar.example.monadasglamour.R;

import static edwinbaltazar.example.monadasglamour.R.layout.mas_vendido_layout;

public class MasVendidoListAdapter extends ArrayAdapter<MasVendidoPost> {

     private Context context;
     private List<MasVendidoPost> masVendidoPosts;

    public MasVendidoListAdapter(Context context, List<MasVendidoPost> masVendidoPosts){
        super(context, mas_vendido_layout,masVendidoPosts);
        this.context = context;
        this.masVendidoPosts=masVendidoPosts;
          }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        convertView= layoutInflater.inflate(mas_vendido_layout,parent,false);

        MasVendidoPost masVendidoPost=masVendidoPosts.get(position);
        TextView textViewPro= (TextView) convertView.findViewById(R.id.textViewProduct);
        textViewPro.setText(masVendidoPost.getTitulo());
        TextView textViewCant= (TextView) convertView.findViewById(R.id.textViewCant);
        textViewCant.setText(String.valueOf(masVendidoPost.getVentas()) );

        return convertView;
    }
}
