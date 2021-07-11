package edwinbaltazar.example.monadasglamour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    EditText email,password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.edEmail);
        password=findViewById(R.id.edPassword);
        btnLogin=findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email.getText().toString())|| TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(MainActivity.this,"Email/Password son Necesarios",Toast.LENGTH_LONG).show();
                }else{
                    //Proceso para logear
                    login();
                }
            }
        });
    }
    public void login(){
        LoginRequest loginRequest =new LoginRequest();
        loginRequest.setCorreo(email.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        Call<LoginResponse> loginResponseCall= ApiClient.getUserService().userLogin( loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Bienvenido",Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse= response.body();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            LoginResponse loginResponse= response.body();
                            startActivity(new Intent(MainActivity.this,TableroActivity.class).putExtra("data",loginResponse.getPerfil()));
                        }
                    },700);

                }else{
                    Toast.makeText(MainActivity.this,"Credenciales incorrectas",Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Throwable"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

}