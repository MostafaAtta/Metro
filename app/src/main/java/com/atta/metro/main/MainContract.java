package com.atta.metro.main;

import com.atta.metro.model.MetroStation;

import java.util.List;

public interface MainContract {



    interface View{

        void showMessage(String error);

        void showMap(List<MetroStation> metroStations);

    }

    interface Presenter{

        void getStations() ;


    }
}
