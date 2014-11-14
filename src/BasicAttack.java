/**
 * Created by the1banana on 11/7/2014.
 */
public class BasicAttack extends Ability {

    public BasicAttack(String name){
        manaCost = 0;
        this.name = name;
    }

    public void useAbility (Unit user, Unit target){
        int damage = 0;
        if(user.getWeapon() != null ) {
            damage += user.getWeapon().getDamage(user);
        } else {
            damage = user.getStrength();
        }
        target.takeDamage(damage, false);
    }
}
