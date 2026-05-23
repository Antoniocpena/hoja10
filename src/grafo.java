import java.util.ArrayList;

public class grafo {

    private ArrayList<String> ciudades;
    private int[][] matriz;

    private final int INF = 99999;

    public grafo(int tamaño) {

        ciudades = new ArrayList<>();
        matriz = new int[tamaño][tamaño];

        for (int i = 0; i < tamaño; i++) {

            for (int j = 0; j < tamaño; j++) {

                if (i == j) {
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = INF;
                }
            }
        }
    }

    public void agregarCiudad(String ciudad) {

        if (!ciudades.contains(ciudad)) {
            ciudades.add(ciudad);
        }
    }

    private int obtenerIndice(String ciudad) {

        return ciudades.indexOf(ciudad);
    }

    public void agregarArco(String origen, String destino, int distancia) {

        int i = obtenerIndice(origen);
        int j = obtenerIndice(destino);

        matriz[i][j] = distancia;
    }

    public void eliminarArco(String origen, String destino) {

        int i = obtenerIndice(origen);
        int j = obtenerIndice(destino);

        matriz[i][j] = INF;
    }

    public void mostrarMatriz() {

        System.out.println("\nMATRIZ");

        for (int i = 0; i < ciudades.size(); i++) {

            for (int j = 0; j < ciudades.size(); j++) {

                if (matriz[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(matriz[i][j] + " ");
                }
            }

            System.out.println();
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public ArrayList<String> getCiudades() {
        return ciudades;
    }
}
