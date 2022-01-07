package battlegame;

/**
 * Represents a headgear that is worn on the player's head and affects the player's constitution.
 * Each player can only wear one piece of headgear at a time.
 */
public class HeadGear extends AbstractGear {
  private String name;

  /**
   * Construct a headgear instance and initialize its name.
   * @param name of the headgear
   * @param r Randomizer object
   */
  public HeadGear(String name, Randomizer r) {
    super(r);
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  protected int updateConstitution(int constitution) {
    return constitution + value_change;
  }

  @Override
  protected boolean isHeadgear() {
    return true;
  }

}
