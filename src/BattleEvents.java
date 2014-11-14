/**
 * Created by the1banana on 11/14/2014.
 */
public class BattleEvents {
    public static int ON_MELEE_ATTACK = 0; //procs when the character uses a melee attack
    public static int ON_RANGED_ATTACK = 1;
    public static int ON_MAGIC_ATTACK = 2;
    public static int ON_MELEE_RECEIVE = 3; //procs when the character receives a melee attack
    public static int ON_RANGED_RECEIVE = 4;
    public static int ON_MAGIC_RECEIVE = 5;
    public static int ON_ATTACK = 6; //procs when the character attacks an attack
    public static int ON_RECEIVE = 7; //procs when the character receives an attack of any sort
    public static int ON_CAST = 8; //procs when the character uses a non-basic attack
    public static int ON_ENEMY_CAST = 9; //procs when the opponent uses a non-basic attack
    public static int ON_HEALTH_ABOVE = 10; //procs when the character moves above a certain health%
    public static int ON_HEALTH_BELOW = 11; //procs when the character falls below a certain health%
    public static int ON_TURN_END = 12; //procs when the character's turn ends
    public static int ON_TURN_START = 13; //procs when the character's turn starts
}
