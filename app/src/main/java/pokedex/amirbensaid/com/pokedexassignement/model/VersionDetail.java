package pokedex.amirbensaid.com.pokedexassignement.model;

public class VersionDetail {

    /**
     * rarity : 5
     * version : {"name":"ultra-sun","url":"https://pokeapi.co/api/v2/version/29/"}
     */

    private int rarity;
    private Version version;

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

}
