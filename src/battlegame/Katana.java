package battlegame;

/**
 * Represents a katana weapon that is used by the player in field of battle. Katana swords can
 * cause 4-6 points of damage when they hit. However, since these are light swords, a player can
 * carry 2 of them together. However, each strike of katana is different and will have different
 * damage value.
 */
public class Katana implements Weapon {
  private final int Min_Damage = 4;
  private final int Max_Damage = 6;
  private Randomizer r;

  /**
   * Construct a Katana instance and initialize the Randomizer object that will decide the
   * damage value of each sword in range of 4-6.
   * @param r Randomizer object
   */
  public Katana(Randomizer r) {
    this.r = r;
  }

  @Override
  public int getDamageValue(int strength, int dexterity) {
    return (r.getRandomInt(Min_Damage, Max_Damage)
            + r.getRandomInt(Min_Damage, Max_Damage));
  }

  @Override
  public String toString() {
    return "Katana";
  }
}
