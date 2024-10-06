package src;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vega
 */
public class MaquinaDeEstados {
    
    private Integer estadoActual;
    private Automata afd;
    
    private class Nodo {
        String cadena;
        Nodo(String cd) {
            this.cadena = cd;
        }
    }
    
    
    public MaquinaDeEstados(Automata afd) {
        this.afd = afd;
        inicializar();
    }
    
    public void setAutomata(Automata automata) {
        this.afd = automata;
    }
    
    public Automata getAutomata() {
        return this.afd;
    }
    
    private void inicializar() {
        estadoActual = afd.getEstadoInicial();
    }
    
    private Integer aceptaCaracter(Character letra) {
        Integer estadoTmp = afd.getSiguienteEstado(estadoActual, letra);
        if(estadoTmp == -1) {
            return estadoTmp;
        }
        estadoActual = estadoTmp;
        return estadoActual;
    }
    
    private boolean isFinal() {
        return afd.esFinal(estadoActual);
    }
    
    public boolean compruebaCadena(String cadena) {
        this.inicializar();
        Integer estadoDevuelto;
        for(int i = 0; i < cadena.length(); i++) {
            
            estadoDevuelto = this.aceptaCaracter(cadena.charAt(i));
            if(estadoDevuelto == -1) {
                return false;
            }
            
            if(this.isFinal() && ((cadena.length()-i) == 1)) {
                return true;
            }
            
        }
        return false;
    }
    
    public String generaCadenas(int cantidad, int longitud){
        List<String> cadenasGeneradas = new ArrayList<>();
        
        // Código para generar cadenas
        Nodo raiz = new Nodo("");
        List<String> combinaciones = new ArrayList<>();
        generarRamas(raiz, longitud, combinaciones);
        
        // Código para comprobar cadenas necesarias o hasta que no haya más
        int cadenasComprobadas = 0;
        boolean hayMasCombinaciones = true;
        boolean esValido = false;
        int i = 0;
        String cadenaComprobar = "";
        while((cantidad - cadenasComprobadas != 0) || !hayMasCombinaciones) {
            esValido = false;
            if(combinaciones.get(i+1) != null) {
                cadenaComprobar = combinaciones.get(i);
                esValido = this.compruebaCadena(cadenaComprobar);
                if(esValido) {
                    cadenasGeneradas.add(cadenaComprobar);
                }
                cadenasComprobadas++;
            } else {
                hayMasCombinaciones = false;
            }
        }
        
        // Código para formatear cadena final generada
        String stringCadenasGeneradas = "";
        for(String cadena:cadenasGeneradas) {
            stringCadenasGeneradas.concat(cadena);
            stringCadenasGeneradas.concat("\n");
        }
        
        return stringCadenasGeneradas;
    }
    
    private void generarRamas(Nodo nodo, int longitud, List<String> combinaciones) {
        // Si alcanzamos la longitud deseada, agregamos la cadena a la lista de combinaciones
        if (nodo.cadena.length() == longitud) {
            combinaciones.add(nodo.cadena);
            return;
        }

        // Generar los hijos (agregar 'a', 'b' o 'c' a la cadena)
        for (char letra:afd.getAlfabeto()) {
            Nodo hijo = new Nodo(nodo.cadena + letra);  // Crear un nuevo nodo hijo
            generarRamas(hijo, longitud, combinaciones);  // Llamada recursiva
        }
    }
    
    public void intercambiarMatriz(MaquinaDeEstados mde) {
        
        Automata automataTmp;
        automataTmp = mde.getAutomata();
        mde.setAutomata(this.getAutomata());
        this.setAutomata(automataTmp);
    }
    
}
