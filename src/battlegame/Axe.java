package battlegame;

/**
 * Represents an Axe weapon that is used by the player in field of battle. Axe can cause
 * 6-10 points of damage when they hit.
 */
public class Axe implements Weapon {
  private final int Min_Damage = 6;
  private final int Max_Damage = 10;
  private Randomizer r;

  /**
   * Construct an Axe instance and set the value for Randomizer that will decide the
   * damage value of the axe in range of 6-10.
   * @param r Randomizer object
   */
  public Axe(Randomizer r) {
    this.r = r;
  }

  @Override
  public int getDamageValue(int strength, int dexterity) {
    return r.getRandomInt(Min_Damage, Max_Damage);
  }

  @Override
  public String toString() {
    return "Axe";
  }
}
