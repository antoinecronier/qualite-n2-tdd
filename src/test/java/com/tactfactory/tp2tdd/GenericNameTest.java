package com.tactfactory.tp2tdd;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenericNameTest {

  /**
   * NameStartWithMaj test function.
   * Maj are ascii 65->90
   */
  public static void nameStartWithMajOk(String test) {
    assertTrue(test.charAt(0) >= 65 && test.charAt(0) <= 90);
  }

  /**
   * NameStartWithMaj test function.
   * Printable other elements are 32->64 91->126
   */
  public static void nameStartWithMajKo(String test) {
    assertFalse(test.charAt(0) < 65 || test.charAt(0) > 90);
  }
}
