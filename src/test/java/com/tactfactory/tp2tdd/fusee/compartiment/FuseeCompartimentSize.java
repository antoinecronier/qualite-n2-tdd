package com.tactfactory.tp2tdd.fusee.compartiment;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.tactfactory.tp2tdd.models.Compartiment;
import com.tactfactory.tp2tdd.models.Fusee;
import org.junit.jupiter.api.Test;

public class FuseeCompartimentSize {

  /**
   * testCompartimentOk1 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testCompartimentOk1() throws Exception {
    Fusee fusee = new Fusee();
    assertTrue(fusee.getCompartiements().size() == 2);
  }

  /**
   * testCompartimentOk2 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testCompartimentOk2() throws Exception {
    Fusee fusee = new Fusee();
    for (int i = 0; i < 4; i++) {
      fusee.addCompartiment(new Compartiment());
    }

    assertTrue(fusee.getCompartiements().size() == 6);
  }

  /**
   * testCompartimentOk2 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testCompartimentOk3() throws Exception {
    Fusee fusee = new Fusee();
    for (int i = 0; i < 4; i++) {
      fusee.addCompartiment(new Compartiment());
    }

    for (int i = 0; i < 2; i++) {
      fusee.removeCompartiment(
              fusee.getCompartiements().get(fusee.getCompartiements().size() - 1 - i));
    }

    assertTrue(fusee.getCompartiements().size() == 4);
  }

  /**
   * testCompartimentKo1 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testCompartimentKo1() throws Exception {
    Fusee fusee = new Fusee();

    assertThrows(Exception.class, () -> {
      for (int i = 0; i < 10; i++) {
        fusee.getCompartiements().add(new Compartiment());
      }
    });
  }

  /**
   * testCompartimentKo1b test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testCompartimentKo1b() throws Exception {
    Fusee fusee = new Fusee();

    assertThrows(Exception.class, () -> {
      for (int i = 0; i < 10; i++) {
        fusee.addCompartiment(new Compartiment());
      }
    });
  }

  /**
   * testCompartimentKo2 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testCompartimentKo2() throws Exception {
    Fusee fusee = new Fusee();

    assertThrows(Exception.class, () -> {
      fusee.getCompartiements().clear();
    });
  }

  /**
   * testCompartimentKo3 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testCompartimentKo3() throws Exception {
    Fusee fusee = new Fusee();

    assertThrows(Exception.class, () -> {
      fusee.getCompartiements().remove(fusee.getCompartiements().get(0));
    });
  }

  /**
   * testCompartimentKo3b test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testCompartimentKo3b() throws Exception {
    Fusee fusee = new Fusee();

    assertThrows(Exception.class, () -> {
      fusee.removeCompartiment(fusee.getCompartiements().get(0));
    });
  }
}
