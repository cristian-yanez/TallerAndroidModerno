package usm.pato.countryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import usm.pato.countryapp.api.CountryAppApi;
import usm.pato.countryapp.model.Country;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CountryAppApi api = retrofit.create(CountryAppApi.class);

        api.getCountry().enqueue(new Callback<Country[]>() {
            @Override
            public void onResponse(Call<Country[]> call, Response<Country[]> response) {
                if(response.isSuccessful()){
                    Country c[] = response.body();
                    for (Country actualCountry: c) {
                        Log.d("taller", actualCountry.getName()+" pertenece al continente "+actualCountry.getRegion());
                    }
                }
            }

            @Override
            public void onFailure(Call<Country[]> call, Throwable t) {
                Log.v("taller", "Error: "+t.getMessage());
            }
        });
    }
}
