package pokedex.amirbensaid.com.pokedexassignement.presenters;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import pokedex.amirbensaid.com.pokedexassignement.PokeApi;
import pokedex.amirbensaid.com.pokedexassignement.model.PokemonResponse;
import pokedex.amirbensaid.com.pokedexassignement.views.IPokemonsView;

public class PokemonsPresenter {
    IPokemonsView view;
    CompositeDisposable subscriptions = new CompositeDisposable();
    public PokemonsPresenter(IPokemonsView view) {
        this.view = view;
    }
    public void loadPokemons(int limit, int offset) {
        view.displayLoadingProgress();
        subscriptions.add(
                PokeApi.getRetrofit().obtenerListaPokemon(limit,offset).observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io()).subscribeWith(
                        new DisposableObserver<PokemonResponse>() {
                            @Override
                            public void onNext(PokemonResponse pokemonResponse) {
                                if (pokemonResponse.getResults().isEmpty()) {
                                    view.displayNoDataFound();
                                } else {
                                    view.displayPokemons(pokemonResponse.getResults());
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                view.displayError(e);
                            }

                            @Override
                            public void onComplete() {
                                view.dismissLoadingProgress();
                            }
                        }
                )
        );
    }
    public void unsubscribe(){
        subscriptions.clear();
    }
}
