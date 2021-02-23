package com.tactfactory.tp2tdd;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.tactfactory.tp2tdd.models.Fusee;
import com.tactfactory.tp2tdd.utils.GenericNameTest;
import com.tactfactory.tp2tdd.utils.StringUtils;
import org.junit.jupiter.api.Test;

public class FuseeNameTest {

  /**
   * testNameStartWithMajOk test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameStartWithMajOk() throws Exception {
    Fusee fusee = new Fusee();
    fusee.setName("AaaaA");
    GenericNameTest.nameStartWithMajOk(fusee.getName());
  }

  /**
   * testNameStartWithMajKo test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testNameStartWithMajKo() throws Exception {
    Fusee fusee = new Fusee();
    fusee.setName("aAAAa");
    GenericNameTest.nameStartWithMajOk(fusee.getName());
  }

  /**
   * testNameStartWithMajNull test function.
   */
  @Test
  public void testNameStartWithMajNull() {
    Fusee fusee = new Fusee();
    assertThrows(Exception.class, () -> {
      fusee.setName(null);
    });
  }

  /**
   * testNameStartWithMajEmpty test function.
   */
  @Test
  public void testNameStartWithMajEmpty() {
    Fusee fusee = new Fusee();
    assertThrows(Exception.class, () -> {
      fusee.setName("");
    });
  }

  /**
   * testNameStartWithMajRandom test function.
   *
   * @throws Exception to throw
   */
  @Test
  public void testNameStartWithMajRandom() throws Exception {
    Fusee fusee = new Fusee();
    fusee.setName(StringUtils.getRandomString());
    GenericNameTest.nameStartWithMajOk(fusee.getName());
  }
}
