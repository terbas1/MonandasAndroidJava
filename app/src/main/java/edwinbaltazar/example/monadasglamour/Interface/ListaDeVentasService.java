package edwinbaltazar.example.monadasglamour.Interface;

import java.util.List;

import edwinbaltazar.example.monadasglamour.Model.ListaDeVentas;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ListaDeVentasService {
    @GET("listVenta")
    Call<List<ListaDeVentas>> getListaVentas();
}
