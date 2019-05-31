package pokedex.amirbensaid.com.pokedexassignement.presenters;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import pokedex.amirbensaid.com.pokedexassignement.PokeApi;
import pokedex.amirbensaid.com.pokedexassignement.model.OnePokemonResponse;
import pokedex.amirbensaid.com.pokedexassignement.views.IPokemonDetailView;

public class PokemonDetailPresenter {
    IPokemonDetailView view;
    CompositeDisposable subscriptions = new CompositeDisposable();
    public PokemonDetailPresenter(IPokemonDetailView view) {
        this.view = view;
    }
    public void loadPokemonDetail(String name) {
        view.displayLoadingProgress();
        subscriptions.add(
                PokeApi.getRetrofit().getPokemonDetails(name).observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io()).subscribeWith(
                        new DisposableObserver<OnePokemonResponse>() {
                            @Override
                            public void onNext(OnePokemonResponse onePokemonResponse) {
                                if (onePokemonResponse==null) {
                                    view.displayNoDataFound();
                                } else {
                                    view.displayPokemonDetail(onePokemonResponse);
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
