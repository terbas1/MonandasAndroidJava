package edwinbaltazar.example.monadasglamour.Interface;

import java.util.List;


import edwinbaltazar.example.monadasglamour.Model.VisitaPost;
import retrofit2.Call;
import retrofit2.http.GET;

public interface VisitasService {
    @GET("info2")
    Call<List<VisitaPost>> getVisitas();
}
