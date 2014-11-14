/**
 * Created by the1banana on 11/14/2014.
 */
public class Heal extends Ability {
    int healPower;
    int target;
    public Heal(int amount, int target){
        healPower = amount;
        this.target = target;
    }
    public void useAbility(Unit user, Unit target){
        user.restoreHealth(healPower);
    }
}
