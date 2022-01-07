package battlegame;

/**
 * Represents the Types of the Belts that a player can acquire. Each belt can affect up to 2
 * abilities. The abilities that belt affects is represented by 1-Strength, 2-Constitution,
 * 3-Dexterity, 4-Charisma.
 */
public enum BeltTypes {
  TACTICALBELT("Tactical Belt", BeltSize.MEDIUM, "1,2"),
  WHITEBELT("White Belt", BeltSize.SMALL, "4"),
  ORANGEBELT("Orange Belt", BeltSize.SMALL, "3"),
  REDBELT("Red Belt", BeltSize.SMALL, "1"),
  WEAPONBELT("Weapon Belt", BeltSize.LARGE, "2"),
  PRECISIONBELT("Precision Belt", BeltSize.MEDIUM, "4"),
  TACTICALBELTV2("Tactical Level 2 Belt", BeltSize.LARGE, "1,3");

  private final String name;
  private final BeltSize size;
  private final String affects;

  BeltTypes(String name, BeltSize size, String affects) {
    this.name = name;
    this.size = size;
    this.affects = affects;
  }

  /**
   * The name of the belt.
   * @return name of the belt
   */
  public String getName() {
    return name;
  }

  /**
   * The Size of the belt.
   * @return size of the belt
   */
  public BeltSize getSize() {
    return size;
  }

  /**
   * The ability that the belt affects.
   * @return ability that the belt affects
   */
  public String getAffects() {
    return affects;
  }
}
