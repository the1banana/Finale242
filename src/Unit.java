/**
 * Created by the1banana on 11/7/2014.
 */
public class Unit {
    private int maxHealth;
    private int currHealth;
    private int maxMana;
    private int currMana;
    private int strength;
    private Item[] inventory;
    private Weapon weapon;
    private Ability basicAttack;
    String name;

    public Unit(){
        name = "Hero";
        maxHealth = 100;
        currHealth = 100;
        maxMana = 20;
        currMana = 20;
        strength = 12;
        inventory = new Item[64];
        weapon = null;
        basicAttack = new BasicAttack(this);
    }

    public void takeDamage(int damage, boolean magic){
        this.currHealth -= damage;
    }

    public void setWeapon(Weapon weapon){this.weapon = weapon;}
    public Weapon getWeapon (){ return weapon; }
    public int getCurrHealth() {return currHealth; }
    public int getStrength(){ return strength; }
    public Ability getAttack() { return basicAttack; }
}
