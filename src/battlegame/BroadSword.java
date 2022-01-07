package battlegame;

/**
 * Represents a broadsword weapon that is used by the player in field of battle. Broadswords can
 * cause 6-10 points of damage when they hit.
 */
public class BroadSword implements Weapon {
  private final int Min_Damage = 6;
  private final int Max_Damage = 10;
  private Randomizer r;

  /**
   * Construct a broadsword instance and initialize the Random generator class that will decide the
   * damage value of the sword in range of 6-10.
   *
   * @param r Randomizer object
   */
  public BroadSword(Randomizer r) {
    this.r = r;
  }

  @Override
  public int getDamageValue(int strength, int dexterity) {
    return r.getRandomInt(Min_Damage, Max_Damage);
  }

  @Override
  public String toString() {
    return "Broad Sword";
  }
}
