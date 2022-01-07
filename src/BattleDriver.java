import battlegame.Battle;
import battlegame.Battles;
import battlegame.Player;
import battlegame.Players;
import battlegame.RandomGenerator;
import battlegame.Randomizer;

import java.util.List;
import java.util.Scanner;

/**
 * Driver class created to demonstrate the Run of Battle and Player interface implementation.
 */
public class BattleDriver {
  /**
   * Main method contains all the calls to the public methods of Battle and Player interfaces.
   *
   * @param args passes parameters to a string array through the console window.
   */
  public static void main(String[] args) {
    Randomizer r = new RandomGenerator();
    Battles b = new Battle(r);
    System.out.println(b.getIntroMessage());
    System.out.println("-------------------------------------------------------------------------");
    System.out.println("Players' details before entering the Arena:");
    System.out.println("-------------------------------------------------------------------------");
    System.out.println("Players' Basic Abilities:");
    String s;
    Players p1 = new Player("P1", r);
    s = String.format("Player " + p1.getName() + ": Strength= %d | Constitution= %d | "
                    + "Dexterity= %d | Charisma= %d", p1.getAbility().getStrength(),
            p1.getAbility().getConstitution(), p1.getAbility().getDexterity(),
            p1.getAbility().getCharisma());
    System.out.println(s);

    Player p2 = new Player("P2", r);
    s = String.format("Player " + p2.getName() + ": Strength= %d | Constitution= %d | "
                    + "Dexterity= %d | Charisma= %d", p2.getAbility().getStrength(),
            p2.getAbility().getConstitution(), p2.getAbility().getDexterity(),
            p2.getAbility().getCharisma());
    System.out.println(s);
    System.out.println("-------------------------------------------------------------------------");

    Scanner sc = new Scanner(System.in);
    String c = "Y";
    while (c.equals("Y") || c.equals("y")) {
      System.out.println("\nPreparing for Battle...");
      b.createEquipmentBag();
      System.out.println("\nGears added to the Equipment Bag...");
      b.createArmory();
      System.out.println("\nWeapons added to the Armory...");

      System.out.print("\nAssigning gears to Player " + p1.getName() + "...");
      b.assignGears(p1);
      System.out.println("COMPLETE");
      List<String> ag;
      ag = p1.getPlayerAssignedGears();
      System.out.println("Player " + p1.getName() + " Assigned Gears -");
      int counter = 0;
      for (String s1 : ag) {
        counter++;
        System.out.println(counter + ". " + s1);
      }

      System.out.print("\nAssigning weapon to Player " + p1.getName() + "...");
      b.assignWeapon(p1);
      System.out.println("COMPLETE");
      System.out.println("Player " + p1.getName() + " Assigned Weapon -" + p1.getWeaponType());

      System.out.print("\nAssigning gears to Player " + p2.getName() + "...");
      b.assignGears(p2);
      System.out.println("COMPLETE");
      ag = p2.getPlayerAssignedGears();
      System.out.println("Player " + p2.getName() + " Assigned Gears -");
      counter = 0;
      for (String s1 : ag) {
        counter++;
        System.out.println(counter + ". " + s1);
      }

      System.out.print("\nAssigning weapon to Player " + p2.getName() + "...");
      b.assignWeapon(p2);
      System.out.println("COMPLETE");
      System.out.println("Player " + p2.getName() + " Assigned Weapon -" + p2.getWeaponType());

      System.out.println("-----------------------------------------------------------------------");
      System.out.println("-----------------------------------------------------------------------");
      System.out.println("Player details for the Battle:");
      System.out.println("-----------------------------------------------------------------------");
      System.out.println("Player " + p1.getName() + ":");
      System.out.println("Equipped Gears -");
      List<String> l;
      l = p1.getPlayerEquippedGears();
      counter = 0;
      for (String s1 : l) {
        counter++;
        System.out.println(counter + ". " + s1);
      }

      System.out.println("\nWeapon: " + p1.getWeaponType());
      s = String.format("\nAbilities: Strength= %d | Constitution= %d | Dexterity= %d | "
                      + "Charisma= %d",
              p1.getNewStrength(), p1.getNewConstitution(), p1.getNewDexterity(),
              p1.getNewCharisma());
      System.out.println(s);
      System.out.println("\nHealth: " + p1.getHealth());

      System.out.println("-----------------------------------------------------------------------");

      System.out.println("Player " + p2.getName() + ":");
      System.out.println("Equipped Gears -");
      l = p2.getPlayerEquippedGears();
      counter = 0;
      for (String s1 : l) {
        counter++;
        System.out.println(counter + ". " + s1);
      }

      System.out.println("\nWeapon: " + p2.getWeaponType());
      s = String.format("\nAbilities: Strength= %d | Constitution= %d | Dexterity= %d | "
                      + "Charisma= %d",
              p2.getNewStrength(), p2.getNewConstitution(), p2.getNewDexterity(),
              p2.getNewCharisma());
      System.out.println(s);
      System.out.println("\nHealth: " + p2.getHealth());

      System.out.println("----------------------------------------------------------------------");
      System.out.println("\nBattle Starting ...");
      l = b.startBattle(p1, p2);
      for (String s1 : l) {
        System.out.println(s1);
      }
      System.out.print("Do you want a rematch? (Y/N): ");
      c = sc.next();
    }
  }
}
