/**
 * Created by the1banana on 11/7/2014.
 */
public class Weapon extends Item {
    private String name;
    //damage ranges based on rolling dies in ranges, minimum damage is min+#dies
    private int min;
    private int[] ranges;
    private int value;
    private int type;
    private Buff enchant;
    private Debuff curse;
    private Ability basicAttack;
    public static int MELEE = 0;
    public static int RANGED = 1;

    public Weapon(String name, int min, int[] ranges, int value, int type, String attackName, Buff enchant, Debuff curse){
        this.name = name;
        this.min = min;
        this.ranges = ranges;
        this.value = value;
        this.type = type;
        this.enchant = enchant;
        this.curse = curse;
        basicAttack = new BasicAttack(attackName);
    }

    public int getDamage(Unit attacker){
        int damage = min;
        if(type == MELEE) {
            damage += attacker.getStrength();
        } else if(type == RANGED){
            damage += attacker.getDexterity();
        }
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

    public Buff getEnchantment(){ return enchant; }
    public Debuff getCurse() { return curse; }

    public Ability getBasicAttack(){
        return basicAttack;
    }
}
