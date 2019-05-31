package pokedex.amirbensaid.com.pokedexassignement;

import io.reactivex.Observable;
import pokedex.amirbensaid.com.pokedexassignement.model.OnePokemonResponse;
import pokedex.amirbensaid.com.pokedexassignement.model.PokemonResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokemonService {

    @GET("pokemon")
    Observable<PokemonResponse> obtenerListaPokemon(@Query("limit") int limit, @Query("offset") int offset);
    @GET("pokemon/{name}")
    Observable<OnePokemonResponse> getPokemonDetails(@Path("name") String name);
}
