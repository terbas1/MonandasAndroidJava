package edwinbaltazar.example.monadasglamour.Interface;

import java.util.List;


import edwinbaltazar.example.monadasglamour.Model.MasVendidoPost;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MasVendidosService {

    @GET("info5")
    Call<List<MasVendidoPost>> getMasVendidos();
}
