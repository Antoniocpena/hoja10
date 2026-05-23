import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            grafo grafo = new grafo(20);

            File archivo = new File("guategrafo.txt");
            Scanner leer = new Scanner(archivo);

            while (leer.hasNext()) {

                String origen = leer.next();
                String destino = leer.next();
                int distancia = leer.nextInt();

                grafo.agregarCiudad(origen);
                grafo.agregarCiudad(destino);

                grafo.agregarArco(origen, destino, distancia);
            }

            leer.close();

            grafo.mostrarMatriz();

            Floyd floyd =
                    new Floyd(grafo.getMatriz(),
                            grafo.getCiudades());

            floyd.calcularRutas();

            CentroGrafo centro = new CentroGrafo();

            Scanner teclado = new Scanner(System.in);

            int opcion = 0;

            while (opcion != 5) {

                System.out.println("\nMENU");
                System.out.println("1. Ruta mas corta");
                System.out.println("2. Centro del grafo");
                System.out.println("3. Agregar conexion");
                System.out.println("4. Eliminar conexion");
                System.out.println("5. Salir");

                System.out.print("Opcion: ");
                opcion = teclado.nextInt();

                switch (opcion) {

                    case 1:

                        System.out.print("Ciudad origen: ");
                        String origenRuta = teclado.next();

                        System.out.print("Ciudad destino: ");
                        String destinoRuta = teclado.next();

                        floyd.mostrarRuta(origenRuta, destinoRuta);

                        break;

                    case 2:

                        System.out.println(
                                centro.calcularCentro(
                                        floyd.getDistancias(),
                                        grafo.getCiudades()
                                )
                        );

                        break;

                    case 3:

                        System.out.print("Origen: ");
                        String o = teclado.next();

                        System.out.print("Destino: ");
                        String d = teclado.next();

                        System.out.print("Distancia: ");
                        int km = teclado.nextInt();

                        grafo.agregarArco(o, d, km);

                        floyd = new Floyd(
                                grafo.getMatriz(),
                                grafo.getCiudades()
                        );

                        floyd.calcularRutas();

                        System.out.println("Conexion agregada");

                        break;

                    case 4:

                        System.out.print("Origen: ");
                        String origen = teclado.next();

                        System.out.print("Destino: ");
                        String destino = teclado.next();

                        grafo.eliminarArco(origen, destino);

                        floyd = new Floyd(
                                grafo.getMatriz(),
                                grafo.getCiudades()
                        );

                        floyd.calcularRutas();

                        System.out.println("Conexion eliminada");

                        break;

                    case 5:

                        System.out.println("Programa finalizado");
                        break;

                    default:

                        System.out.println("Opcion invalida");
                }
            }

            teclado.close();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}