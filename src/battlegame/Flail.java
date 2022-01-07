package battlegame;

/**
 * Represents a Flail weapon that is used by the player in field of battle. Flails can
 * cause 8-12 points of damage when they hit given they are used by a player with dexterity > 14,
 * else they cause only half damage.
 */
public class Flail implements Weapon {
  private final int Min_Damage = 8;
  private final int Max_Damage = 12;
  private final int Dexterity_Limit = 14;
  private Randomizer r;

  /**
   * Construct a Flail instance and initialize the Random generator class that will decide the
   * damage value of the axe in range of 8-12.
   *
   * @param r Randomizer object
   */
  public Flail(Randomizer r) {
    this.r = r;
  }

  @Override
  public int getDamageValue(int strength, int dexterity) {
    int damage = r.getRandomInt(Min_Damage, Max_Damage);
    if (dexterity <= Dexterity_Limit) {
      return damage / 2;
    }
    return damage;
  }

  @Override
  public String toString() {
    return "Flail";
  }
}
