/*
FUNCIONALIDAD:
ILUSTRACIÓN UTILIZACIÓN FocusListener PARA TRATAMIENTO EVENTO FocusEvent

autor: Juan Montes de Oca
 */
package programaciongrafica__eventos;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
public class eventos_FocusListener_v3 extends JFrame implements FocusListener{
    JPanel panel = new JPanel();
    FlowLayout flujo = new FlowLayout(FlowLayout.LEFT);
    JLabel nombre = new JLabel("Nombre:", JLabel.LEFT);
    JTextField campo = new JTextField(20);
    JLabel mensaje = new JLabel("                                         ");
    JPanel panel2 = new JPanel();
    JLabel apellido = new JLabel("Apellido:", JLabel.LEFT);
    JTextField campo2 = new JTextField(20);
    JLabel mensaje2 = new JLabel("                                         ");
    public eventos_FocusListener_v3(){
        super("EJemplo de FocusListener");
        setSize(470,140);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        panel.setLayout(flujo);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
        panel.add(nombre);
        campo.addFocusListener(this);
        panel.add(campo);
        panel.add(mensaje);
       
        panel2.setLayout(flujo);
        panel2.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        panel2.add(apellido);
        campo2.addFocusListener(this);
        panel2.add(campo2);
        panel2.add(mensaje2);
       
        GridLayout grilla = new GridLayout(2,1);
        setLayout(grilla);
        add(panel);add(panel2);
        //pack();
        setVisible(true);
    }
    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource() == campo){
            mensaje.setText("<--Escribe tu monbre.");
        }
        if(e.getSource() == campo2){
            mensaje2.setText("<--Escribe tu Apellido.");
        }
       
    }
    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource() == campo){
            mensaje.setText("                                         ");
        }
        if(e.getSource() == campo2){
            mensaje2.setText("                                         ");
        }
       
    }
    public static void main(String[] dario){
        new eventos_FocusListener_v3();
    }
}
