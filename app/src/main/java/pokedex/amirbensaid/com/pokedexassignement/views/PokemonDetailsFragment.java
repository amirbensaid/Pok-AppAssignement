package pokedex.amirbensaid.com.pokedexassignement.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pokedex.amirbensaid.com.pokedexassignement.R;
import pokedex.amirbensaid.com.pokedexassignement.model.Ability;
import pokedex.amirbensaid.com.pokedexassignement.model.Move;
import pokedex.amirbensaid.com.pokedexassignement.model.OnePokemonResponse;
import pokedex.amirbensaid.com.pokedexassignement.model.Stat;
import pokedex.amirbensaid.com.pokedexassignement.presenters.PokemonDetailPresenter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PokemonDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PokemonDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PokemonDetailsFragment extends Fragment implements IPokemonDetailView {

    private ImageView pokemonImageView;
     TextView mWeight,mHeight,mExperience,mMoves,mAbilities,mName;
     LinearLayout mStats;
     View parentView;
     ProgressBar progressBar;
     View details;
    PokemonDetailPresenter pokemonDetailPresenter;
    private static final String ARG_POKEMON_NAME = "pokemon_name";

    private String mPokemonName;

    private OnFragmentInteractionListener mListener;

    public PokemonDetailsFragment() {
        // Required empty public constructor
    }

    public static PokemonDetailsFragment newInstance(String pokemonName) {
        PokemonDetailsFragment fragment = new PokemonDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_POKEMON_NAME, pokemonName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPokemonName = getArguments().getString(ARG_POKEMON_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pokemon_details, container, false);
        parentView =v;
        mAbilities =v.findViewById(R.id.tv_abilities);
        mExperience =v.findViewById(R.id.tv_experience);
        mHeight =v.findViewById(R.id.tv_height);
        mWeight =v.findViewById(R.id.tv_weight);
        mMoves = v .findViewById(R.id.tv_moves);
        mName = v.findViewById(R.id.tv_pokemon_name);
        progressBar = v.findViewById(R.id.progressBar);
        details = v.findViewById(R.id.details);
        pokemonDetailPresenter = new PokemonDetailPresenter(this);
        pokemonImageView = (ImageView) v.findViewById(R.id.pokemon_img);
        mStats = v.findViewById(R.id.llStats);
        pokemonDetailPresenter.loadPokemonDetail(getArguments().getString(ARG_POKEMON_NAME));

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void displayLoadingProgress() {
        details.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayNoDataFound() {

    }

    @Override
    public void displayPokemonDetail(OnePokemonResponse onePokemonResponse) {
        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+onePokemonResponse.getId()+".png").into(pokemonImageView);
        mAbilities.setText(getAbilities(onePokemonResponse.getAbilities()));
        mExperience.setText(onePokemonResponse.getBase_experience()+"");
        mHeight.setText(onePokemonResponse.getHeight()+"");
        mWeight.setText(onePokemonResponse.getWeight()+"");
        mMoves.setText(getMoves(onePokemonResponse.getMoves()));
        mName.setText(onePokemonResponse.getName());
        displayStats(onePokemonResponse.getStats());
    }
    private String getAbilities(List<Ability> abilities){
        if(!abilities.isEmpty()){
            StringBuilder result = new StringBuilder();
            for(Ability a : abilities){
                result.append(a.getAbility().getName()).append(", ");
            }
            return result.toString();
        }
        return "nothing to display";
    }
    private String getMoves(List<Move> moves){
        if(!moves.isEmpty()){
            StringBuilder result = new StringBuilder();
            for(Move m : moves){
                result.append(m.getMove().getName()).append(", ");
            }
            return result.toString();
        }
        return "nothing to display";
    }
    private void displayStats(List<Stat> stats){
        for(Stat s :stats){
            View v = getLayoutInflater().inflate(R.layout.item_stat, (ViewGroup) parentView, false);
            TextView tv = v.findViewById(R.id.tv_stat_name);
            tv.setText(s.getStat().getName());
            View vv = v.findViewById(R.id.v_base_stat);
            ((LinearLayout.LayoutParams)vv.getLayoutParams()).weight = s.getBase_stat();
            vv.requestLayout();
            mStats.addView(v);
        }

    }
    @Override
    public void displayError(Throwable e) {
        Log.d("TAG",e.getLocalizedMessage());
    }

    @Override
    public void dismissLoadingProgress() {
        details.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
