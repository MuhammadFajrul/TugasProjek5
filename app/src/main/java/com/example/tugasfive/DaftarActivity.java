package com.example.tugasfive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tugasfive.Rest.ApiClient;
import com.example.tugasfive.Rest.ApiInterface;

import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button btndaftar;
    private EditText username,namalengkap,kontak,alamat,password;
    private ProgressDialog pd;
    private static final String TAG = DaftarActivity.class.getSimpleName();
    ApiInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        toolbar = findViewById(R.id.toolbar2);
        toolbar.setTitle("Daftar");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btndaftar = findViewById(R.id.button_daftar);

        username = findViewById(R.id.edit_username);
        apiService = ApiClient.getClient().create(ApiInterface.class);
        namalengkap = findViewById(R.id.edit_namalengkap);
        kontak = findViewById(R.id.edit_Kontak);
        alamat = findViewById(R.id.edit_alamat);
        password = findViewById(R.id.edit_password);

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

    }
    public void signup() {
        Log.d(TAG,"Menjalankan method Signup");
        pd = ProgressDialog.show(this,null,"Sedang mendaftarkan account",true,false);
        String strUsername = username.getText().toString();
        String strPassword = password.getText().toString();
        String strNamaLengkap = namalengkap.getText().toString();
        String stralamat = alamat.getText().toString();
        Integer strkontak = Integer.parseInt(kontak.getText().toString());

        Log.d(TAG,"mendapatkan data dari edit text");

        apiService.insertdata(strUsername,strNamaLengkap,strkontak,stralamat,strPassword).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG,"berhasil memanggil api");
                if (response.isSuccessful()){
                    pd.dismiss();
                    Log.d(TAG,"succes mendapatkan api");
                    Intent i = new Intent(DaftarActivity.this,MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                    finish();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                pd.dismiss();
                Log.e(TAG,t.getLocalizedMessage());
                Toast.makeText(getApplicationContext(),"Gagal",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent i = new Intent(DaftarActivity.this,MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);

    }


}