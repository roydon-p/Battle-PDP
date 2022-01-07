package battlegame;

import java.util.ArrayList;
import java.util.List;

/**
 * Ability represents the individual abilities of each player before they enter the arena.
 */
public class Ability implements Abilities {
  private int strength;
  private int constitution;
  private int dexterity;
  private int charisma;
  private Randomizer r;

  /**
   * Initialize the Ability attributes by using logic of rolling a dice 4 times for each attribute
   * and summing up the maximum 3 outputs.
   *
   * @param r Randomizer object
   */
  public Ability(Randomizer r) {
    this.r = r;
    this.strength = generateAbilityValue();
    this.constitution = generateAbilityValue();
    this.dexterity = generateAbilityValue();
    this.charisma = generateAbilityValue();
  }

  private int generateAbilityValue() {
    int rollCount = 4;
    int randomBound = 6;
    int abilityValue;
    List<Integer> abilityValues = new ArrayList<>();
    //RandomGenerator r = new RandomGenerator();
    //roll dice minimum 4 times till you get at least 3 values greater than 1
    for (int i = 0; i < rollCount; i++) {
      //represents 1 dice roll
      int randomValue = r.getRandomInt(0, randomBound) + 1;
      if (randomValue < 2) {
        rollCount++;
      } else {
        abilityValues.add(randomValue);
      }
    }
    //sort the values of the dice roll
    abilityValues.sort(Integer::compareTo);
    //add the 3 largest values to generate ability value
    abilityValue = abilityValues.get(3) + abilityValues.get(2) + abilityValues.get(1);
    return abilityValue;
  }

  @Override
  public int getStrength() {
    return strength;
  }

  @Override
  public int getConstitution() {
    return constitution;
  }

  @Override
  public int getDexterity() {
    return dexterity;
  }

  @Override
  public int getCharisma() {
    return charisma;
  }
}
