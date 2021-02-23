package com.tactfactory.tp2tdd.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fusee {

  private String name;

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
}
