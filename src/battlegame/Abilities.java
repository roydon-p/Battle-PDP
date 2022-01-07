package battlegame;

/**
 * Abilities represent all the attributes that a player can possess before they enter the arena.
 * These abilities decide the Health of the player and help them to win the battles.
 */
public interface Abilities {
  /**
   * Represents how effective the player is at striking their opponent.
   * @return strength of the player
   */
  public int getStrength();

  /**
   * Represents how much damage a player can take when they are hit in battle.
   * @return constitution of the player
   */
  public int getConstitution();

  /**
   * Represents how effective the player is at avoiding a strike from their opponent.
   * @return dexterity of the player
   */
  public int getDexterity();

  /**
   * Represents how the opponent views the player.
   * @return charisma of the player
   */
  public int getCharisma();
}
