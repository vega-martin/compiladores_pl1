package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Vega
 */
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        // Variables necesarias para el menu
        boolean run = true;
        String eleccion;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Bucle principal del menu
        do {
            System.out.println("***  Comprobador/generador de Expresiones Regulares  ***");
            System.out.println();
            System.out.println("MENU PRINCIPAL");
            System.out.println("Elige la acción a realizar:");
            System.out.println("0 - Salir");
            System.out.println("1 - Comprobar una Expresión Regular.");
            System.out.println("2 - Generar Expresiones Regulares");
            System.out.println();
            
            eleccion = br.readLine();
            
            System.out.println();
            
            switch(eleccion) {
                case "0":
                    System.out.println("Adios!");
                    run = false;
                    break;
                case "1":
                    System.out.println("Vamos a comprobar una ER, elige qué quieres comprobar");
                    break;
                case "2":
                    System.out.println("Vamos a generar ER, introduce la información necesaria para ello");
                    break;
                default:
                    System.out.println("Introduce una elección válida");
                    System.out.println();
                    System.out.println();
            }
            
            
        } while (run);
    }
    
}