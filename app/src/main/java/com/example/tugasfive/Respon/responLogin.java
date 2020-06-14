package com.example.tugasfive.Respon;

import com.example.tugasfive.model.user;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class responLogin {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("pesan")
    @Expose
    private String pesan;
    @SerializedName("data")
    @Expose
    private user user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user data) {
        this.user = user;
    }

}
