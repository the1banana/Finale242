import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by the1banana on 11/7/2014.
 */
public class CombatAndEquipmentTest {

    @Test
    public void validUnarmedAttack() throws Exception {
        Unit attacker = new Unit();
        Unit defender = new Unit();
        attacker.getAttack().useAbility(attacker, defender);
        assertEquals(88, defender.getCurrHealth());
    }

    @Test
    public void validWeaponConstructor() throws Exception {
        Unit attacker = new Unit();
        int[] d7 = {7};
        Weapon swordOfJustice = new Weapon("Sword of Justice", 77, d7, 777, Weapon.MELEE, "Righteous Strike", null, null);
        assertEquals("Sword of Justice", swordOfJustice.getName());
        assertEquals("78 - 84", swordOfJustice.getDamageRange());
        for(int i = 0; i < 3; i++) {
            assertTrue(swordOfJustice.getDamage(attacker) >= 90);
            assertTrue(swordOfJustice.getDamage(attacker) <= 96);
        }
    }

    @Test
    public void validWeaponWithoutRanges() throws Exception {
        Unit attacker = new Unit();
        int[] dNone = {};
        Weapon stick = new Weapon("Large Stick", 15, dNone, 25, Weapon.MELEE, "Whack", null, null);
        assertEquals("15 - 15", stick.getDamageRange());
        assertTrue(stick.getDamage(attacker) == 27);
    }

    @Test
    public void validAttackWithWeapon() throws Exception {
        Unit attacker = new Unit();
        Unit defender = new Unit();
        int[] dNone = {};
        Weapon stick = new Weapon("Large Stick", 15, dNone, 25, Weapon.MELEE, "Whack", null, null);
        attacker.setWeapon(stick);
        attacker.getAttack().useAbility(attacker, defender);
        assertEquals(73, defender.getCurrHealth());
    }

    @Test
    public void testHealingBuff() throws Exception {
        Unit attacker = new Unit();
        Unit defender = new Unit();
        int[] dNone = {};
        Weapon stick = new Weapon("Large Stick", 15, dNone, 25, Weapon.MELEE, "Whack", null, null);
        attacker.setWeapon(stick);
        Buff healingBuff = new Buff("Determination", "This unit restores a small amount of health when attacked.",
                -1, 0, 0, 0,0);
        Ability healComponent = new Heal(4, Ability.SELF);
        healingBuff.addCondition(healComponent, BattleEvents.ON_ATTACK);
        defender.getBuffs().add(healingBuff);
        attacker.getAttack().useAbility(attacker, defender);
        assertEquals(77, defender.getCurrHealth());
    }
}
