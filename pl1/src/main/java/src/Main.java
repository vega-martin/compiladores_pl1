package src;

import java.util.ArrayList;
import ui.MenuPrincipal;
import java.util.List;

/**
 *
 * @author Vega
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Crear alfabeto (comun)
        
        List<Character> alfabeto = new ArrayList<Character>();
        alfabeto.add('a');
        alfabeto.add('b');
        alfabeto.add('c');
        
        
        // Crear AFD 1 - tres as consecutivas
        
        List<Integer> estadosAFD1 = new ArrayList<Integer>();
        estadosAFD1.add(0);
        estadosAFD1.add(1);
        estadosAFD1.add(2);
        estadosAFD1.add(3);
        
        Integer estadoInicial1 = 0;
        
        List<Integer> estadosFinalesAFD1 = new ArrayList<Integer>();
        estadosFinalesAFD1.add(3);
        
        List<Integer> afd1e1 = new ArrayList<>();
        afd1e1.add(1);
        afd1e1.add(0);
        afd1e1.add(0);
        List<Integer> afd1e2 = new ArrayList<>();
        afd1e2.add(2);
        afd1e2.add(0);
        afd1e2.add(0);
        List<Integer> afd1e3 = new ArrayList<>();
        afd1e3.add(3);
        afd1e3.add(0);
        afd1e3.add(0);
        List<Integer> afd1e4 = new ArrayList<>();
        afd1e4.add(3);
        afd1e4.add(3);
        afd1e4.add(3);
        List<List<Integer>> estadoSaltoAFD1 = new ArrayList<>();
        estadoSaltoAFD1.add(afd1e1);
        estadoSaltoAFD1.add(afd1e2);
        estadoSaltoAFD1.add(afd1e3);
        estadoSaltoAFD1.add(afd1e4);
        
        Automata afd1 = new Automata(alfabeto, estadosAFD1, estadoInicial1, estadosFinalesAFD1, estadoSaltoAFD1);
        MaquinaDeEstados mde1 = new MaquinaDeEstados(afd1);
        
        
        // Crear AFD 2 - 'abc' o 'cba'
        
        List<Integer> estadosAFD2 = new ArrayList<Integer>();
        estadosAFD2.add(0);
        estadosAFD2.add(1);
        estadosAFD2.add(2);
        estadosAFD2.add(3);
        estadosAFD2.add(4);
        
        Integer estadoInicial2 = 4;
        
        List<Integer> estadosFinalesAFD2 = new ArrayList<Integer>();
        estadosFinalesAFD2.add(4);
        
        List<Integer> afd2e1 = new ArrayList<>();
        afd2e1.add(-1);
        afd2e1.add(1);
        afd2e1.add(-1);
        List<Integer> afd2e2 = new ArrayList<>();
        afd2e2.add(-1);
        afd2e2.add(-1);
        afd2e2.add(4);
        List<Integer> afd2e3 = new ArrayList<>();
        afd2e3.add(-1);
        afd2e3.add(3);
        afd2e3.add(-1);
        List<Integer> afd2e4 = new ArrayList<>();
        afd2e4.add(4);
        afd2e4.add(-1);
        afd2e4.add(-1);
        List<Integer> afd2e5 = new ArrayList<>();
        afd2e5.add(0);
        afd2e5.add(-1);
        afd2e5.add(2);
        List<List<Integer>> estadoSaltoAFD2 = new ArrayList<>();
        estadoSaltoAFD2.add(afd2e1);
        estadoSaltoAFD2.add(afd2e2);
        estadoSaltoAFD2.add(afd2e3);
        estadoSaltoAFD2.add(afd2e4);
        estadoSaltoAFD2.add(afd2e5);
        
        Automata afd2 = new Automata(alfabeto, estadosAFD2, estadoInicial2, estadosFinalesAFD2, estadoSaltoAFD2);
        MaquinaDeEstados mde2 = new MaquinaDeEstados(afd2);
        
        
        // Inicializar interfaz
        MenuPrincipal mp = new MenuPrincipal(mde1, mde2);
        
    }
    
}