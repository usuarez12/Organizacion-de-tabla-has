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

     public static int[] leerArchivo(String nombre) throws IOException {

        List<Integer> lista = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(nombre));
        String linea;

        while ((linea = br.readLine()) != null) {
            linea = linea.trim();
            if (linea.isEmpty()) continue;

            String[] partes = linea.split("\\s+");

            for (String p : partes) {
                lista.add(Integer.parseInt(p));
            }
        }

        br.close();

        int[] arr = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++)
            arr[i] = lista.get(i);

        return arr;
    }

    public static void escribirTabla(String archivo, List<List<Integer>> tabla) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

        for (int i = 0; i < tabla.size(); i++) {
            bw.write(i + ": ");   
            for (int num : tabla.get(i)) {
                bw.write(num + " ");
            }

            bw.newLine();
        }

        bw.close();
    }
    
    public static void escribirTexto(String archivo, String texto) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        bw.write(texto);
        bw.newLine();
        bw.close();
    }
}
