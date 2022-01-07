import org.junit.Test;

import battlegame.Abilities;
import battlegame.Ability;
import battlegame.RandomGenerator;
import battlegame.Randomizer;

import static org.junit.Assert.assertTrue;

/**
 * Class for testing the Abilities Interface.
 */
public class AbilitiesTest {
  Randomizer r1 = new RandomGenerator();

  @Test
  public void getAbilityRangeCheck() {
    Abilities a = new Ability(r1);
    assertTrue(a.getStrength() >= 6 && a.getStrength() <= 18);
    assertTrue(a.getCharisma() >= 6 && a.getCharisma() <= 18);
    assertTrue(a.getConstitution() >= 6 && a.getConstitution() <= 18);
    assertTrue(a.getDexterity() >= 6 && a.getDexterity() <= 18);

    a = new Ability(r1);
    assertTrue(a.getStrength() >= 6 && a.getStrength() <= 18);
    assertTrue(a.getCharisma() >= 6 && a.getCharisma() <= 18);
    assertTrue(a.getConstitution() >= 6 && a.getConstitution() <= 18);
    assertTrue(a.getDexterity() >= 6 && a.getDexterity() <= 18);
  }
}