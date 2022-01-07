import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import battlegame.Axe;
import battlegame.Battle;
import battlegame.Battles;
import battlegame.Player;
import battlegame.Players;
import battlegame.RandomGenerator;
import battlegame.RandomGeneratorDummy;
import battlegame.Randomizer;
import battlegame.Weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Class for testing the Players Interface.
 */
public class PlayersTest {
  Randomizer r1 = new RandomGeneratorDummy();
  Randomizer r2 = new RandomGenerator();

  @Test
  public void playerAllGetChecks() {
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
    //creates 1 weapon of each type in armory
    for (int i = 0; i < 5; i++) {
      randomValues.add(1);
    }
    //select 1st weapon from the armory
    randomValues.add(1);
    r1.setDummyRandomValue(randomValues);
    b.createEquipmentBag();
    Players p = new Player("P1", r1);
    b.assignGears(p);
    assertEquals("P1", p.getName());

    assertEquals(15, p.getAbility().getStrength());
    assertEquals(15, p.getAbility().getConstitution());
    assertEquals(15, p.getAbility().getDexterity());
    assertEquals(15, p.getAbility().getCharisma());

    assertEquals(39, p.getNewStrength());
    assertEquals(27, p.getNewConstitution());
    assertEquals(18, p.getNewDexterity());
    assertEquals(15, p.getNewCharisma());

    assertEquals(99, p.getHealth());

    assertEquals(p.getNewStrength() + p.getNewConstitution() + p.getNewDexterity()
            + p.getNewCharisma(), p.getHealth());

    assertEquals(60, p.getAbility().getStrength() + p.getAbility().getConstitution()
            + p.getAbility().getDexterity() + p.getAbility().getCharisma());

    b.createArmory();
    b.assignWeapon(p);
    assertEquals("Broad Sword", p.getWeaponType());

    List<String> gears = new ArrayList<>();
    gears.add("American fiber helmet");
    gears.add("Potion of Etherealness");
    gears.add("Potion of Etherealness");
    gears.add("Potion of Etherealness");
    gears.add("Potion of Etherealness");
    gears.add("Potion of Etherealness");
    gears.add("Potion of Etherealness");
    gears.add("Potion of Etherealness");
    gears.add("Tactical Belt");
    gears.add("Tactical Belt");
    gears.add("Tactical Belt");
    gears.add("Tactical Belt");
    gears.add("Tactical Belt");
    gears.add("Boots");

    assertEquals(gears, p.getPlayerEquippedGears());
  }

  @Test
  public void testSetWeapon() {
    Players p = new Player("P1", r2);
    Weapon w = new Axe(r2);
    p.setWeapon(w);
    assertEquals("Axe", p.getWeaponType());
    assertNotEquals("Broad Sword", p.getWeaponType());
  }

  @Test
  public void setHealthNoChange() {
    List<Integer> randomValues = new ArrayList<>();
    //to create player with 15 as value for each ability
    for (int i = 0; i < 16; i++) {
      randomValues.add(4);
    }
    r1.setDummyRandomValue(randomValues);
    Players p = new Player("P1", r1);
    p.setHealth();
    assertEquals(60, p.getHealth());
  }
}