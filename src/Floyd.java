import java.util.ArrayList;

public class Floyd {

    private int[][] distancias;
    private int[][] caminos;
    private ArrayList<String> ciudades;

    private final int INF = 99999;

    public Floyd(int[][] matriz, ArrayList<String> ciudades) {

        int n = matriz.length;

        distancias = new int[n][n];
        caminos = new int[n][n];

        this.ciudades = ciudades;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                distancias[i][j] = matriz[i][j];
                caminos[i][j] = -1;
            }
        }
    }

    public void calcularRutas() {

        int n = distancias.length;

        for (int k = 0; k < n; k++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (distancias[i][k] != INF &&
                        distancias[k][j] != INF &&
                        distancias[i][k] + distancias[k][j] < distancias[i][j]) {

                        distancias[i][j] =
                                distancias[i][k] + distancias[k][j];

                        caminos[i][j] = k;
                    }
                }
            }
        }
    }

    public void mostrarRuta(String origen, String destino) {

        int i = ciudades.indexOf(origen);
        int j = ciudades.indexOf(destino);

        if (distancias[i][j] == INF) {

            System.out.println("No existe ruta");
            return;
        }

        System.out.println("Distancia minima: " + distancias[i][j]);

        System.out.print("Ruta: " + origen + " ");

        imprimirIntermedios(i, j);

        System.out.println(destino);
    }

    private void imprimirIntermedios(int i, int j) {

        int k = caminos[i][j];

        if (k == -1) {
            return;
        }

        imprimirIntermedios(i, k);

        System.out.print(ciudades.get(k) + " ");

        imprimirIntermedios(k, j);
    }

    public int[][] getDistancias() {

        return distancias;
    }
}