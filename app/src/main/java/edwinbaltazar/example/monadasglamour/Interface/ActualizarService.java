package edwinbaltazar.example.monadasglamour.Interface;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.PUT;

public interface ActualizarService {
    @PUT("listaVentas/actualizar")
    Call<List<ActualizarService>> putVenta();
}
