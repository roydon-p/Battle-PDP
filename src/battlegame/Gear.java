package battlegame;

/**
 * Represents the gears that a player can use in the battle. Players' abilities can be
 * temporarily affected, either positively or negatively, by the gear that they use.
 */
public interface Gear {
  /**
   * Represents the change in an ability of the player that the gear affects.
   * @return effect of the gear on the player
   */
  public int getEffect();

  /**
   * The name of the Gear.
   * @return name of the gear
   */
  public String getName();

  /**
   * Gets the units of belts based on its size.
   * @return units of belt gear
   */
  public int getUnits();
}
