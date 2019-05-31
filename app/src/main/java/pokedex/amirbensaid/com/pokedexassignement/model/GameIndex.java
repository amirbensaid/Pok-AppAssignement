package pokedex.amirbensaid.com.pokedexassignement.model;

public class GameIndex {

    /**
     * game_index : 132
     * version : {"name":"white-2","url":"https://pokeapi.co/api/v2/version/22/"}
     */

    private int game_index;
    private Version version;

    public int getGame_index() {
        return game_index;
    }

    public void setGame_index(int game_index) {
        this.game_index = game_index;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

}
