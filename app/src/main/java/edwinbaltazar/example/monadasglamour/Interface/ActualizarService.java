package edwinbaltazar.example.monadasglamour.Interface;

import java.util.List;

import edwinbaltazar.example.monadasglamour.Model.ActualizarPost;
import edwinbaltazar.example.monadasglamour.Model.ActualizarResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PUT;

public interface ActualizarService {

    @PUT("listaVentas/actualizar")
    Call<ActualizarResponse> putVenta(@Body ActualizarPost actualizarPost);
}
