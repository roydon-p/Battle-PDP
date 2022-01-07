package battlegame;

/**
 * Represents a pair of footwear gear that is worn on the player's feet and affects the player's
 * dexterity. Each player can only wear one piece of footwear at a time.
 */
public class Footwear extends AbstractGear {
  private String name;

  /**
   * Construct a Footwear instance and initialize its name.
   * @param name of the footwear
   * @param r Randomizer object
   */
  public Footwear(String name, Randomizer r) {
    super(r);
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  protected int updateDexterity(int dexterity) {
    return dexterity + this.value_change;
  }

  @Override
  protected boolean isFootwear() {
    return true;
  }

}
