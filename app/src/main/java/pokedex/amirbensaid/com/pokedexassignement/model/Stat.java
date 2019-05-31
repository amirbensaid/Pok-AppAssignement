package pokedex.amirbensaid.com.pokedexassignement.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stat {

    /**
     * base_stat : 48
     * effort : 0
     * stat : {"name":"speed","url":"https://pokeapi.co/api/v2/stat/6/"}
     */

    private int base_stat;
    private int effort;
    @SerializedName("stat")
    @Expose
    private StatType stat;

    public int getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(int base_stat) {
        this.base_stat = base_stat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public StatType getStat() {
        return stat;
    }

    public void setStat(StatType stat) {
        this.stat = stat;
    }

}
