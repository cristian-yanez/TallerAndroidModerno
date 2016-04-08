package usm.pato.starwars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import usm.pato.starwars.api.StarWarsApi;
import usm.pato.starwars.model.Country;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        StarWarsApi api = retrofit.create(StarWarsApi.class);

        api.getCountry().enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {
                if(response.isSuccessful()){
                    Country c = response.body();
                    Log.d("taller", c.name);
                }
            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {

            }
        });
    }
}
