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
   * testNameCannotContainsOtherThanAlphabetHyphenNumberAll test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameCannotContainsOtherThanAlphabetHyphenNumberAll() throws Exception {
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

  /**
   * testNameCannotContainsOtherThanAlphabetHyphenNumber1 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameCannotContainsOtherThanAlphabetHyphenNumber1() throws Exception {
    Fusee fusee = new Fusee();

    assertThrows(Exception.class, () -> {
      fusee.setName("A&zaeaze");
    });
  }

  /**
   * testNameCannotContainsOtherThanAlphabetHyphenNumber2 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameCannotContainsOtherThanAlphabetHyphenNumber2() throws Exception {
    Fusee fusee = new Fusee();
    fusee.setName("Abcd-ef");
    assertTrue(fusee.getName().equals("Abcd-ef"));
  }

  /**
   * testNameCannotContainsOtherThanAlphabetHyphenNumber3 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameCannotContainsOtherThanAlphabetHyphenNumber3() throws Exception {
    Fusee fusee = new Fusee();
    fusee.setName("Ab--cd-ef132");
    assertTrue(fusee.getName().equals("Ab--cd-ef132"));
  }

  /**
   * testNameCannotContainsOtherThanAlphabetHyphenNumber4 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameCannotContainsOtherThanAlphabetHyphenNumber4() throws Exception {
    Fusee fusee = new Fusee();

    assertThrows(Exception.class, () -> {
      fusee.setName("Azêeaze");
    });
  }

  /**
   * testNameCannotContainsOtherThanAlphabetHyphenNumber5 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameCannotContainsOtherThanAlphabetHyphenNumber5() throws Exception {
    Fusee fusee = new Fusee();

    assertThrows(Exception.class, () -> {
      fusee.setName("Azœeaze");
    });
  }
}
