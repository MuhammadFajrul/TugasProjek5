package com.example.tugasfive.Rest;

import com.example.tugasfive.Respon.responLogin;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("Login.php")
    Call<responLogin>login(
            @Field("username")String username,@Field("password")String password);
    @FormUrlEncoded
    @POST("inserData.php")
    Call<ResponseBody>insertdata(
            @Field("username")String username,
            @Field("nama_lengkap")String nama_lengkap,
            @Field("kontak")Integer kontak,
            @Field("alamat")String alamat,
            @Field("password")String password
    );
}
