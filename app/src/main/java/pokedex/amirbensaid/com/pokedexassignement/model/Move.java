package pokedex.amirbensaid.com.pokedexassignement.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Move {

    /**
     * move : {"name":"transform","url":"https://pokeapi.co/api/v2/move/144/"}
     * version_group_details : [{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"ultra-sun-ultra-moon","url":"https://pokeapi.co/api/v2/version-group/18/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"sun-moon","url":"https://pokeapi.co/api/v2/version-group/17/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"omega-ruby-alpha-sapphire","url":"https://pokeapi.co/api/v2/version-group/16/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"x-y","url":"https://pokeapi.co/api/v2/version-group/15/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"black-2-white-2","url":"https://pokeapi.co/api/v2/version-group/14/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"xd","url":"https://pokeapi.co/api/v2/version-group/13/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"colosseum","url":"https://pokeapi.co/api/v2/version-group/12/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"black-white","url":"https://pokeapi.co/api/v2/version-group/11/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"heartgold-soulsilver","url":"https://pokeapi.co/api/v2/version-group/10/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"platinum","url":"https://pokeapi.co/api/v2/version-group/9/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"diamond-pearl","url":"https://pokeapi.co/api/v2/version-group/8/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"firered-leafgreen","url":"https://pokeapi.co/api/v2/version-group/7/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"emerald","url":"https://pokeapi.co/api/v2/version-group/6/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"ruby-sapphire","url":"https://pokeapi.co/api/v2/version-group/5/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"crystal","url":"https://pokeapi.co/api/v2/version-group/4/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"gold-silver","url":"https://pokeapi.co/api/v2/version-group/3/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"yellow","url":"https://pokeapi.co/api/v2/version-group/2/"}},{"level_learned_at":1,"move_learn_method":{"name":"level-up","url":"https://pokeapi.co/api/v2/move-learn-method/1/"},"version_group":{"name":"red-blue","url":"https://pokeapi.co/api/v2/version-group/1/"}}]
     */
    @SerializedName("move")
    @Expose
    private MoveType move;
    private List<VersionGroupDetail> version_group_details;

    public MoveType getMove() {
        return move;
    }

    public void setMove(MoveType move) {
        this.move = move;
    }

    public List<VersionGroupDetail> getVersion_group_details() {
        return version_group_details;
    }

    public void setVersion_group_details(List<VersionGroupDetail> version_group_details) {
        this.version_group_details = version_group_details;
    }
}
