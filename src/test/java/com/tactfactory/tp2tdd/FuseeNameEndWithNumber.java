package com.tactfactory.tp2tdd;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.tactfactory.tp2tdd.models.Fusee;
import org.junit.jupiter.api.Test;

public class FuseeNameEndWithNumber {

  /**
   * testNameEndWithNumber1 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameEndWithNumber1() throws Exception {
    Fusee fusee = new Fusee();
    fusee.setName("Aze0123456789");
    assertTrue(fusee.getName().equals("Aze0123456789"));
  }

  /**
   * testNameEndWithNumber2 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameEndWithNumber2() throws Exception {
    Fusee fusee = new Fusee();
    fusee.setName("Aze-aze-789");
    assertTrue(fusee.getName().equals("Aze-aze-789"));
  }

  /**
   * testNameEndWithNumber3 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameEndWithNumber3() throws Exception {
    Fusee fusee = new Fusee();
    fusee.setName("A9");
    assertTrue(fusee.getName().equals("A9"));
  }

  /**
   * testNameEndWithNumberKo1 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameEndWithNumberKo1() throws Exception {
    Fusee fusee = new Fusee();

    assertThrows(Exception.class, () -> {
      fusee.setName("A9a");
    });
  }

  /**
   * testNameEndWithNumberKo2 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameEndWithNumberKo2() throws Exception {
    Fusee fusee = new Fusee();

    assertThrows(Exception.class, () -> {
      fusee.setName("Aazeaze9-");
    });
  }

  /**
   * testNameEndWithNumberKo3 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameEndWithNumberKo3() throws Exception {
    Fusee fusee = new Fusee();

    assertThrows(Exception.class, () -> {
      fusee.setName("Aaze1aze1");
    });
  }
}
