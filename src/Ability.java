/**
 * Created by the1banana on 11/7/2014.
 */
public abstract class Ability {
    public static int SELF = 0;
    public static int ENEMY = 1;
    public static int ENEMIES = 2;
    public static int ALLIES = 3;
    public static int ALL = 4;
    int manaCost;
    String name;
    int target;
    public abstract void useAbility(Unit user, Unit target);
}
