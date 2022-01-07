package battlegame;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single player that will take part in the battle. The player has basic abilities as
 * well as additional temporary enhancements to the abilities for each battle based on the gears
 * that are assigned to the player.
 */
public class Player implements Players {
  private Abilities a;
  private Weapon w;
  private String name;

  private boolean headGearUsed;
  private boolean footwearUsed;
  private int beltUnitsUsed;

  private int new_strength;
  private int new_constitution;
  private int new_dexterity;
  private int new_charisma;
  private int health;

  private List<String> hg;
  private List<String> pt;
  private List<String> bt;
  private List<String> fw;
  private List<String> assignedGears;
  protected List<AbstractGear> gearList;

  /**
   * Initializes the data for the player using a helper method.
   *
   * @param name name of the player
   * @param r    Randomizer object
   */
  public Player(String name, Randomizer r) {
    a = new Ability(r);
    this.name = name;
    this.gearList = new ArrayList<>();
    initializePlayerAttributes();
  }

  /**
   * Helper method that helps to reset the player attributes between different instances of
   * the battle.
   */
  private void initializePlayerAttributes() {
    headGearUsed = false;
    footwearUsed = false;
    beltUnitsUsed = 0;
    w = null;
    hg = new ArrayList<>();
    pt = new ArrayList<>();
    bt = new ArrayList<>();
    fw = new ArrayList<>();
    new_strength = a.getStrength();
    new_constitution = a.getConstitution();
    new_dexterity = a.getDexterity();
    new_charisma = a.getCharisma();
    health = new_strength + new_constitution + new_dexterity + new_charisma;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Abilities getAbility() {
    return a;
  }

  @Override
  public int getNewStrength() {
    return this.new_strength;
  }

  @Override
  public int getNewConstitution() {
    return this.new_constitution;
  }

  @Override
  public int getNewDexterity() {
    return this.new_dexterity;
  }

  @Override
  public int getNewCharisma() {
    return this.new_charisma;
  }

  @Override
  public int getHealth() {
    return this.health;
  }

  @Override
  public List<AbstractGear> getGearList() {
    return this.gearList;
  }

  @Override
  public Weapon getWeapon() {
    return this.w;
  }

  @Override
  public String getWeaponType() {
    if (w == null) {
      return "NA";
    } else {
      return this.w.toString();
    }
  }

  @Override
  public List<String> getPlayerEquippedGears() {
    hg.sort(String::compareToIgnoreCase);
    pt.sort(String::compareToIgnoreCase);
    bt.sort(String::compareToIgnoreCase);
    fw.sort(String::compareToIgnoreCase);
    List<String> gears = new ArrayList<>();
    gears.addAll(hg);
    gears.addAll(pt);
    gears.addAll(bt);
    gears.addAll(fw);
    if (gears.size() == 0) {
      gears.add("NA");
    }
    return gears;
  }

  @Override
  public List<String> getPlayerAssignedGears() {
    List<String> h = new ArrayList<>();
    List<String> p = new ArrayList<>();
    List<String> b = new ArrayList<>();
    List<String> f = new ArrayList<>();
    for (AbstractGear g : this.gearList) {
      if (g.isHeadgear()) {
        h.add(g.getName());
      }
      if (g.isPotion()) {
        p.add(g.getName());
      }
      if (g.isBelt()) {
        b.add(g.getName());
      }
      if (g.isFootwear()) {
        f.add(g.getName());
      }
    }
    h.sort(String::compareToIgnoreCase);
    p.sort(String::compareToIgnoreCase);
    b.sort(String::compareToIgnoreCase);
    f.sort(String::compareToIgnoreCase);
    List<String> allGears = new ArrayList<>();
    allGears.addAll(h);
    allGears.addAll(p);
    allGears.addAll(b);
    allGears.addAll(f);
    if (allGears.size() == 0) {
      allGears.add("NA");

    }
    return allGears;
  }

  /**
   * Helper method that creates a list of Gears based on its type.
   *
   * @param g Gear assigned to the player
   */
  private void createEquippedGearList(AbstractGear g) {
    if (g.isHeadgear()) {
      hg.add(g.getName());
    }
    if (g.isPotion()) {
      pt.add(g.getName());
    }
    if (g.isBelt()) {
      bt.add(g.getName());
    }
    if (g.isFootwear()) {
      fw.add(g.getName());
    }
  }

  @Override
  public void setWeapon(Weapon w) {
    this.w = w;
  }

  @Override
  public void setHealth() {
    initializePlayerAttributes();
    //check if assigned gearlist is empty
    if (gearList.size() != 0) {
      // for each gear in the gearlist do the following
      for (AbstractGear g : gearList) {
        // For the current gear, check if the player already has a headgear and/or footwear and/or
        // they have reached max limit of the belts they can carry. If none of the condition is
        // true, then update the players' abilities.
        if ((g.isHeadgear() && !headGearUsed) || g.isPotion()
                || (g.isFootwear() && !footwearUsed)
                || (g.isBelt() && (beltUnitsUsed + g.getUnits()) <= 10)) {
          this.new_strength = g.updateStrength(new_strength);
          this.new_constitution = g.updateConstitution(new_constitution);
          this.new_dexterity = g.updateDexterity(new_dexterity);
          this.new_charisma = g.updateCharisma(new_charisma);
          if (g.isHeadgear()) {
            headGearUsed = true;
          }
          if (g.isFootwear()) {
            footwearUsed = true;
          }
          if (g.isBelt()) {
            beltUnitsUsed = beltUnitsUsed + g.getUnits();
          }
          createEquippedGearList(g);
        }
      }
    }
    this.health = new_strength + new_constitution + new_dexterity + new_charisma;
  }
}
