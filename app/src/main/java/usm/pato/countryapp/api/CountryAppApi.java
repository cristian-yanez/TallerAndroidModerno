package usm.pato.countryapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import usm.pato.countryapp.model.Country;

/**
 * Created by Cristian on 05-04-2016.
 */
public interface CountryAppApi {
    @GET("all")
    Call<Country[]> getCountry();
}
