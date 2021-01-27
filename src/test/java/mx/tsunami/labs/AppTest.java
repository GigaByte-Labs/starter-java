package mx.tsunami.labs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Pruebas unitarias para esta asignacion
 */
public class AppTest {

  /**
   * Prueba unitaria para Happy Path
   */
  @Test
  public void test_happy_path() {
    Assert.assertEquals("Hola PEPE!", App.obtenerSaludo("PEPE"));
  }

  /**
   * Prueba unitaria para casos de frontera null
   */
  @Test
  public void test_null_argument() {
    Assert.assertNull(App.obtenerSaludo(null));
  }

  /**
   * Prueba unitaria para casos de frontera empty
   */
  @Test
  public void test_empty_string() {
    Assert.assertNull(App.obtenerSaludo(""));
  }

  /**
   * Prueba unitaria para casos de frontera empty
   */
  @Test
  public void test_mundo_string() {
    Assert.assertEquals("Hola Mundo!", App.obtenerSaludo("mundo"));
    Assert.assertEquals("Hola Mundo!", App.obtenerSaludo("mundo!"));
    Assert.assertEquals("Hola Mundo!", App.obtenerSaludo("MUNDO"));
    Assert.assertEquals("Hola Mundo!", App.obtenerSaludo("MUNDO!"));
  }


  public static void main(String[] args) {
    System.out.println("\n\n");
    System.out.println("***********************  Ejecucion de pruebas unitarias!  ************************");
    org.junit.runner.JUnitCore.main("mx.tsunami.labs.AppTest");
  }
}
