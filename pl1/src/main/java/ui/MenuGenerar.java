package ui;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import src.MaquinaDeEstados;

/**
 *
 * @author Vega
 */
public class MenuGenerar extends JFrame implements ActionListener {
    
    private JLabel titulo;
    private JScrollPane spCadenasGeneradas;
    private JTextArea taCadenasGeneradas;
    private JLabel lbNumero;
    private JLabel lbLongitud;
    private JLabel lbElegir;
    private JTextField tfNumero;
    private JTextField tfLongitud;
    private JToggleButton tgBtnER1;
    private JToggleButton tgBtnER2;
    private JButton btnVolver;
    private JButton btnGenerar;
    private boolean isER1seleccionado = true;
    private boolean isERseleccionado = false;
    private MaquinaDeEstados mde1, mde2;
    
    
    public MenuGenerar(MaquinaDeEstados mde1, MaquinaDeEstados mde2) {
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
        spCadenasGeneradas = new JScrollPane();
        taCadenasGeneradas = new JTextArea();
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

        taCadenasGeneradas.setFont(new Font("Ebrima", 0, 14));
        taCadenasGeneradas.setEditable(false);
        taCadenasGeneradas.setColumns(20);
        taCadenasGeneradas.setRows(5);
        spCadenasGeneradas.setViewportView(taCadenasGeneradas);
        
        lbNumero.setFont(new Font("Ebrima", 0, 14));
        lbNumero.setText("Nº máximo de cadenas a generar: ");

        lbLongitud.setFont(new Font("Ebrima", 0, 14));
        lbLongitud.setText("Longitud de las cadenas a generar: ");

        lbElegir.setFont(new Font("Ebrima", 0, 14));
        lbElegir.setText("Elige la Expresión Regular que quieras usar para generar las cadenas: ");
        
        tfNumero.setFont(new Font("Ebrima", 0, 14));
        tfNumero.setPreferredSize(new Dimension(50, 20));
        tfNumero.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                tfNumeroKeyTyped(evt);
            }
        });

        tfLongitud.setFont(new Font("Ebrima", 0, 14));
        tfLongitud.setPreferredSize(new Dimension(50, 20));
        tfLongitud.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                tfLongitudKeyTyped(evt);
            }
        });
        
        tgBtnER1.setFont(new Font("Ebrima", 0, 14));
        tgBtnER1.setText("Que haya al menos 3 as seguidas en la cadena");
        tgBtnER1.setFocusable(false);
        tgBtnER1.addActionListener(this);

        tgBtnER2.setFont(new Font("Ebrima", 0, 14));
        tgBtnER2.setText("Que la cadena esté compuesta por secuencias 'abc' o 'cba'");
        tgBtnER2.setFocusable(false);
        tgBtnER2.addActionListener(this);
        
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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfLongitud, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(225,225,225)
                                .addComponent(spCadenasGeneradas, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(titulo)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbNumero)
                        .addGap(12, 12, 12)
                        .addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbLongitud)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfLongitud, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(spCadenasGeneradas))
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
    
    private void tfLongitudKeyTyped(KeyEvent evt) {
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }
    
    private void tfNumeroKeyTyped(KeyEvent evt) {
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        Object componente = evento.getSource();
        
        if(componente == tgBtnER1) {
            tgBtnER2.setSelected(false);
            isER1seleccionado = true;
        } else if (componente == tgBtnER2) {
            tgBtnER1.setSelected(false);
            isER1seleccionado = false;
        }
        
        isERseleccionado = (tgBtnER1.isSelected() || tgBtnER2.isSelected());
        
        if(componente == btnVolver) {
            
            this.setVisible(false);        
            MenuPrincipal mp = new MenuPrincipal(mde1, mde2);
            
        } else if(componente == btnGenerar) {
            if(isERseleccionado && (tfLongitud.getText() != "") && (tfNumero.getText() != "")){
                int cantidad = Integer.parseInt(tfNumero.getText());
                int longitud = Integer.parseInt(tfLongitud.getText());
                String cadenas = "hola";

                if(isER1seleccionado) {
                    // Llamar cadenas = AFD1.generar(cantidad, longitud);
                } else {
                    // Llamar cadenas = AFD2.generar(cantidad, longitud)
                }

                taCadenasGeneradas.setText(cadenas);
            } else {
                JOptionPane.showMessageDialog(this,
                "Rellene todos los campos y selecciona una ER antes de realizar esta operación.",
                "CUIDADO",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
