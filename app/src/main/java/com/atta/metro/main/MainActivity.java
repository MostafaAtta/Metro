package com.atta.metro.main;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.atta.metro.MapFragment;
import com.atta.metro.R;
import com.atta.metro.model.MetroStation;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, MainContract.View {
    private BottomNavigationView navView;
    MainPresenter mainPresenter;
    List<MetroStation> metroStations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navView = findViewById(R.id.nav_view);


        navView.setOnNavigationItemSelectedListener(this);
        mainPresenter = new MainPresenter(this, this);
        mainPresenter.getStations();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.navigation_map:
                if (this.metroStations.size() == 0){
                    mainPresenter.getStations();
                }else {

                    fragment = new MapFragment(this.metroStations);
                }
                break;
            case R.id.navigation_stations:

                break;
            case R.id.navigation_metro:

                break;
        }
        return loadFragment(fragment);
    }


    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void showMessage(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMap(List<MetroStation> metroStations) {

        this.metroStations = metroStations;
        //loading the default fragment
        loadFragment(new MapFragment(this.metroStations));
    }
}
