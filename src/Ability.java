/**
 * Created by the1banana on 11/7/2014.
 */
public abstract class Ability {
    int manaCost;
    String name;
    Unit owner;
    public abstract void useAbility(Unit target);
}
