import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TablaHash {

    public static void main(String[] args) {


        String archivoEntrada = "hash_entrada.txt";
        String archivoSalida = "hash_salida.txt";

        try {

            int[] datos = leerArchivo(archivoEntrada);

            if (datos.length == 0) {
                escribirTexto(archivoSalida, "El archivo está vacío.");
                return;
            }

 
            int tamañoTabla = 5;

   
            List<List<Integer>> tabla = crearTabla(tamañoTabla);

   
            for (int num : datos) {
                int hash = num % tamañoTabla;
                tabla.get(hash).add(num);
            }

            escribirTabla(archivoSalida, tabla);

            System.out.println("Tabla hash creada. Revisa: " + archivoSalida);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



    public static List<List<Integer>> crearTabla(int tamaño) {
        List<List<Integer>> tabla = new ArrayList<>();
        for (int i = 0; i < tamaño; i++) {
            tabla.add(new ArrayList<>());
        }
        return tabla;
    }
}
