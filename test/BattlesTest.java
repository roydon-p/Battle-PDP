import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import battlegame.Battle;
import battlegame.Battles;
import battlegame.Player;
import battlegame.Players;
import battlegame.RandomGenerator;
import battlegame.RandomGeneratorDummy;
import battlegame.Randomizer;

import static org.junit.Assert.assertEquals;

/**
 * Class for testing the Battles Interface.
 */
public class BattlesTest {
  Randomizer r1 = new RandomGeneratorDummy();
  Randomizer r2 = new RandomGenerator();

  @Test
  public void getIntroMessageTest() {
    Battles b = new Battle(r2);
    assertEquals("---------------------------------------------------------------\n"
                    + "Welcome to the Battle Game ! ! !\n"
                    + "Get your Gears and Weapons and begin the battle\n"
                    + "--------------------------------------------------------------",
            b.getIntroMessage());
  }

  @Test
  public void testBattle() {
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
    //to create player1 with 15 as value for each ability
    for (int i = 0; i < 16; i++) {
      randomValues.add(4);
    }
    //pick 20 items from the equipment bag range index 0-19
    for (int i = 0; i < 20; i++) {
      randomValues.add(i);
    }
    //creates 1 weapon of each type in armory
    for (int i = 0; i < 5; i++) {
      randomValues.add(1);
    }
    //select 1st weapon from the armory
    randomValues.add(1);
    //to create player2 with 15 as value for each ability
    for (int i = 0; i < 16; i++) {
      randomValues.add(4);
    }
    //pick 20 items from the equipment bag range index 0-19
    for (int i = 0; i < 20; i++) {
      randomValues.add(0);
    }
    //select 2nd weapon from the armory
    randomValues.add(1);

    //random damage value for each hit
    for (int i = 0; i < 100; i++) {
      randomValues.add(10);
    }
    r1.setDummyRandomValue(randomValues);
    b.createEquipmentBag();
    Players p1 = new Player("P1", r1);
    b.assignGears(p1);
    b.createArmory();
    b.assignWeapon(p1);

    Players p2 = new Player("P2", r1);
    b.assignGears(p2);
    b.assignWeapon(p2);
    List<String> battleStats = new ArrayList<>();
    battleStats.add("P2 strikes first.");
    battleStats.add("Round 1: P2 attacks | Hit Successful | Damage= 19 | P1 Health= 80 | "
            + "P2 Health= 96");
    battleStats.add("Round 2: P1 attacks | Hit Successful | Damage= 22 | P1 Health= 80 | "
            + "P2 Health= 74");
    battleStats.add("Round 3: P2 attacks | Hit Successful | Damage= 19 | P1 Health= 61 | "
            + "P2 Health= 74");
    battleStats.add("Round 4: P1 attacks | Hit Successful | Damage= 22 | P1 Health= 61 | "
            + "P2 Health= 52");
    battleStats.add("Round 5: P2 attacks | Hit Successful | Damage= 19 | P1 Health= 42 | "
            + "P2 Health= 52");
    battleStats.add("Round 6: P1 attacks | Hit Successful | Damage= 22 | P1 Health= 42 | "
            + "P2 Health= 30");
    battleStats.add("Round 7: P2 attacks | Hit Successful | Damage= 19 | P1 Health= 23 | "
            + "P2 Health= 30");
    battleStats.add("Round 8: P1 attacks | Hit Successful | Damage= 22 | P1 Health= 23 | "
            + "P2 Health= 8");
    battleStats.add("Round 9: P2 attacks | Hit Successful | Damage= 19 | P1 Health= 4 | "
            + "P2 Health= 8");
    battleStats.add("Round 10: P1 attacks | Hit Successful | Damage= 22 | P1 Health= 4 | "
            + "P2 Health= -14");
    battleStats.add("Player P1 Wins !!");
    assertEquals(battleStats, b.startBattle(p1, p2));
  }
}