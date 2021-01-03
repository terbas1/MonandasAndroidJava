package edwinbaltazar.example.monadasglamour;

import edwinbaltazar.example.monadasglamour.Interface.ActualizarService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiPut {
    private static Retrofit getRetrofit(){
        HttpLoggingInterceptor httpLoggingInterceptor =new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient= new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit= new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://ecommerce121942.herokuapp.com/")
                .client(okHttpClient)
                .build();
        return retrofit;
    }
    public static ActualizarService getAtualizarService(){
        ActualizarService actualizarService=getRetrofit().create(ActualizarService.class);
        return actualizarService;
    }
}
