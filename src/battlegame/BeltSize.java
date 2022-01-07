package battlegame;

/**
 * Represents the size of the Belt. Players have the ability to wear 10 "units" of belts
 * and these units are defined in this enum: small-1 unit, medium-2 units, large-4 units.
 */
public enum BeltSize {
  SMALL(1), MEDIUM(2), LARGE(4);

  private final int value;

  BeltSize(final int units) {
    value = units;
  }

  /**
   * The Value of units of each belt size.
   * @return the unit value of the belt size
   */
  public int getValue() {
    return value;
  }
}
