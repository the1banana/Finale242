/**
 * Created by the1banana on 11/7/2014.
 */
public class Weapon extends Item {
    private String name;
    //damage ranges from min to min+range
    private int min;
    private int range;
    private int value;
    public Weapon(String name, int min, int range, int value){
        this.name = name;
        this.min = min;
        this.range = range;
        this.value = value;
    }

    public int getDamage(){
        return (int)Math.floor(min + Math.random()*(range+1));
    }
}
