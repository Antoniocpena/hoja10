import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GrafoTest {

    @Test
    public void testAgregarCiudad() {

        grafo g = new grafo(5);

        g.agregarCiudad("Guatemala");

        assertTrue(
                g.getCiudades().contains("Guatemala")
        );
    }

    @Test
    public void testAgregarArco() {

        grafo g = new grafo(5);

        g.agregarCiudad("Guatemala");
        g.agregarCiudad("Antigua");

        g.agregarArco("Guatemala", "Antigua", 45);

        assertEquals(
                45,
                g.getMatriz()[0][1]
        );
    }

    @Test
    public void testEliminarArco() {

        grafo g = new grafo(5);

        g.agregarCiudad("Guatemala");
        g.agregarCiudad("Antigua");

        g.agregarArco("Guatemala", "Antigua", 45);

        g.eliminarArco("Guatemala", "Antigua");

        assertEquals(
                99999,
                g.getMatriz()[0][1]
        );
    }
}