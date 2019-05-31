package pokedex.amirbensaid.com.pokedexassignement.views;


import pokedex.amirbensaid.com.pokedexassignement.model.OnePokemonResponse;

public interface IPokemonDetailView {
    void displayLoadingProgress();

    void displayNoDataFound();

    void displayPokemonDetail(OnePokemonResponse onePokemonResponse);

    void displayError(Throwable e);

    void dismissLoadingProgress();
}
