package com.tactfactory.tp2tdd;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.tactfactory.tp2tdd.models.Fusee;
import org.junit.jupiter.api.Test;

public class FuseeNameIsLowerCaseTest {

  /**
   * testNameIsLowerCase test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameIsLowerCaseOk() throws Exception {
    Fusee fusee = new Fusee();
    fusee.setName("Abcdef");
    assertTrue(fusee.getName().substring(1).equals("bcdef"));
  }

  /**
   * testNameIsLowerCase test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameIsLowerCaseKo() throws Exception {
    Fusee fusee = new Fusee();
    fusee.setName("AbcDeF");
    assertTrue(fusee.getName().substring(1).equals("bcdef"));
  }

  /**
   * testNameIsLowerCase test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameIsLowerCaseKoWithNoAlphabet() throws Exception {
    Fusee fusee = new Fusee();
    fusee.setName("abc-!123DeF");
    assertTrue(fusee.getName().substring(1).equals("bc-!123def"));
  }
}
