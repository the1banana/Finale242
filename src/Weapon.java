/**
 * Created by the1banana on 11/7/2014.
 */
public class Weapon extends Item {
    private String name;
    //damage ranges based on rolling dies in ranges, minimum damage is min+#dies
    private int min;
    private int[] ranges;
    private int value;
    public Weapon(String name, int min, int[] ranges, int value){
        this.name = name;
        this.min = min;
        this.ranges = ranges;
        this.value = value;
    }

    public int getDamage(){
        int damage = min;
        for (int i = 0; i < ranges.length; i++){
            damage += Math.ceil(Math.random()*ranges[i]);
        }
        return damage;
    }

    public String getName(){ return name; };
    public String getDamageRange(){
        int minimum = min;
        int maximum = min;
        for(int i = 0; i < ranges.length; i++){
            minimum++;
            maximum += ranges[i];
        }
        return minimum + " - " + maximum;
    }
}
