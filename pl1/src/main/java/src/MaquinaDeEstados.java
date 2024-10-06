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
        generarRamas(raiz, cantidad, longitud, combinaciones);
        System.out.println("Cadenas generadas:");
        for(String cadena:combinaciones) {
            System.out.println(cadena);
        }
        
        // Código para formatear cadena final generada
        String stringCadenasGeneradas = "";
        for(String cadena:cadenasGeneradas) {
            stringCadenasGeneradas = stringCadenasGeneradas + cadena + "\n";
        }
        System.out.println(stringCadenasGeneradas);
        return stringCadenasGeneradas.toString();
    }
    
    private void generarRamas(Nodo nodo, int cantidad, int longitud, List<String> combinaciones) {
        
        if(combinaciones.size() >= cantidad) {
            return;
        }
        
        if(nodo.cadena.length() == longitud) {
            if (this.compruebaCadena(nodo.cadena)) {
                combinaciones.add(nodo.cadena);
            }
            return;
        }

        for(char letra:afd.getAlfabeto()) {
            Nodo hijo = new Nodo(nodo.cadena + letra);  // Crear un nuevo nodo hijo
            generarRamas(hijo, cantidad, longitud, combinaciones);  // Llamada recursiva
        }
    }
    
    public void intercambiarMatriz(MaquinaDeEstados mde) {
        
        Automata automataTmp;
        automataTmp = mde.getAutomata();
        mde.setAutomata(this.getAutomata());
        this.setAutomata(automataTmp);
    }
    
}
