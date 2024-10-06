package src;

import java.lang.Exception;
import java.util.HashMap;

/**
 *
 * @author Vega
 */
public class MaquinaDeEstados {
    
    private Integer estadoActual;
    private Automata afd;
    
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
        String cadenasGeneradas[] = new String[cantidad];
        
        // Código para generar cadenas 
        
        // Código para comprobar cadenas necesarias o hasta que no haya más
        
        // Código para formatear cadena final generada
        
        String stringCadenasGeneradas = "hoal";
        
        return stringCadenasGeneradas;
    }
    
    public void intercambiarMatriz(MaquinaDeEstados mde) {
        
        Automata automataTmp;
        automataTmp = mde.getAutomata();
        mde.setAutomata(this.getAutomata());
        this.setAutomata(automataTmp);
    }
    
}
