package battlegame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents the instance of 1 battle that takes place between 2 players. The battle assigns the
 * players with the required gears and weapons and decides the winner/loser based on which player
 * loses their entire health first.
 */
public class Battle implements Battles {
  private final int Min_Headgear_Count = 5;
  private final int Min_Potion_Count = 15;
  private final int Min_Belt_Count = 15;
  private final int Min_Footwear_Count = 5;
  private final int Max_Gears_Per_Type_Count = 30;
  private final int Min_Weapons_Per_Type_Count = 1;
  private final int Max_Weapons_Per_Type_Count = 5;
  private List<AbstractGear> equipmentBag;
  private List<Weapon> armory;
  private List<String> headgearNameList;
  private List<String> footwearNameList;
  private Randomizer r;
  private String introMessage = "";

  /**
   * Creates instance on the battle to initialize all the data required for the battle to begin.
   *
   * @param r Randomizer object
   */
  public Battle(Randomizer r) {
    equipmentBag = new ArrayList<>();
    armory = new ArrayList<>();
    headgearNameList = Arrays.asList("American fiber helmet", "Capotain", "Caubeen", "Papakha",
            "Pava", "Peci", "Pith helmet", "Shtreimel", "Sombrero", "Spodik", "Keffiyah",
            "Attic helmet", "Boar's tusk helmet", "Boeotian helmet", "Chalcidian helmet",
            "Coolus helmet", "Corinthian helmet", "Disc and stud helmet", "Galea", "Horned helmet",
            "Illyrian type helmet", "Imperial helmet", "Imperial Chinese helmet", "Kegelhelm",
            "Negau helmet", "Montefortino helmet", "Pilos", "Pot helmet", "Thracian helmet",
            "Zhou helmet");
    footwearNameList = Arrays.asList("Sneakers", "Boots", "Clogs", "Crocs", "Earth Shoes",
            "Flip-Flops", "Galoshes", "Huaraches", "Jika-tabi Shoes", "Moccasins", "Riding Boots",
            "Russian Boots", "Slide Sandals", "Sandals", "Slippers", "Snow Boots", "Ugg Boots",
            "Oxfords", "Saddle Shoes", "Cleats", "Calf Boots", "Barefoot Shoes", "Buckled Shoes",
            "Chukka Boots", "Combat Boots", "Cowboy Boots", "Derby Shoes", "Hiking Boots",
            "Loafers", "Motorcycle Boots");
    this.r = r;
    introMessage = String.format("---------------------------------------------------------------"
            + "\nWelcome to the Battle Game ! ! !\nGet your Gears and Weapons and begin "
            + "the battle\n--------------------------------------------------------------");
  }

  @Override
  public void createEquipmentBag() {
    //get a random count for the quantity of Headgears to be added to the equipment bag
    int headgearCount = r.getRandomInt(Min_Headgear_Count, Max_Gears_Per_Type_Count);
    for (int i = 0; i < headgearCount; i++) {
      //select a type of headgear from the list available and add it to the bag
      int headgearNameIndex = r.getRandomInt(0, headgearNameList.size());
      String headgearName = headgearNameList.get(headgearNameIndex);
      AbstractGear hg = new HeadGear(headgearName, this.r);
      equipmentBag.add(hg);
    }

    //get a random count for the quantity of Potions to be added to the equipment bag
    int potionCount = r.getRandomInt(Min_Potion_Count, Max_Gears_Per_Type_Count);
    for (int i = 0; i < potionCount; i++) {
      //create a new potion and add it to the bag
      AbstractGear pt = new Potion(this.r);
      equipmentBag.add(pt);
    }

    //get a random count for the quantity of Belts to be added to the equipment bag
    int beltCount = r.getRandomInt(Min_Belt_Count, Max_Gears_Per_Type_Count);
    for (int i = 0; i < beltCount; i++) {
      //create a new belt and add it to the bag
      AbstractGear bt = new Belt(this.r);
      equipmentBag.add(bt);
    }

    //get a random count for the quantity of Footwears to be added to the equipment bag
    int footwearCount = r.getRandomInt(Min_Footwear_Count, Max_Gears_Per_Type_Count);
    for (int i = 0; i < footwearCount; i++) {
      //select a type of footwear from the list available and add it to the bag
      int footwearNameIndex = r.getRandomInt(0, footwearNameList.size());
      String footwearName = footwearNameList.get(footwearNameIndex);
      AbstractGear fw = new Footwear(footwearName, this.r);
      equipmentBag.add(fw);
    }

    //get count for quantity of items in the bag that should affect a player's ability negatively.
    int negativeEffectCount = (int) Math.round(0.25 * equipmentBag.size());

    for (int i = 0; i < negativeEffectCount; i++) {
      //select a random object from the bag to make it affect a player negatively
      int changeIndex = r.getRandomInt(0, equipmentBag.size());
      equipmentBag.get(changeIndex).setNegativeEffect();
    }
  }

