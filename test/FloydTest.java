import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FloydTest {

    @Test
    public void testFloydDistanciaMinima() {

        grafo g = new grafo(5);

        g.agregarCiudad("A");
        g.agregarCiudad("B");
        g.agregarCiudad("C");

        g.agregarArco("A", "B", 5);
        g.agregarArco("B", "C", 3);
        g.agregarArco("A", "C", 20);

        Floyd floyd =
                new Floyd(
                        g.getMatriz(),
                        g.getCiudades()
                );

        floyd.calcularRutas();

        int[][] resultado =
                floyd.getDistancias();

        assertEquals(
                8,
                resultado[0][2]
        );
    }

    @Test
    public void testSinRuta() {

        grafo g = new grafo(5);

        g.agregarCiudad("A");
        g.agregarCiudad("B");

        Floyd floyd =
                new Floyd(
                        g.getMatriz(),
                        g.getCiudades()
                );

        floyd.calcularRutas();

        int[][] resultado =
                floyd.getDistancias();

        assertEquals(
                99999,
                resultado[0][1]
        );
    }
}