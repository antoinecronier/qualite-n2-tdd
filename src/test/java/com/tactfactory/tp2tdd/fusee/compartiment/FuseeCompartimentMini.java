package com.tactfactory.tp2tdd.fusee.compartiment;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.tactfactory.tp2tdd.models.Compartiment;
import com.tactfactory.tp2tdd.models.Fusee;
import org.junit.jupiter.api.Test;

public class FuseeCompartimentMini {

  /**
   * testCompartimentDefaultOk1 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testCompartimentDefaultOk1() throws Exception {
    Fusee fusee = new Fusee();

    assertTrue(
        fusee.getCompartiements().stream().anyMatch(x -> x.getType().equals("commandement"))
        && fusee.getCompartiements().stream().anyMatch(x -> x.getType().equals("moteur"))
    );
  }

  /**
   * testCompartimentDefaultOk2 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testCompartimentDefaultOk2() throws Exception {
    final Fusee fusee = new Fusee();

    final Compartiment commandementOld =
        fusee.getCompartiements().stream()
        .filter(x -> x.getType().equals("commandement")).findFirst().get();

    final Compartiment moteurOld =
        fusee.getCompartiements().stream()
        .filter(x -> x.getType().equals("moteur")).findFirst().get();

    final Compartiment commandementNew = new Compartiment();
    commandementNew.setType("commandement");
    fusee.addCompartiment(commandementNew);

    final Compartiment moteurNew = new Compartiment();
    moteurNew.setType("moteur");
    fusee.addCompartiment(moteurNew);

    fusee.removeCompartiment(moteurOld);
    fusee.removeCompartiment(commandementOld);

    assertTrue(
        fusee.getCompartiements().stream().anyMatch(x -> x.getType().equals("commandement"))
        && fusee.getCompartiements().stream().anyMatch(x -> x.getType().equals("moteur"))
    );
  }

  /**
   * testCompartimentDefaultKo1 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testCompartimentDefaultKo1() throws Exception {
    Fusee fusee = new Fusee();

    final Compartiment moteurOld =
        fusee.getCompartiements().stream()
        .filter(x -> x.getType().equals("moteur")).findFirst().get();

    Compartiment moteurNew = new Compartiment();
    moteurNew.setType("other");
    fusee.addCompartiment(moteurNew);

    assertThrows(Exception.class, () -> {
      fusee.removeCompartiment(moteurOld);
    });
  }

  /**
   * testCompartimentDefaultKo1 test function.
   *
   * @throws Exception to throw.
   */
  @Test
  public void testCompartimentDefaultKo2() throws Exception {
    Fusee fusee = new Fusee();

    Compartiment commandementOld = fusee.getCompartiements().stream().filter(x -> x.getType().equals("commandement")).findFirst().get();

    Compartiment commandementNew = new Compartiment();
    commandementNew.setType("other");
    fusee.addCompartiment(commandementNew);

    assertThrows(Exception.class, () -> {
        fusee.removeCompartiment(commandementOld);
    });
  }
}
