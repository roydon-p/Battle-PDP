package battlegame;

/**
 * Represents the Belt gear that is worn around the player's torso and affects
 * up to two of the player's abilities.
 */
public class Belt extends AbstractGear {
  private String name;
  private BeltSize size;
  private String affects;

  /**
   * Construct a Belt instance and initialize its name, size and the ability that it affects.
   * @param r Randomizer object
   */
  public Belt(Randomizer r) {
    super(r);
    int index = r.getRandomInt(0,BeltTypes.values().length);
    this.name = BeltTypes.values()[index].getName();
    this.size = BeltTypes.values()[index].getSize();
    this.affects = BeltTypes.values()[index].getAffects();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  protected int updateStrength(int strength) {
    if (affects.contains("1")) {
      return strength + value_change;
    }
    return strength;
  }

  @Override
  protected int updateConstitution(int constitution) {
    if (affects.contains("2")) {
      return constitution + value_change;
    }
    return constitution;
  }

  @Override
  protected int updateDexterity(int dexterity) {
    if (affects.contains("3")) {
      return dexterity + value_change;
    }
    return dexterity;
  }

  @Override
  protected int updateCharisma(int charisma) {
    if (affects.contains("4")) {
      return charisma + value_change;
    }
    return charisma;
  }

  @Override
  protected boolean isBelt() {
    return true;
  }

  @Override
  public int getUnits() {
    return size.getValue();
  }
}

