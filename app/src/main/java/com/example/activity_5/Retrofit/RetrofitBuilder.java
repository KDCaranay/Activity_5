package com.example.activity_5.Retrofit;


public class RetrofitBuilder {
    private static Retrofit retrofit;
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) ;
        retrofit = new RetrofitBuilder().baseUri("http://v6.exchangerate.api.com/").addConverterFactory(GsonConverterFactory.create()).build();

    }return retrofit;



    }

    private Retrofit baseUri(String s) {
    }
}
