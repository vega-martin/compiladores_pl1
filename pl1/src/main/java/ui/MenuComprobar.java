package ui;

import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout;

/**
 *
 * @author Vega
 */
public class MenuComprobar extends JFrame implements ActionListener {
    
    private JLabel titulo;
    private JButton btnER1;
    private JButton btnER2;
    private JButton btnVolver;
    
    public MenuComprobar() {
        super("Compiladores - PL1");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        initComponents();
    }
    
    private void initComponents() {

        titulo = new JLabel();
        btnER1 = new JButton();
        btnER2 = new JButton();
        btnVolver = new JButton();

        titulo.setFont(new Font("Ebrima", 1, 24));
        titulo.setText("¿Qué es lo que quieres comprobar?");
        
        btnER1.setFont(new Font("Ebrima", 0, 14));
        btnER1.setText("Comprobar que haya al menos 3 as seguidas en la cadena");
        btnER1.setFocusable(false);
        btnER1.addActionListener(this);

        btnER2.setFont(new Font("Ebrima", 0, 14));
        btnER2.setText("Comprobar que la cadena esté compuesta por secuencias 'abc' o 'cba'");
        btnER2.setFocusable(false);
        btnER2.addActionListener(this);

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
                        .addComponent(titulo)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnER2, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .addComponent(btnER1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(titulo)
                .addGap(98, 98, 98)
                .addComponent(btnER1)
                .addGap(26, 26, 26)
                .addComponent(btnER2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(63, 63, 63))
        );

        pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        Object componente = evento.getSource();
        
        if(componente == btnER1){
            
            this.setVisible(false);        
            // Menu comprobar
            
        } else if(componente == btnER2){
            
            this.setVisible(false);
            // Menu generar
            
        } else if(componente == btnVolver) {
            
            this.setVisible(false);
            MenuPrincipal mp = new MenuPrincipal();
            
        }
    }
    
}
