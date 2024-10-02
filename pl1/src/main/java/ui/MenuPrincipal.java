package ui;

import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author Vega
 */
public class MenuPrincipal extends JFrame implements ActionListener {
    
    private JLabel subtitulo;
    private JLabel titulo;
    private JButton btnComprobar;
    private JButton btnGenerar;
    private JButton btnIntercambiar;
    
    public MenuPrincipal() {
        super("Compiladores - PL1");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        initComponents();
    }
    
    private void initComponents() {

        titulo = new JLabel();
        subtitulo = new JLabel();
        btnComprobar = new JButton();
        btnGenerar = new JButton();
        btnIntercambiar = new JButton();
        
        titulo.setFont(new Font("Ebrima", 1, 24));
        titulo.setText("PRÁCTICA 1 - EXPRESIONES REGULARES");

        subtitulo.setFont(new Font("Ebrima", 0, 18));
        subtitulo.setText("¿Qué acción quieres realizar?");
        
        btnComprobar.setFont(new Font("Ebrima", 0, 14));
        btnComprobar.setText("Comprobar una cadena");
        btnComprobar.setFocusable(false);
        btnComprobar.addActionListener(this);

        btnGenerar.setFont(new Font("Ebrima", 0, 14));
        btnGenerar.setText("Generar cadenas");
        btnGenerar.setFocusable(false);
        btnGenerar.addActionListener(this);

        btnIntercambiar.setFont(new Font("Ebrima", 0, 14));
        btnIntercambiar.setText("Intercambiar matrices de estados");
        btnIntercambiar.setFocusable(false);
        btnIntercambiar.addActionListener(this);

        GroupLayout layout = new GroupLayout(getContentPane());
        
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btnIntercambiar, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnComprobar, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGenerar, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(subtitulo)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(titulo)
                .addGap(42, 42, 42)
                .addComponent(subtitulo)
                .addGap(58, 58, 58)
                .addComponent(btnComprobar)
                .addGap(26, 26, 26)
                .addComponent(btnGenerar)
                .addGap(26, 26, 26)
                .addComponent(btnIntercambiar)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        Object componente = evento.getSource();
        
        if(componente == btnComprobar) {
            
            this.setVisible(false);        
            MenuComprobar mc = new MenuComprobar();
            
        } else if(componente == btnGenerar) {
            
            this.setVisible(false);
            MenuGenerar mg = new MenuGenerar();
            
        } else if(componente == btnIntercambiar) {
            
            // Llamar a intercambiar matrices
            
            JOptionPane.showMessageDialog(this,
                "Las matrices de estado se han intercambiado correctamente.\nTenga cuidado a la hora de seleccionar las ERs a partir de ahora.",
                "CUIDADO",JOptionPane.WARNING_MESSAGE);
            
        }
    }
    
}
