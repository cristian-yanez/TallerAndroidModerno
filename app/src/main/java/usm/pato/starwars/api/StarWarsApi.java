package usm.pato.starwars.api;

import retrofit2.Call;
import retrofit2.http.GET;
import usm.pato.starwars.model.Country;

/**
 * Created by Cristian on 05-04-2016.
 */
public interface StarWarsApi {

    @GET("name/chile")
    Call<Country> getCountry();
}
