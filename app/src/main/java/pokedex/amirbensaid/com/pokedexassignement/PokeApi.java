package pokedex.amirbensaid.com.pokedexassignement;
import io.reactivex.schedulers.Schedulers;
import pokedex.amirbensaid.com.pokedexassignement.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokeApi {


    public static PokemonService getRetrofit(){
        RxJava2CallAdapterFactory rxAdapter = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io());
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(rxAdapter)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(PokemonService.class);
    }
}
