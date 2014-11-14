/**
 * Created by the1banana on 11/14/2014.
 */
public class Buff {
    String name;
    String description;
    int duration; //number of turns the effect lasts. ticks down by 1 every turn.
    // Set as -1 for a permanent Buff or passive.
    boolean[] conditions; //these correspond to BattleEvents constants
    Ability[] actions;
    int strBoost; int magBoost; int dexBoost; int wisBoost;

    public Buff (String name, String description, int duration, int s, int m, int d, int w) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        conditions = new boolean[14];
        actions = new Ability[14];
        strBoost = s;
        magBoost = m;
        dexBoost = d;
        wisBoost = w;
    }

    public void addCondition (Ability effect, int condition) {
        conditions[condition] = true;
        actions[condition] = effect;
    }

    public void removeCondition (int condition){
        conditions[condition] = false;
        actions[condition] = null;
    }

    public Ability checkCondition (int condition){
        if(conditions[condition]){
            return actions[condition];
        }
        return null;
    }
}
