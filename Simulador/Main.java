import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Cuantas impresiones quiere realizar?");
        int numImp = leer.nextInt();

        // Consumir la nueva línea después de leer el número
        leer.nextLine();
        
        Cola colaC = new Cola();

        for (int i = 1; i <= numImp; i++) {
            System.out.println("DIRECCION DEL ARCHIVO " + i + ":");
            String archivo = leer.nextLine();
            colaC.insertar(archivo);
        }

        // Imprimir los archivos
        System.out.println("\nArchivos a imprimir:");
        int archivoNumero = 1;
        while (archivoNumero <= numImp) {
            String archivo = colaC.quitar();
            if (archivo != null) {
                System.out.println("Archivo " + archivoNumero + ": " + archivo);

                // Abre el cuadro de diálogo de impresión del sistema para el archivo
                abrirOpcionesDeImpresion(archivo);

                archivoNumero++;
            } else {
                System.out.println("La cola está vacía.");
                break;
            }
        }
        
        leer.close();
    }
    
    // Método para abrir el cuadro de diálogo de opciones de impresión del sistema para un archivo
    private static void abrirOpcionesDeImpresion(String filePath) {
        File archivo = new File(filePath);
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.PRINT)) {
            try {
                Desktop.getDesktop().print(archivo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("La impresión no es compatible en este sistema.");
        }
    }
}
