package battlegame;

import java.util.List;

/**
 * Represents the Battle Arena within which all the battles take place. It can create a battle
 * between two players who enter the arena. Each Battle can have its own equipment bag and armory
 * which the players can use to equip themselves with.
 */
public interface Battles {
  /**
   * Creates a bag of equipment that contains a minimum of 5 items of headgear, 5 items of footwear,
   * 15 belts, and 15 potions. 25% of the items that are in the bag will diminish the player's
   * ability rather than enhance it.
   */
  public void createEquipmentBag();

  /**
   * Equips the players with 20 random items from the bag. All the assigned gears must be used by
   * the players unless it cannot be combined with what the player is already using.
   * @param p the player to whom the gears are being assigned
   */
  public void assignGears(Players p);

  /**
   * Creates an Armory that contains at least 1 and at most 30 weapons of each type including all
   * types of swords, axes and flails.
   */
  public void createArmory();

  /**
   * Equips the players with a random weapon from the Armory.
   * @param p the player to whom the weapon is being assigned
   */
  public void assignWeapon(Players p);

  /**
   * Starts the battle between the 2 players. Based on the logic of strike power and avoidance
   * ability, it determines which player wins the battle. The battle ends if there is no winner
   * after 200 rounds.
   * @param p1 player 1
   * @param p2 player 2
   * @return list of battle statistics that show how the battle progressed and its result.
   */
  public List<String> startBattle(Players p1, Players p2);

  /**
   * Gets the message for when the battle is starting.
   * @return string containing the introduction message
   */
  public String getIntroMessage();
}
