import java.util.ArrayList;

/**
 * Created by the1banana on 11/7/2014.
 */
public class Unit {
    private int maxHealth, currHealth, healthperlvl;
    private int maxMana, currMana, manaperlvl;
    private int strength, currStrength, strperlvl;
    private int magic, currMagic, magperlvl;
    private int dexterity, currDexterity, dexperlvl;
    private int wisdom, currWisdom, wisperlvl;
    private Item[] inventory;
    private ArrayList<Debuff> debuffs;
    private ArrayList<Buff> buffs;
    private ArrayList<Ability> abilities;
    private Weapon weapon;
    private Armor chest;
    private Armor hands;
    private Armor legs;
    private Armor boots;
    private Armor jewelery;
    String name;

    public Unit(){
        name = "Hero";
        maxHealth = 100; currHealth = 100;
        maxMana = 20; currMana = 20;
        currStrength = 12; currDexterity = 12; currMagic = 12; currWisdom = 12;
        inventory = new Item[64];
        weapon = null;
        buffs = new ArrayList<Buff>();
    }

    //this is commonly used for player-controlled characters
    public Unit(String name, int h, int hL, int m, int mL, int str, int strl, int mag, int magl, int dex, int dexl, int wis, int wisl){
        this.name = name;
        this.maxHealth = h; this.currHealth = h; this.healthperlvl = hL;
        this.maxMana = m; this.currMana = m; this.manaperlvl = mL;
        this.strength = str; this.currStrength = str; this.strperlvl = strl;
        this.magic = mag; this.currMagic = mag; this.magperlvl = magl;
        this.dexterity = dex; this.currDexterity = dex; this.dexperlvl = dexl;
        this.wisdom = wis; this.currWisdom = wis; this.wisperlvl = wisl;
        buffs = new ArrayList<Buff>();
    }


    public void takeDamage(int damage, boolean magic){
        this.currHealth -= damage;
        for(int i = 0; i < buffs.size(); i++){
            Ability reaction = buffs.get(i).checkCondition(BattleEvents.ON_ATTACK);
            if(reaction != null){
                reaction.useAbility(this, null);
            }
        }
    }
    public void restoreHealth(int health) { this.currHealth += health; }
    public void setWeapon(Weapon weapon){this.weapon = weapon;}
    public Weapon getWeapon (){ return weapon; }
    public int getCurrHealth() {return currHealth; }
    public int getStrength(){ return currStrength; }
    public int getDexterity(){ return currDexterity; }
    public Ability getAttack() {
        if(weapon == null) { return new BasicAttack("Punch"); }
        return weapon.getBasicAttack();
    }
    public ArrayList<Buff> getBuffs () { return buffs; }
}
