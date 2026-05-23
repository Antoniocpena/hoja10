public class CentroGrafo {

    private final int INF = 99999;

    public String calcularCentro(int[][] matriz) {

        int n = matriz.length;

        int centro = -1;
        int minimaExcentricidad = INF;

        for (int j = 0; j < n; j++) {

            int excentricidad = 0;

            for (int i = 0; i < n; i++) {

                if (matriz[i][j] != INF &&
                    matriz[i][j] > excentricidad) {

                    excentricidad = matriz[i][j];
                }
            }

            if (excentricidad < minimaExcentricidad) {

                minimaExcentricidad = excentricidad;
                centro = j;
            }
        }

        return "Indice del centro: " + centro;
    }
}