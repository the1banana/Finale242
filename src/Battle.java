/**
 * Created by the1banana on 11/14/2014.
 */
public class Battle {
    //IT IS IMPORTANT TO NOTE THAT ON_HEALTH_ABOVE MUST BE IMPLEMENTED IF ON_HEALTH_BELOW IS, AND VICE VERSA

    private Unit[] player;
    private Unit[] enemy;

    public Battle(Unit[] player, Unit[] enemy){
        this.player = player;
        this.enemy = enemy;
    }


}
