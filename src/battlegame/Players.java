package battlegame;

import java.util.List;

/**
 * Represents a player that takes part in the battle. Each player has their basic abilities which
 * can be enhanced or degraded based on the Gears they receive. The updated abilities are used by
 * the player to fight the battle.
 */
public interface Players {
  /**
   * Gets the name of the player.
   * @return name of the player
   */
  public String getName();

  /**
   * Gets the basic abilities of the player.
   * @return ability of the player
   */
  public Abilities getAbility();

  /**
   * gets the updated strength value of the player after they have received all the gears.
   * @return strength of the player
   */
  public int getNewStrength();

  /**
   * gets the updated constitution value of the player after they have received all the gears.
   * @return constitution of the player
   */
  public int getNewConstitution();

  /**
   * gets the updated dexterity value of the player after they have received all the gears.
   * @return dexterity of the player
   */
  public int getNewDexterity();

  /**
   * gets the updated charisma value of the player after they have received all the gears.
   * @return charisma of the player
   */
  public int getNewCharisma();

  /**
   * gets the health value of the player before/after they have received all the gears.
   * @return health of the player
   */
  public int getHealth();

  /**
   * gets the list of all the gears that are assigned to the player.
   * @return List of all assigned gears of the player
   */
  public List<AbstractGear> getGearList();

  /**
   * gets the weapon that is assigned to the player.
   * @return weapon assigned to the player
   */
  public Weapon getWeapon();

  /**
   * gets the name/type of the weapon that is assigned to the player.
   * @return name of the weapon assigned to the player
   */
  public String getWeaponType();

  /**
   * gets the list of all the gears that the player is equipped with.
   * @return List of all assigned that the player is equipped with
   */
  public List<String> getPlayerEquippedGears();

  /**
   * gets the list of all 20 gears that the player is assigned by the arena.
   * @return List of all 20 gears that the player is assigned by the arena
   */
  public List<String> getPlayerAssignedGears();

  /**
   * Assigns a weapon to the player.
   * @param w the weapon that is being assigned to the player
   */
  public void setWeapon(Weapon w);

  /**
   * Updates the health value of the player for the battle based on the assigned gears.
   */
  public void setHealth();
}
