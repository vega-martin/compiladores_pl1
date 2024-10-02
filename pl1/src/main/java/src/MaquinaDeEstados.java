package src;

import java.lang.Exception;

/**
 *
 * @author Vega
 */
public class MaquinaDeEstados {
    
    private Integer estadoActual;
    private Automata afd;
    
    public void inicializar() {
        estadoActual = afd.getEstadoInicial();
    }
    
    public void aceptaCaracter(Character letra) {
        Integer estadoTmp = afd.getSiguienteEstado(estadoActual, letra);
        if(estadoTmp == null) {
            //throw Exception;
        }
    }
    
    public boolean isFinal() {
        return afd.esFinal(estadoActual);
    }
    
    public boolean compruebaCadena(String cadena) {
        for(int i = 0; i < cadena.length(); i++) {
            try {
                this.aceptaCaracter(cadena.charAt(i));
                if((this.isFinal()) && ((i-cadena.length()) <= 1)) {
                    return true;
                }
            } catch(Exception e) {
            
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
