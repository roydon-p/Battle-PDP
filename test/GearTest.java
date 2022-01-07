import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import battlegame.Battle;
import battlegame.Battles;
import battlegame.Gear;
import battlegame.Player;
import battlegame.Players;
import battlegame.RandomGenerator;
import battlegame.RandomGeneratorDummy;
import battlegame.Randomizer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class for testing the Gear Interface.
 */
public class GearTest {
  Randomizer r1 = new RandomGeneratorDummy();
  Randomizer r2 = new RandomGenerator();

  @Test
  public void getAllGearChecks() {
    List<Integer> randomValues = new ArrayList<>();
    Battles b = new Battle(r1);
    //count of headgears
    randomValues.add(5);
    //creates 5 headgears
    for (int i = 0; i < 5; i++) {
      //headgear from headgear list
      randomValues.add(i);
      //value change for headgear
      randomValues.add(3);
    }
    //count of potions
    randomValues.add(15);
    //creates 15 potions
    for (int i = 0; i < 15; i++) {
      //value change for potion
      randomValues.add(3);
      //potion from potion types
      randomValues.add(0);
    }
    //count of belts
    randomValues.add(15);
    //creates 15 belts
    for (int i = 0; i < 15; i++) {
      //value change for belt
      randomValues.add(3);
      //belt from belt types
      randomValues.add(0);
    }
    //count of footwear
    randomValues.add(5);
    //creates 5 footwears
    for (int i = 0; i < 5; i++) {
      //footwear from footwear list
      randomValues.add(i);
      //value change for footwear
      randomValues.add(3);
    }
    //change first 10 items(25%) in equipment bag to negative value
    for (int i = 0; i < 10; i++) {
      //item index from equipment list to be set negative
      randomValues.add(i);
    }
    //to create player with 15 as value for each ability
    for (int i = 0; i < 16; i++) {
      randomValues.add(4);
    }
    //pick 20 items from the equipment bag range index 20-40
    for (int i = 0; i < 20; i++) {
      randomValues.add(i);
    }
    r1.setDummyRandomValue(randomValues);
    b.createEquipmentBag();
    Players p = new Player("P1", r1);
    b.assignGears(p);

    Gear g = p.getGearList().get(0);
    assertEquals("American fiber helmet", g.getName());
    assertEquals(-3, g.getEffect());

    g = p.getGearList().get(5);
    assertEquals("Potion of Etherealness", g.getName());
    assertEquals(3, g.getEffect());

    g = p.getGearList().get(10);
    assertEquals("Tactical Belt", g.getName());
    assertEquals(3, g.getEffect());

    g = p.getGearList().get(18);
    assertEquals("Boots", g.getName());
    assertEquals(3, g.getEffect());
  }

  @Test
  public void testBeltUnits() {
    Battles b = new Battle(r2);
    b.createEquipmentBag();
    b.createArmory();
    Players p1 = new Player("P1", r2);
    Players p2 = new Player("P2", r2);
    b.assignGears(p1);
    b.assignGears(p2);
    int unitsCount = 0;
    for (Gear g : p1.getGearList()) {
      unitsCount += g.getUnits();
    }
    assertTrue(unitsCount <= 10);
    unitsCount = 0;
    for (Gear g : p2.getGearList()) {
      unitsCount += g.getUnits();
    }
    assertTrue(unitsCount <= 10);
  }
}
