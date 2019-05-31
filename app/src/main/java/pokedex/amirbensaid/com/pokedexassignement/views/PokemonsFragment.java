package pokedex.amirbensaid.com.pokedexassignement.views;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import pokedex.amirbensaid.com.pokedexassignement.R;
import pokedex.amirbensaid.com.pokedexassignement.adapters.PokemonsRecyclerViewAdapter;
import pokedex.amirbensaid.com.pokedexassignement.model.Pokemon;
import pokedex.amirbensaid.com.pokedexassignement.presenters.PokemonsPresenter;
import pokedex.amirbensaid.com.pokedexassignement.utils.ConnectivityHelper;


/**
 * A fragment representing a list of Pokemons.
 * <p/>
 * Activities containing this fragment MUST implement the {@link PokemonsFragment.OnListFragmentInteractionListener}
 * interface.
 */
public class PokemonsFragment extends Fragment implements IPokemonsView {

    private boolean loading;

    private RecyclerView recyclerView;

    PokemonsRecyclerViewAdapter pokemonsListAdapter;
    Context context;
    ProgressBar mProgressBar;
    View onlineUi;
    View offlineUi;
    private View parent_view;
    PokemonsPresenter pokemonsPresenter;
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private PokemonsFragment.OnListFragmentInteractionListener mListener;

    public PokemonsFragment() {

    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public PokemonsFragment newInstance(int columnCount) {
        PokemonsFragment fragment = new PokemonsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pokemons_list, container, false);
        parent_view =view;
        context = view.getContext();
        pokemonsPresenter = new PokemonsPresenter(this);
        recyclerView = view.findViewById(R.id.list);
        mProgressBar = view.findViewById(R.id.progressBar);
        onlineUi = view.findViewById(R.id.online_view);
        offlineUi = view.findViewById(R.id.offline_view);
        offlineUi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInternetConnectivity();
            }
        });

        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);

        recyclerView.setLayoutManager(layoutManager);
        checkInternetConnectivity();
        return view;
    }

    private void checkInternetConnectivity() {
        if (ConnectivityHelper.isConnectedToNetwork(context)) {
            showConnectedUi();
        } else {
            showDisconnectedUi();
        }
    }

    private void showDisconnectedUi() {
        onlineUi.setVisibility(View.GONE);
        offlineUi.setVisibility(View.VISIBLE);
    }

    private void showConnectedUi() {
        onlineUi.setVisibility(View.VISIBLE);
        offlineUi.setVisibility(View.GONE);
        pokemonsListAdapter = new PokemonsRecyclerViewAdapter(context, mListener);
        recyclerView.setAdapter(pokemonsListAdapter);
        pokemonsListAdapter.setOnLoadMoreListener(new PokemonsRecyclerViewAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore(int offset) {
                if (!loading) {
                    pokemonsPresenter.loadPokemons(20, offset);
                }
            }
        });
        pokemonsPresenter.loadPokemons(20, 0);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PokemonsFragment.OnListFragmentInteractionListener) {
            mListener = (PokemonsFragment.OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        pokemonsPresenter.unsubscribe();
    }

    @Override
    public void displayLoadingProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        loading = true;
    }

    @Override
    public void displayError(Throwable e) {

    }

    @Override
    public void dismissLoadingProgress() {
        mProgressBar.setVisibility(View.GONE);
        loading = false;
    }

    @Override
    public void displayPokemons(List<Pokemon> pokemonList) {
        pokemonsListAdapter.updatePokemonsList(pokemonList);
    }

    @Override
    public void displayNoDataFound() {
        Snackbar snackbar = Snackbar.make(parent_view, "Response from server was empty", Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInternetConnectivity();
            }
        });
        snackbar.show();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Pokemon item);
    }
}
