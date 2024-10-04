package ui;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.JTextField;
import src.MaquinaDeEstados;

/**
 *
 * @author Vega
 */
public class MenuComprobar extends JFrame implements ActionListener {
    
    private JLabel titulo;
    private JTextField tfCadena;
    private JButton btnER1;
    private JButton btnER2;
    private JLabel resultado;
    private JButton btnVolver;
    private MaquinaDeEstados mde1, mde2;
    
    public MenuComprobar(MaquinaDeEstados mde1, MaquinaDeEstados mde2) {
        super("Compiladores - PL1");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.mde1 = mde1;
        this.mde2 = mde2;
        //this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        initComponents();
    }
    
    private void initComponents() {

        titulo = new JLabel();
        tfCadena = new JTextField();
        btnER1 = new JButton();
        btnER2 = new JButton();
        resultado = new JLabel();
        btnVolver = new JButton();

        titulo.setFont(new Font("Ebrima", 1, 24));
        titulo.setText("¿Qué es lo que quieres comprobar?");
        
        tfCadena.setFont(new java.awt.Font("Ebrima", 0, 14));
        tfCadena.setText("Introduce la cadena");
        
        btnER1.setFont(new Font("Ebrima", 0, 14));
        btnER1.setText("Comprobar que haya al menos 3 as seguidas en la cadena");
        btnER1.setFocusable(false);
        btnER1.addActionListener(this);

        btnER2.setFont(new Font("Ebrima", 0, 14));
        btnER2.setText("Comprobar que la cadena esté compuesta por secuencias 'abc' o 'cba'");
        btnER2.setFocusable(false);
        btnER2.addActionListener(this);

        resultado.setFont(new Font("Ebrima", 0, 18));
        resultado.setForeground(Color.BLUE);
        resultado.setText("RESULTADO");
        
        btnVolver.setFont(new Font("Ebrima", 0, 14));
        btnVolver.setText("Volver");
        btnVolver.setFocusable(false);
        btnVolver.addActionListener(this);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(resultado)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnER2, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .addComponent(btnER1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tfCadena, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(tfCadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnER1)
                .addGap(30, 30, 30)
                .addComponent(btnER2)
                .addGap(49, 49, 49)
                .addComponent(resultado)
                .addGap(51, 51, 51)
                .addComponent(btnVolver)
                .addGap(40, 40, 40))
        );

        pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        Object componente = evento.getSource();
        
        boolean cadenaCorrecta = true;
        
        if(componente == btnER1){
            
            cadenaCorrecta = mde1.compruebaCadena(tfCadena.getText());
            
        } else if(componente == btnER2){
            
            cadenaCorrecta = mde2.compruebaCadena(tfCadena.getText());
            
        } else if(componente == btnVolver) {
            
            this.setVisible(false);
            MenuPrincipal mp = new MenuPrincipal(mde1, mde2);
            
        }
        
        if(cadenaCorrecta) {
            resultado.setForeground(Color.GREEN);
            resultado.setText("CORRECTA");
        } else {
            resultado.setForeground(Color.RED);
            resultado.setText("INCORRECTA");
        }
        
    }
    
}
