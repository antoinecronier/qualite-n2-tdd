package com.tactfactory.tp2tdd.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fusee {

  private String name;
  private final List<Compartiment> compartiments;

  /**
   * Fusee constructor.
   */
  public Fusee() {
    compartiments = new ArrayList<>();
    compartiments.add(new Compartiment());
    compartiments.add(new Compartiment());
  }

  /**
   * setName.
   *
   * @param name to return
   * @throws Exception to throw
   */
  public void setName(final String name) throws Exception {
    if (name == null || name.equals("")
        ||
        !((name.charAt(0) >= 65 && name.charAt(0) <= 90)
          || (name.charAt(0) >= 97 && name.charAt(0) <= 122))
    ) {
      throw new Exception();
    }
    for (char item : name.substring(1).toCharArray()) {
      if (item != '-'
                && !(item >= 65 && item <= 90) //Majuscule
                && !(item >= 48 && item <= 57) //Chiffre
                && !(item >= 97 && item <= 122) //Minuscule
          ) {
        throw new Exception();
      }
    }
    Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher(name);
    String last = null;
    int nbGroup = 0;
    while (m.find()) {
      last = m.group();
      nbGroup++;
    }

    if (last != null && last != "" && !name.endsWith(last) || nbGroup > 1) {
      throw new Exception();
    }

    this.name = Character.toString(name.charAt(0)).toUpperCase() + name.substring(1).toLowerCase();
  }

  public String getName() {

    return this.name;
  }

  public List<Compartiment> getCompartiements() {
    return Collections.unmodifiableList(this.compartiments);
  }

  /**
   * addCompartiment to add with rules.
   *
   * @param compartiment to add.
   * @throws Exception to throw.
   */
  public void addCompartiment(Compartiment compartiment) throws Exception {
    if (this.compartiments.size() + 1 > 6) {
      throw new Exception();
    }
    this.compartiments.add(compartiment);
  }

  /**
   * removeCompartiment to remove with rules.
   *
   * @param compartiment to remove.
   * @throws Exception to throw.
   */
  public void removeCompartiment(Compartiment compartiment) throws Exception {
    if (this.compartiments.size() - 1 < 2) {
      throw new Exception();
    }
    this.compartiments.remove(compartiment);
  }
}