  @Override
  public void assignGears(Players p) {
    //reset the assigned gears that the player has from previous battle
    if (p.getGearList().size() > 0) {
      List<AbstractGear> temp = new ArrayList<>(p.getGearList());
      for (AbstractGear g : temp) {
        p.getGearList().remove(g);
      }
    }

    //pick 20 items from the equipment bag randomly and assign it to the player
    for (int i = 0; i < 20; i++) {
      int gearIndex = r.getRandomInt(0, equipmentBag.size());
      p.getGearList().add(equipmentBag.get(gearIndex));
      equipmentBag.remove(gearIndex);
    }

    //update player abilities using the 20 items selected previously
    p.setHealth();
  }

  @Override
  public void createArmory() {
    int weaponCount;
    //randomly get the count of katana weapons that should be added to the armory
    weaponCount = r.getRandomInt(Min_Weapons_Per_Type_Count, Max_Weapons_Per_Type_Count);
    for (int i = 0; i < weaponCount; i++) {
      Weapon kt = new Katana(this.r);
      armory.add(kt);
    }

    //randomly get the count of Broadsword weapons that should be added to the armory
    weaponCount = r.getRandomInt(Min_Weapons_Per_Type_Count, Max_Weapons_Per_Type_Count);
    for (int i = 0; i < weaponCount; i++) {
      Weapon bs = new BroadSword(this.r);
      armory.add(bs);
    }

    //randomly get the count of two-handed sword weapons that should be added to the armory
    weaponCount = r.getRandomInt(Min_Weapons_Per_Type_Count, Max_Weapons_Per_Type_Count);
    for (int i = 0; i < weaponCount; i++) {
      Weapon ths = new TwoHandedSword(this.r);
      armory.add(ths);
    }

    //randomly get the count of axe weapons that should be added to the armory
    weaponCount = r.getRandomInt(Min_Weapons_Per_Type_Count, Max_Weapons_Per_Type_Count);
    for (int i = 0; i < weaponCount; i++) {
      Weapon ax = new Axe(this.r);
      armory.add(ax);
    }

    //randomly get the count of flail weapons that should be added to the armory
    weaponCount = r.getRandomInt(Min_Weapons_Per_Type_Count, Max_Weapons_Per_Type_Count);
    for (int i = 0; i < weaponCount; i++) {
      Weapon fl = new Flail(this.r);
      armory.add(fl);
    }
  }

  @Override
  public void assignWeapon(Players p) {
    //if players wants a weapon, randomly assign 1 weapon from armory
    int weaponIndex = r.getRandomInt(0, armory.size());
    p.setWeapon(armory.get(weaponIndex));
    armory.remove(weaponIndex);
  }

