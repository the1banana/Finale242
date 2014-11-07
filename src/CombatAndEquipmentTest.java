import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by the1banana on 11/7/2014.
 */
public class CombatAndEquipmentTest {

    @Test
    public void validAttack() throws Exception {
        Unit attacker = new Unit();
        Unit defender = new Unit();
        attacker.getAttack().useAbility(defender);
        assertEquals(88, defender.getCurrHealth());
    }

    @Test
    public void validWeaponConstructor() throws Exception {
        int[] d7 = {7};
        Weapon swordOfJustice = new Weapon("Sword of Justice", 77, d7, 777);
        assertEquals("Sword of Justice", swordOfJustice.getName());
        assertEquals("78 - 84", swordOfJustice.getDamageRange());
        for(int i = 0; i < 3; i++) {
            assertTrue(swordOfJustice.getDamage() >= 78);
            assertTrue(swordOfJustice.getDamage() <= 84);
        }
    }

    @Test
    public void validWeaponWithoutRanges() throws Exception {
        int[] dNone = {};
        Weapon stick = new Weapon("Large Stick", 15, dNone, 25);
        assertEquals("15 - 15", stick.getDamageRange());
        assertTrue(stick.getDamage() == 15);
    }

    @Test
    public void validAttackWithWeapon() throws Exception {
        Unit attacker = new Unit();
        Unit defender = new Unit();
        int[] dNone = {};
        Weapon stick = new Weapon("Large Stick", 15, dNone, 25);
        attacker.setWeapon(stick);
        attacker.getAttack().useAbility(defender);
        assertEquals(73, defender.getCurrHealth());
    }

}
