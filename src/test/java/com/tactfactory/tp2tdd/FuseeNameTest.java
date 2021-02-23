package com.tactfactory.tp2tdd;

import com.tactfactory.tp2tdd.models.Fusee;
import com.tactfactory.tp2tdd.utils.GenericNameTest;
import com.tactfactory.tp2tdd.utils.StringUtils;
import org.junit.jupiter.api.Test;

public class FuseeNameTest {

  /**
   * testNameStartWithMajOk test function.
   */
  @Test
  public void testNameStartWithMajOk() {
    Fusee fusee = new Fusee();
    fusee.setName(StringUtils.getRandomString());
    GenericNameTest.nameStartWithMajOk(fusee.getName());
  }
}
