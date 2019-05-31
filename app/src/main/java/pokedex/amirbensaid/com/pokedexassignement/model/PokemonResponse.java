package pokedex.amirbensaid.com.pokedexassignement.model;

import java.util.ArrayList;

public class PokemonResponse {

    private ArrayList<Pokemon> results;

    public PokemonResponse() {
    }

    public PokemonResponse(ArrayList<Pokemon> results) {
        this.results = results;
    }

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
