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

            grafo.mostrarMatriz();

            Scanner teclado = new Scanner(System.in);

            int opcion = 0;

            while (opcion != 5) {

                System.out.println("\nMENU");
                System.out.println("1. Ruta mas corta");
                System.out.println("2. Centro del grafo");
                System.out.println("3. Agregar conexion");
                System.out.println("4. Eliminar conexion");
                System.out.println("5. Salir");

                opcion = teclado.nextInt();

                switch (opcion) {

                    case 1:

                        // Daniel
                        System.out.println("Funcion pendiente");

                        break;

                    case 2:

                        // Daniel 
                        System.out.println("Funcion pendiente");

                        break;

                    case 3:

                        System.out.print("Origen: ");
                        String o = teclado.next();

                        System.out.print("Destino: ");
                        String d = teclado.next();

                        System.out.print("Distancia: ");
                        int km = teclado.nextInt();

                        grafo.agregarArco(o, d, km);

                        break;

                    case 4:

                        System.out.print("Origen: ");
                        String origen = teclado.next();

                        System.out.print("Destino: ");
                        String destino = teclado.next();

                        grafo.eliminarArco(origen, destino);

                        break;

                    case 5:

                        System.out.println("Programa finalizado");
                        break;
                }
            }

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}