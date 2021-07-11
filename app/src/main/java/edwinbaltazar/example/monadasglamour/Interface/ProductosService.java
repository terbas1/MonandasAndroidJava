package edwinbaltazar.example.monadasglamour.Interface;

import java.util.List;

import edwinbaltazar.example.monadasglamour.Model.ProductoPost;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductosService {
    @GET("info4")
    Call<List<ProductoPost>> getProductos();
}
