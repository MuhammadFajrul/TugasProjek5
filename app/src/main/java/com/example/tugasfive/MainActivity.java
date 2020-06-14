package com.example.tugasfive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tugasfive.Respon.responLogin;
import com.example.tugasfive.Rest.ApiClient;
import com.example.tugasfive.Rest.ApiInterface;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button buttonsigin,buttondaftar;
    EditText editusername;
    EditText editpassword;

    ApiInterface apiservice;
    private static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonsigin = findViewById(R.id.button_signin);
        buttondaftar = findViewById(R.id.btn_daftar);
        editusername = findViewById(R.id.username);
        editpassword = findViewById(R.id.password);
        apiservice = ApiClient.getClient().create(ApiInterface.class);

        buttondaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DaftarActivity.class);
                startActivity(intent);
            }
        });
        buttonsigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

    }
    private void loginUser(){
        String username= editusername.getText().toString();
        String password= editpassword.getText().toString();

        apiservice.login(username,password).enqueue(new Callback<responLogin>() {
            @Override
            public void onResponse(Call<responLogin> call, Response<responLogin> response) {
                if (response.isSuccessful()){

                    Intent intent = new Intent(MainActivity.this, MenuActivity2.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                    finish();
                }else if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this ,"user tidak ditemukan",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<responLogin> call, Throwable t) {
                Log.e(TAG,"onFailure"+t.getLocalizedMessage());
                Toast.makeText(MainActivity.this ,"gagal terhubung ke server",Toast.LENGTH_LONG).show();
            }
        });
    }
}