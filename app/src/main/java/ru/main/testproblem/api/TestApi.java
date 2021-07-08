package ru.main.testproblem.api;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.main.testproblem.Model.Textmodel;

public interface TestApi {

    @GET("upcomingGuides")
    Call<Textmodel> getDates();
}
