package pokedex.amirbensaid.com.pokedexassignement.model;

public class VersionGroupDetail {

    /**
     * level_learned_at : 1
     * move_learn_method : {"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"}
     * version_group : {"name":"ultra-sun-ultra-moon","url":"https://pokeapi.co/api/v2/version-group/18/"}
     */

    private int level_learned_at;
    private MoveLearnMethod move_learn_method;
    private VersionGroup version_group;

    public int getLevel_learned_at() {
        return level_learned_at;
    }

    public void setLevel_learned_at(int level_learned_at) {
        this.level_learned_at = level_learned_at;
    }

    public MoveLearnMethod getMove_learn_method() {
        return move_learn_method;
    }

    public void setMove_learn_method(MoveLearnMethod move_learn_method) {
        this.move_learn_method = move_learn_method;
    }

    public VersionGroup getVersion_group() {
        return version_group;
    }

    public void setVersion_group(VersionGroup version_group) {
        this.version_group = version_group;
    }

}
