package edwinbaltazar.example.monadasglamour.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MasVendidoPost {
    @SerializedName("titulo")
   private String titulo;
    @SerializedName("ventas")
   private String ventas;

    public MasVendidoPost(String titulo, String ventas){
        this.titulo = titulo;
        this.ventas=ventas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getVentas() {
        return ventas;
    }

    public void setVentas(String ventas) {
        this.ventas = ventas;
    }
}

