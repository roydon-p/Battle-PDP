package battlegame;

/**
 * Represents a two-handed sword weapon that is used by the player in field of battle. These swords
 * can cause 8-12 points of damage when they hit given they are used by a player with strength > 14,
 * else they cause only half damage.
 */
public class TwoHandedSword implements Weapon {
  private final int Min_Damage = 8;
  private final int Max_Damage = 12;
  private final int Strength_Limit = 14;
  Randomizer r;

  /**
   * Construct a two-handed sword instance and initialize the Random generator class that will
   * decide the damage value of the sword in range of 8-12.
   * @param r Randomizer object
   */
  public TwoHandedSword(Randomizer r) {
    this.r = r;
  }

  @Override
  public int getDamageValue(int strength, int dexterity) {
    int damage = r.getRandomInt(Min_Damage, Max_Damage);
    if (strength <= Strength_Limit) {
      return damage / 2;
    }
    return damage;
  }

  @Override
  public String toString() {
    return "Two-Handed Sword";
  }
}
