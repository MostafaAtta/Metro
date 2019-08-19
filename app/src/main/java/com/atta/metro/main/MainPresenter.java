package com.atta.metro.main;

import android.content.Context;

import com.atta.metro.model.APIService;
import com.atta.metro.model.APIUrl;
import com.atta.metro.model.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPresenter implements MainContract.Presenter {


    private MainContract.View mView;

    private Context mContext;

    public MainPresenter(MainContract.View view, Context context) {

        mView = view;

        mContext = context;
    }

    @Override
    public void getStations() {

        //building retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Defining retrofit api service
        APIService service = retrofit.create(APIService.class);


        //defining the call
        Call<Result> call = service.getStations();

        //calling the api
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, retrofit2.Response<Result> response) {


                //displaying the message from the response as toast
                if (response.body() != null){
                    if (response.body().getMetroStations().size() != 0) {

                        mView.showMap(response.body().getMetroStations());
                    }else {
                        mView.showMessage("an error has occurred");
                    }

                }

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

                mView.showMessage(t.getMessage());
            }
        });
    }
}