  @Override
  public List<String> startBattle(Players p1, Players p2) {
    //initialize the health value for both the players
    int p1_health = p1.getHealth();
    int p2_health = p2.getHealth();
    int actualDamage;
    boolean resultAvailable = false;
    String s;
    int count = 0;
    List<String> battleStats = new ArrayList<>();

    //if player 1 has greater charisma than player 2, then player 1 strikes first
    if (p1.getNewCharisma() > p2.getNewCharisma()) {
      s = String.format(p1.getName() + " to strike first.");
      battleStats.add(s);

      //Until no player has lost or 200 rounds are completed, continue the battle
      while (p1_health > 0 && p2_health > 0 && count < 200) {
        //round where player 1 strikes player 2
        count++;
        s = String.format("Round " + count + ": " + p1.getName() + " attacks | ");
        //get the damage caused by player 1 to player 2
        actualDamage = checkDamage(p1, p2);
        //if damage is caused, reduce the health of player 2
        if (actualDamage > 0) {
          p2_health = p2_health - actualDamage;
          s = s + String.format("Hit Successful | Damage= " + actualDamage + " | "
                  + p1.getName() + " Health= " + p1_health + " | " + p2.getName()
                  + " Health= " + p2_health);
          battleStats.add(s);
          //check if player 2 health is less than or equal to 0, if yes then stop the battle
          if (p2_health <= 0) {
            s = String.format("Player " + p1.getName() + " Wins !!");
            battleStats.add(s);
            resultAvailable = true;
            break;
          }
        }
        //if no damage is caused, then no need to update the health value
        else {
          s = s + String.format("Hit Missed ");
          battleStats.add(s);
        }
        //round where player 2 strikes player 1
        count++;
        s = String.format("Round " + count + ": " + p2.getName() + " attacks | ");
        //get the damage caused by player 2 to player 1
        actualDamage = checkDamage(p2, p1);
        //if damage is caused, reduce the health of player 1
        if (actualDamage > 0) {
          p1_health = p1_health - actualDamage;
          s = s + String.format("Hit Successful | Damage= " + actualDamage + " | "
                  + p1.getName() + " Health= " + p1_health + " | " + p2.getName()
                  + " Health= " + p2_health);
          battleStats.add(s);
        }
        //if no damage is caused, then no need to update the health value
        else {
          s = s + String.format("Hit Missed ");
          battleStats.add(s);
        }
      }
    }
    // If Player 2 has greater Charisma than Player 1, do this
    else {
      s = String.format(p2.getName() + " strikes first.");
      battleStats.add(s);
      //Until no player has lost or 200 rounds are completed, continue the battle
      while (p1_health > 0 && p2_health > 0 && count < 200) {
        //round where player 2 strikes player 1
        count++;
        s = String.format("Round " + count + ": " + p2.getName() + " attacks | ");
        //get the damage caused by player 2 to player 1
        actualDamage = checkDamage(p2, p1);
        //if damage is caused, reduce the health of player 1
        if (actualDamage > 0) {
          p1_health = p1_health - actualDamage;
          s = s + String.format("Hit Successful | Damage= " + actualDamage + " | "
                  + p1.getName() + " Health= " + p1_health + " | " + p2.getName()
                  + " Health= " + p2_health);
          battleStats.add(s);
          //check if player 1 health is less than or equal to 0, if yes then stop the battle
          if (p1_health <= 0) {
            s = String.format("Player " + p2.getName() + " Wins !!");
            battleStats.add(s);
            resultAvailable = true;
            break;
          }
        }
        //if no damage is caused, then no need to update the health value
        else {
          s = s + String.format("Hit Missed ");
          battleStats.add(s);
        }
        //round where player 1 strikes player 2
        count++;
        s = String.format("Round " + count + ": " + p1.getName() + " attacks | ");
        //get the damage caused by player 1 to player 2
        actualDamage = checkDamage(p1, p2);
        //if damage is caused, reduce the health of player 2
        if (actualDamage > 0) {
          p2_health = p2_health - actualDamage;
          s = s + String.format("Hit Successful | Damage= " + actualDamage + " | "
                  + p1.getName() + " Health= " + p1_health + " | " + p2.getName()
                  + " Health= " + p2_health);
          battleStats.add(s);
        }
        //if no damage is caused, then no need to update the health value
        else {
          s = s + String.format("Hit Missed ");
          battleStats.add(s);
        }
      }
    }
    //if the result is not yet received and player 1 health is less than or equal to 0, then
    //declare player 2 as winner
    if (!resultAvailable && p1_health < 1) {
      s = String.format("Player " + p2.getName() + " Wins !!");
      battleStats.add(s);
    }
    //if the result is not yet received and player 2 health is less than or equal to 0, then
    //declare player 1 as winner
    else if (!resultAvailable && p2_health < 1) {
      s = String.format("Player " + p1.getName() + " Wins !!");
      battleStats.add(s);
    }
    //if the result is not yet received and none of the players'health is less than or equal to 0,
    // then declare battle as tie.
    else if (!resultAvailable) {
      s = String.format("Match Tied as Max Round limit is reached");
      battleStats.add(s);
    }
    return battleStats;
  }

  /**
   * Helper function to calculate the damage done by attacking player to the defending player.
   *
   * @param strikingPlayer  the attacking player
   * @param defendingPlayer the defending player
   * @return the damage done by attacking player to the defending player
   */
  private int checkDamage(Players strikingPlayer, Players defendingPlayer) {
    final int min_Random_SP = 1;
    final int max_Random_SP = 10;
    final int min_Random_AA = 1;
    final int max_Random_AA = 6;
    int potentialDamage = 0;
    int actualDamage = 0;
    //calculate strike power of attacking player
    int sp = strikingPlayer.getNewStrength() + r.getRandomInt(min_Random_SP, max_Random_SP);
    //calculate the avoidance ability of defending player
    int aa = defendingPlayer.getNewDexterity() + r.getRandomInt(min_Random_AA, max_Random_AA);
    //if strike power is greater than avoidance ability, then find the potential strike damage
    if (sp > aa) {
      //check if attacking player has a weapon, if not then calculate its potential strike damage
      // as below
      if (strikingPlayer.getWeapon() == null) {
        potentialDamage = strikingPlayer.getNewStrength();
      }
      //if attacking player has a weapon then calculate its potential strike damage as below
      else {
        potentialDamage = strikingPlayer.getNewStrength()
                + strikingPlayer.getWeapon().getDamageValue(strikingPlayer.getNewStrength(),
                strikingPlayer.getNewDexterity());
      }
      //calculate the actual damage to the defending player
      actualDamage = potentialDamage - defendingPlayer.getNewConstitution();
    }
    return actualDamage;
  }

  @Override
  public String getIntroMessage() {
    return this.introMessage;
  }
}
