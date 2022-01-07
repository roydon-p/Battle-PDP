package battlegame;

/**
 * Represents the Types of the Potions that a player can consume. Each potion can affect any 1 of
 * the abilities. The abilities that potion affects is represented by 1-Strength, 2-Constitution,
 * 3-Dexterity, 4-Charisma.
 */
public enum PotionTypes {
  ETHEREALNESS("Potion of Etherealness", "1"),
  SHARPNESS("Potion of Sharpness", "3"),
  SLIPPERINESS("Potion of Slipperiness", "3"),
  FLYING("Potion of Flying", "4"),
  HEALING("Potion of Healing", "1"),
  GIANTSTRENGTH("Potion of Giant Strength", "1"),
  POISON("Potion of Poison", "2"),
  SPEED("Potion of Speed", "2");

  private final String name;
  private final String affects;

  PotionTypes(String name, String affects) {
    this.name = name;
    this.affects = affects;
  }

  /**
   * The name of the potion.
   * @return name of the potion
   */
  public String getName() {
    return name;
  }

  /**
   * The ability that the potion affects.
   * @return ability that the potion affects
   */
  public String getAffects() {
    return affects;
  }
}
