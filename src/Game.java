/**
 * Created by the1banana on 11/7/2014.
 */
public class Game {
    Room[] rooms;
    Character[] party;
    String name;
    public Game (String name, Character[] startingParty){
        this.name = name;
        this.party = startingParty;
    }
}
