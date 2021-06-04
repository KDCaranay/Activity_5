package com.example.activity_5.Retrofit;

import org.json.JSONObject;

public interface RetrofitInterface {
    @GET("v6/86f98363b00284f9ed4643b/latest/USD")
    Call<JSONObject> getExchangeCurrency(@Path("currency")String currency)



}
