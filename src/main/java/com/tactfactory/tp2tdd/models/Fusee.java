package com.tactfactory.tp2tdd.models;

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
    this.name = Character.toString(name.charAt(0)).toUpperCase() + name.substring(1).toLowerCase();
  }

  public String getName() {

    return this.name;
  }
}
