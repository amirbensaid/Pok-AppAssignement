package pokedex.amirbensaid.com.pokedexassignement.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ability {


    /**
     * ability : {"name":"imposter","url":"https://pokeapi.co/api/v2/ability/150/"}
     * is_hidden : true
     * slot : 3
     */
    @SerializedName("ability")
    @Expose
    private AbilityType ability;
    private boolean is_hidden;
    private int slot;

    public AbilityType getAbility() {
        return ability;
    }

    public void setAbility(AbilityType ability) {
        this.ability = ability;
    }

    public boolean isIs_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(boolean is_hidden) {
        this.is_hidden = is_hidden;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

}
