package battlegame;

/**
 * Represents the weapon that a player can use in the battle. Each weapon has a range of damage
 * value associated with it which determines how much damage a successful hit to the opponent will
 * cause.
 */
public interface Weapon {

  /**
   * Represents the damage value that the weapon causes.
   * @param strength strength of the player using the weapon
   * @param dexterity dexterity of the player using the weapon
   * @return damage value the weapon causes on strike.
   */
  public int getDamageValue(int strength, int dexterity);
}
