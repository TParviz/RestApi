package ru.main.testproblem.View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.main.testproblem.Model.Textmodel;
import ru.main.testproblem.Utils;

public class HomePresents {

    private HomeView view;


    public HomePresents(HomeView view) {
        this.view = view;
    }

    public void getDates() {

        Call<Textmodel> datesCall = Utils.getApi().getDates();
        datesCall.enqueue(new Callback<Textmodel>() {


            @Override
            public void onResponse(Call<Textmodel> call, Response<Textmodel> response) {
                if (response.isSuccessful() && response.body() != null) {

                    view.setDates(response.body().getDates());

                }
            }

            @Override
            public void onFailure(Call<Textmodel> call, Throwable t) {

            }
        });
    }


}
