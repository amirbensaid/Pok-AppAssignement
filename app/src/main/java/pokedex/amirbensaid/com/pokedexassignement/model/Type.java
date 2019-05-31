package pokedex.amirbensaid.com.pokedexassignement.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Type {

    /**
     * slot : 1
     * type : {"name":"normal","url":"https://pokeapi.co/api/v2/type/1/"}
     */

    private int slot;
    @SerializedName("type")
    @Expose
    private TypeType type;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public TypeType getType() {
        return type;
    }

    public void setType(TypeType type) {
        this.type = type;
    }

}
