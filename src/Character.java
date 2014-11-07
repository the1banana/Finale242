/**
 * Created by the1banana on 11/7/2014.
 */
public class Character {
    private int maxHealth;
    private int currHealth;
    private Attribute[] stats;
    private Attribute[] currStats;
    private Item[] inventory;
    private Weapon weapon;
    String name;

    public Character(){
        name = "Hero";
        maxHealth = 100;
        currHealth = 100;
        stats = null;
        currStats = null;
        inventory = new Item[64];
        weapon = null;
    }
}
