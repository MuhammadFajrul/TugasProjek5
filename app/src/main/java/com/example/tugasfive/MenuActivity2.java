package com.example.tugasfive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity2 extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        bottomNavigationView = findViewById(R.id.bottomnavview);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomnavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.Kontainer,new HomeFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener bottomnavMethod = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment=null;
            switch (item.getItemId()){
                case R.id.homeFragment:
                    fragment= new HomeFragment();
                    break;
                case R.id.berandaFragment:
                    fragment= new BerandaFragment();
                    break;
                case R.id.profilFragment:
                    fragment= new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.Kontainer,fragment).commit();
            return true;
        }
    };


}