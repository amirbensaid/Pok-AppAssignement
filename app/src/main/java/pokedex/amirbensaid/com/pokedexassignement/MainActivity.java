package pokedex.amirbensaid.com.pokedexassignement;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import pokedex.amirbensaid.com.pokedexassignement.model.Pokemon;
import pokedex.amirbensaid.com.pokedexassignement.views.PokemonDetailsFragment;
import pokedex.amirbensaid.com.pokedexassignement.views.PokemonsFragment;


public class MainActivity extends AppCompatActivity implements
        PokemonsFragment.OnListFragmentInteractionListener,
        PokemonDetailsFragment.OnFragmentInteractionListener {

    FragmentTransaction ft;
    PokemonsFragment pokemonsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        if(pokemonsFragment == null){
            pokemonsFragment = new PokemonsFragment();
        }
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container,pokemonsFragment);
        ft.commit();
    }

    @Override
    public void onListFragmentInteraction(Pokemon item) {
        PokemonDetailsFragment pokemonDetails =  PokemonDetailsFragment.newInstance(item.getName());
        openFragment(pokemonDetails);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    private void openFragment(final Fragment fragment)   {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
