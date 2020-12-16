package com.example.ag_tiku_5;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    //http://gank.io/api/data/福利/20/1
    String sUrl = "http://gank.io/";
    @GET("api/data/福利/20/5")
    Observable<Bean> getData();

}
