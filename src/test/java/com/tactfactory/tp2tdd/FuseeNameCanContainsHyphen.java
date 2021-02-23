package com.tactfactory.tp2tdd;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.tactfactory.tp2tdd.models.Fusee;
import org.junit.jupiter.api.Test;

public class FuseeNameCanContainsHyphen {

  /**
   * testNameHyphenKo test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameHyphenKo() throws Exception {
    Fusee fusee = new Fusee();
    fusee.setName("Ab-cde-f-");
    assertTrue(fusee.getName().equals("Ab-cde-f-"));
  }

  private int charLoop;

  /**
   * testNameCannotContainsOtherThanAlphabetHyphenNumber test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameCannotContainsOtherThanAlphabetHyphenNumber() throws Exception {
    Fusee fusee = new Fusee();

    for (charLoop = 32; charLoop < 127; charLoop++) {
      if (charLoop != '-'
          && !(charLoop >= 65 && charLoop <= 90) //Majuscule
          && !(charLoop >= 48 && charLoop <= 57) //Chiffre
          && !(charLoop >= 97 && charLoop <= 122)) //Minuscule
      {
        assertThrows(Exception.class, () -> {
          fusee.setName("A" + Character.toString(charLoop));
        });
      }
    }
  }
}
