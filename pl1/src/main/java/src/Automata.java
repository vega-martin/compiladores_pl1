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
    private List<List<Integer>> estadoSalto;
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
    
    public void setEstadoSalto(List<List<Integer>> estadoSalto) {
        this.estadoSalto = estadoSalto;
    }
    
    private void inicializarMatriz() {
        for(Integer estado:estados) {
            matriz.put(estado, new HashMap<Character, Integer>());
        }
    }
    
    private void cargarMatriz(){
        //parametro lista de listas con los estados de salto
        int i = 0;
        int j = 0;
        for(Integer estado:estados) {
            for(Character letra:alfabeto) {
                matriz.get(estado).put(letra, estadoSalto.get(i).get(j));
                j++;
            }
            i++;
        }
    }
    
    
}
