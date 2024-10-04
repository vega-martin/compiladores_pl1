package src;

import java.lang.Exception;

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
    
    public String generaCadena(int cantidad, int longitud){
        String cadenasGeneradas[] = new String[cantidad];
        
        for(int i = 0; i <= cantidad; i++){
            // Codigo para generar cadenas
        }
        String stringCadenasGeneradas = "hoal";
        
        return stringCadenasGeneradas;
    }
    
}
