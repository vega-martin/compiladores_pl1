package ui;

import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;

/**
 *
 * @author Vega
 */
public class MenuGenerar extends JFrame implements ActionListener {
    
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbLongitud;
    private javax.swing.JLabel lbElegir;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfLongitud;
    private javax.swing.JToggleButton tgBtnER1;
    private javax.swing.JToggleButton tgBtnER2;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnGenerar;
    
    
    public MenuGenerar() {
        super("Compiladores - PL1");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        initComponents();
    }
    
    private void initComponents() {
        
        titulo = new JLabel();
        lbNumero = new JLabel();
        lbLongitud = new JLabel();
        lbElegir = new JLabel();
        tfNumero = new JTextField();
        tfLongitud = new JTextField();
        tgBtnER1 = new JToggleButton();
        tgBtnER2 = new JToggleButton();
        btnVolver = new JButton();
        btnGenerar = new JButton();

        titulo.setFont(new Font("Ebrima", 1, 24));
        titulo.setText("¿Cómo son las cadenas que quieres generar?");

        lbNumero.setFont(new Font("Ebrima", 0, 14));
        lbNumero.setText("Nº de cadenas a generar: ");

        lbLongitud.setFont(new Font("Ebrima", 0, 14));
        lbLongitud.setText("Longitud de las cadenas a generar: ");

        lbElegir.setFont(new Font("Ebrima", 0, 14));
        lbElegir.setText("Elige la Expresión Regular que quieras usar para generar las cadenas: ");

        tfNumero.setFont(new Font("Ebrima", 0, 14));
        tfNumero.setText("jTextField1");

        tfLongitud.setFont(new Font("Ebrima", 0, 14));
        tfLongitud.setText("jTextField1");
        
        tgBtnER1.setFont(new Font("Ebrima", 0, 14));
        tgBtnER1.setText("Que haya al menos 3 as seguidas en la cadena");
        tgBtnER1.setFocusable(false);

        tgBtnER2.setFont(new Font("Ebrima", 0, 14));
        tgBtnER2.setText("Que la cadena esté compuesta por secuencias 'abc' o 'cba'");
        tgBtnER2.setFocusable(false);

        btnVolver.setFont(new Font("Ebrima", 0, 14));
        btnVolver.setText("Volver");
        btnVolver.setFocusable(false);
        btnVolver.addActionListener(this);
        
        btnGenerar.setFont(new Font("Ebrima", 0, 14));
        btnGenerar.setText("Generar cadenas");
        btnGenerar.setFocusable(false);
        btnGenerar.addActionListener(this);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerar, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lbElegir)
                            .addComponent(lbLongitud)
                            .addComponent(lbNumero)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tgBtnER1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tgBtnER2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfLongitud, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(titulo)
                .addGap(22, 22, 22)
                .addComponent(lbNumero)
                .addGap(12, 12, 12)
                .addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbLongitud)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfLongitud, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(lbElegir)
                .addGap(18, 18, 18)
                .addComponent(tgBtnER1)
                .addGap(18, 18, 18)
                .addComponent(tgBtnER2)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnGenerar))
                .addGap(30, 30, 30))
        );

        pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        Object componente = evento.getSource();
        
        if(componente == btnVolver){
            
            this.setVisible(false);        
            MenuPrincipal mp = new MenuPrincipal();
            
        } else if(componente == btnGenerar){
            
            this.setVisible(false);
            // Menu generar
            
        }
    }
    
}
