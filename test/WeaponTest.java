import org.junit.Test;

import battlegame.Axe;
import battlegame.BroadSword;
import battlegame.Flail;
import battlegame.Katana;
import battlegame.RandomGenerator;
import battlegame.RandomGeneratorDummy;
import battlegame.Randomizer;
import battlegame.TwoHandedSword;
import battlegame.Weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class for testing the Weapon Interface.
 */
public class WeaponTest {
  Randomizer r1 = new RandomGeneratorDummy();
  Randomizer r2 = new RandomGenerator();

  @Test
  public void axeGetChecks() {
    Weapon w = new Axe(r2);
    assertTrue(w.getDamageValue(10, 20) >= 6
            && w.getDamageValue(10, 20) <= 10);
    assertTrue(w.getDamageValue(10, 20) >= 6
            && w.getDamageValue(0, 0) <= 10);
    assertTrue(w.getDamageValue(10, 20) >= 6
            && w.getDamageValue(100, 200) <= 10);
    assertEquals("Axe", w.toString());
  }

  @Test
  public void katanaGetChecks() {
    Weapon w = new Katana(r2);
    assertTrue(w.getDamageValue(10, 20) >= 8
            && w.getDamageValue(10, 20) <= 12);
    assertTrue(w.getDamageValue(10, 20) >= 8
            && w.getDamageValue(0, 0) <= 12);
    assertTrue(w.getDamageValue(10, 20) >= 8
            && w.getDamageValue(100, 200) <= 12);
    assertEquals("Katana", w.toString());
  }

  @Test
  public void broadswordGetChecks() {
    Weapon w = new BroadSword(r2);
    assertTrue(w.getDamageValue(10, 20) >= 6
            && w.getDamageValue(10, 20) <= 10);
    assertTrue(w.getDamageValue(10, 20) >= 6
            && w.getDamageValue(0, 0) <= 10);
    assertTrue(w.getDamageValue(10, 20) >= 6
            && w.getDamageValue(100, 200) <= 10);
    assertEquals("Broad Sword", w.toString());
  }

  @Test
  public void twoHandedSwordGetChecks() {
    Weapon w = new TwoHandedSword(r2);
    assertTrue(w.getDamageValue(15, 20) >= 8
            && w.getDamageValue(15, 20) <= 12);
    assertTrue(w.getDamageValue(14, 20) >= 4
            && w.getDamageValue(14, 20) <= 6);
    assertTrue(w.getDamageValue(12, 20) >= 4
            && w.getDamageValue(12, 20) <= 6);
    assertEquals("Two-Handed Sword", w.toString());
  }

  @Test
  public void flailGetChecks() {
    Weapon w = new Flail(r2);
    assertTrue(w.getDamageValue(10, 15) >= 8
            && w.getDamageValue(10, 15) <= 12);
    assertTrue(w.getDamageValue(10, 14) >= 4
            && w.getDamageValue(10, 14) <= 6);
    assertTrue(w.getDamageValue(10, 12) >= 4
            && w.getDamageValue(10, 12) <= 6);
    assertEquals("Flail", w.toString());
  }
}