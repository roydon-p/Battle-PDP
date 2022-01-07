package battlegame;

/**
 * Abstract class of Gears is created to contain all the common code for the different types
 * of gears. The class is package-private as it is only used internally within the Model.
 */
abstract class AbstractGear implements Gear {
  private final int Min_Change = 1;
  private final int Max_Change = 15;
  protected int value_change;

  /**
   * Protected constructor initializes the change value which is generated randomly for each gear.
   * This change value augments the Players basic abilities and helps them during the Battle.
   *
   * @param r Randomizer object
   */
  protected AbstractGear(Randomizer r) {
    value_change = r.getRandomInt(Min_Change, Max_Change);
  }

  @Override
  public int getEffect() {
    return value_change;
  }

  @Override
  public String getName() {
    return "";
  }

  public int getUnits() {
    return 0;
  }

  protected void setNegativeEffect() {
    value_change = value_change * (-1);
  }

  protected int updateStrength(int strength) {
    return strength;
  }

  protected int updateConstitution(int constitution) {
    return constitution;
  }

  protected int updateDexterity(int dexterity) {
    return dexterity;
  }

  protected int updateCharisma(int charisma) {
    return charisma;
  }

  protected boolean isHeadgear() {
    return false;
  }

  protected boolean isPotion() {
    return false;
  }

  protected boolean isBelt() {
    return false;
  }

  protected boolean isFootwear() {
    return false;
  }
}
