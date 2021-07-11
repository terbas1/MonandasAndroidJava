package edwinbaltazar.example.monadasglamour.Interface;

import java.util.List;

import edwinbaltazar.example.monadasglamour.Model.UsuarioPost;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UsuariosService {

    @GET("info3")
    Call<List<UsuarioPost>> getUsuarios();
}
