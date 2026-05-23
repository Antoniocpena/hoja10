import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CentroGrafoTest {

    @Test
    public void testCentroDelGrafo() {

        grafo g = new grafo(5);

        g.agregarCiudad("A");
        g.agregarCiudad("B");
        g.agregarCiudad("C");

        g.agregarArco("A", "B", 2);
        g.agregarArco("B", "C", 2);
        g.agregarArco("A", "C", 10);

        Floyd floyd =
                new Floyd(
                        g.getMatriz(),
                        g.getCiudades()
                );

        floyd.calcularRutas();

        CentroGrafo centro =
                new CentroGrafo();

        String resultado =
                centro.calcularCentro(
                        floyd.getDistancias(),
                        g.getCiudades()
                );

        assertNotNull(resultado);
    }
}