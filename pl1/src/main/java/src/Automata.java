package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Vega
 */
public class Automata {
    
    private List<Character> alfabeto;
    private List<Integer> estados;
    private Integer estadoInicial;
    private List<Integer> estadosFinales;
    private List<List<Integer>> estadoSalto;
    private HashMap<Integer, HashMap<Character, Integer>> matriz;
    
    public Automata(List alfabeto, List estados, Integer estadoInicial,
            List estadosFinales, List<List<Integer>> estadoSalto){
        
        inicializarAtributos();
        cargarAtributos(alfabeto, estados, estadoInicial, estadosFinales, estadoSalto);
        cargarMatriz();
    }

    public void setAlfabeto(List<Character> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public void setEstados(List estados) {
        this.estados = estados;
    }

    public void setEstadoInicial(Integer estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public void setEstadosFinales(List estadosFinales) {
        this.estadosFinales = estadosFinales;
    }
    
    public void setEstadoSalto(List<List<Integer>> estadoSalto) {
        this.estadoSalto = estadoSalto;
    }
    
    public Integer getSiguienteEstado(Integer estadoActual, Character letra) {
        return matriz.get(estadoActual).get(letra);
    }
    
    public Integer getEstadoInicial() {
        return this.estadoInicial;
    }
    
    public boolean esFinal(Integer estado) {
        return estadosFinales.contains(estado);
    }
    
    private void inicializarAtributos() {
        alfabeto = new ArrayList<Character>();
        estados = new ArrayList<Integer>();
        estadosFinales = new ArrayList<Integer>();
        estadoSalto = new ArrayList<>();
        for(Integer estado:estados) {
            matriz.put(estado, new HashMap<Character, Integer>());
        }
    }
    
    private void cargarAtributos(List alfabeto, List estados, Integer estadoInicial,
            List estadosFinales, List<List<Integer>> estadoSalto) {
        
        setAlfabeto(alfabeto);
        setEstados(estados);
        setEstadoInicial(estadoInicial);
        setEstadosFinales(estadosFinales);
        setEstadoSalto(estadoSalto);
    }
    
    private void cargarMatriz() {
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
