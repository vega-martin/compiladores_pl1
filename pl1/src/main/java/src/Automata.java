package src;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Vega
 */
public class Automata {
    
    private List<Character> alfabeto;
    private List<Integer> estados;
    private int estadoIncicial;
    private List<Integer> estadosFinales;
    private HashMap<Integer, HashMap<Character, Integer>> matriz;
    
    public void Automata(){
        /*
        setAlfabeto();
        setEstados();
        setEstadoInicial();
        setEstadosFinales();
        */
    }

    public void setAlfabeto(List<Character> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public void setEstados(List estados) {
        this.estados = estados;
    }

    public void setEstadoIncicial(int estadoIncicial) {
        this.estadoIncicial = estadoIncicial;
    }

    public void setEstadosFinales(List estadosFinales) {
        this.estadosFinales = estadosFinales;
    }
    
    private void inicializarMatriz() {
        for(Integer estado:estados) {
            matriz.put(estado, new HashMap<Character, Integer>());
        }
    }
    
    private void cargarMatriz(){}
    
    
}
