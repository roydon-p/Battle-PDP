package battlegame;

/**
 * Represents a potion that is consumed by the player before entering the field of battle. A potion
 * can affect any of the abilities of the player based on the type of potion. A player can consume
 * as many potions as possible without any restrictions based on their availability to the Player.
 */
public class Potion extends AbstractGear {
  private String name;
  private String affects;

  /**
   * Construct a potion instance and initialize its name and the ability that it affects.
   * @param r Randomizer object
   */
  public Potion(Randomizer r) {
    super(r);
    int index = r.getRandomInt(0,PotionTypes.values().length);
    this.name = PotionTypes.values()[index].getName();
    this.affects = PotionTypes.values()[index].getAffects();
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
  protected boolean isPotion() {
    return true;
  }

}
