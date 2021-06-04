package com.example.activity_5;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.activity_5.Retrofit.RetrofitBuilder;
import com.example.activity_5.Retrofit.RetrofitInterface;

import javax.security.auth.callback.Callback;

public class MainActivity extends AppCompatActivity {
    private final Object t;
    Button button_convert;
    EditText text_base_currency,text_result_currency;
    Spinner spinner_from_currency,spinner_to_currency;
    private Object response;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_convert = (Button) findViewById(R.id.btn_convert);
        text_base_currency = (EditText)findViewById(R.id.txt_base_currency_header);
        text_result_currency = (EditText)findViewById(R.id.txt_to_currency_header);
        spinner_from_currency = (Spinner)findViewById(R.id.spin_from_currency);
        spinner_to_currency = (Spinner) findViewById(R.id.spin_to_currency);

        String [] dropDownlist = ("USD", "EUR","KRW", "JPY", "PHP");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,dropDownlist);
        spinner_from_currency.setAdapter(adapter);
        spinner_to_currency.setAdapter(adapter);

        button_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick Object view;
            (view view){
                RetrofitInterface retrofitInterface = RetrofitBuilder.getRetrofitInstance()

                Call<JsonObjects> call = retrofitInterface.getExchangeCurrency(spinner_from_currency.getSelectedItem().toString());
                Call.enqueue(new Callback<JsonObjects>() {
                    void log.d("response".String.valueOf(resposne.body()));
                    Toast.makeText(MainActivity.this, "Computed", Toast.LENGTH_SHORT).show();
                    JsonObjects res = response.body();
                    JsonObjects rates = res.getAsJsonObject("conversion_rates");
                    Double currency = Double.valueOf(rates.get(text_base_currency.getText()).toString))));
                    Double multiplier = Double.valueOf(rates.get(spinner_to_currency.getSelectedItem().toString().toString()));
                    Double result =  currency * multiplier;
                    text_result_currency.setText(String.valueOf(result));


                }

                @Override
                        public void onFailure(call, Throwable t) {

                }


            });
        }
        });



    }

    private class JsonObjects {
    }
}