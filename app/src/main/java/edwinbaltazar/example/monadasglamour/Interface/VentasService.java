package edwinbaltazar.example.monadasglamour.Interface;

import java.util.List;

import edwinbaltazar.example.monadasglamour.Model.VentaPost;
import retrofit2.Call;
import retrofit2.http.GET;

public interface VentasService {
    @GET("info1")
    Call<List<VentaPost>> getVenta();

}
