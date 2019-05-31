package pokedex.amirbensaid.com.pokedexassignement.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import pokedex.amirbensaid.com.pokedexassignement.R;
import pokedex.amirbensaid.com.pokedexassignement.model.Pokemon;
import pokedex.amirbensaid.com.pokedexassignement.utils.Constants;
import pokedex.amirbensaid.com.pokedexassignement.views.PokemonsFragment;


public class PokemonsRecyclerViewAdapter extends RecyclerView.Adapter<PokemonsRecyclerViewAdapter.ViewHolder> {

    private final List<Pokemon> mValues;

    private  PokemonsFragment.OnListFragmentInteractionListener mListener;

    private final Context ctx;
    private OnLoadMoreListener onLoadMoreListener = null;

    public PokemonsRecyclerViewAdapter(Context ctx, PokemonsFragment.OnListFragmentInteractionListener listener) {

        this.ctx = ctx;

        mValues = new ArrayList<>();

        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_pokemon, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mItem = mValues.get(position);
        Picasso.get().load(Constants.IMAGES + holder.mItem.getNumber()+".png").into(holder.mPokemonImageView);
        holder.mPokemonNameView.setText(mValues.get(position).getName());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });

    }

    public void updatePokemonsList(List<Pokemon> listaPokemon) {

        mValues.addAll(listaPokemon);
        int positionStart = getItemCount();
        int itemCount = listaPokemon.size();
        notifyItemRangeInserted(positionStart, itemCount);
        //notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }
    public interface OnLoadMoreListener {
        void onLoadMore(int offset);
    }
    private void lastItemViewDetector(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            final LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    int lastPos = layoutManager.findLastVisibleItemPosition();
                    if (lastPos == getItemCount() - 1 && onLoadMoreListener != null) {
                        int offset = getItemCount();
                        onLoadMoreListener.onLoadMore(offset);
                    }
                }
            });
        }
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        lastItemViewDetector(recyclerView);
        super.onAttachedToRecyclerView(recyclerView);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final ImageView mPokemonImageView;
        public final TextView mPokemonNameView;
        public Pokemon mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mPokemonImageView = (ImageView) view.findViewById(R.id.pokemon_img);
            mPokemonNameView  = (TextView)  view.findViewById(R.id.pokemon_name);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mPokemonNameView.getText() + "'";
        }
    }
}
