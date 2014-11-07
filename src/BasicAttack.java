/**
 * Created by the1banana on 11/7/2014.
 */
public class BasicAttack extends Ability {

    public BasicAttack(Unit owner){
        manaCost = 0;
        name = "Basic Attack";
        this.owner = owner;
    }

    public void useAbility (Unit target){
        int damage = 0;
        if(owner.getWeapon() != null ) {
            damage += owner.getWeapon().getDamage();
        }
        damage += owner.getStrength();
        target.takeDamage(damage, false);
    }
}
