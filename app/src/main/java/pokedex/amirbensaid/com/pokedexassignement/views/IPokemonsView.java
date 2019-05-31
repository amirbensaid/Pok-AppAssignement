package pokedex.amirbensaid.com.pokedexassignement.views;

import java.util.List;

import pokedex.amirbensaid.com.pokedexassignement.model.Pokemon;


public interface IPokemonsView {
    void displayLoadingProgress();

    void displayError(Throwable e);

    void dismissLoadingProgress();

    void displayPokemons(List<Pokemon> pokemonList);

    void displayNoDataFound();
}
