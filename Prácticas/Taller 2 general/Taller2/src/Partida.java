
import java.awt.Color;
import static java.awt.Color.blue;
import static java.awt.Color.green;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Partida {
    //atributos de Partida
    //atributo que indica el nivel de dificultad
    private int complejidad;
    //atributo que indica el numero de niveles
    private int nivel;
    //atributo que indica el turno actual
    private int turno=1;
    //atributo que indica la puntuación
    private int puntuacion=0;
    //atributo JPanel para 
    private JPanel panel;
    //area
    private int area=((turno+1)*(turno+1));
    Random dado;
    //atributo posicion boton bueno
    private int botonBueno;
    //booleano que pasa al siguiente nivel
    private boolean next=false;
    
    public Partida(int dato1, int dato2){
    complejidad=dato2;
    nivel=dato1;
    }
    
    
            
    public void jugarPartida(JFrame ventana){
                        
                        
        ActionListener gestorEventos=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evento){
                if(evento.getActionCommand()==nombreBoton(botonBueno)){
                    puntuacion=turno+1;
                    turno++;
                    next=true;
                    }else{
                        JOptionPane panelError=new JOptionPane();
                        panelError.showMessageDialog(null, "Cuadrado incorrecto", "ERROR", 0);
                        turno++;
                        next=true;
                        }
                    
                        
                    
                }
    };
        //inicializacion JPanel
        panel=new JPanel();
        for(;turno<=10;panel.removeAll()){
        //declaracion array de botones
        JButton [] boton=new JButton[area];
            
            //generación de color aleatorio
        int R = (int)(Math.random()*256);
        int G = (int)(Math.random()*256);
        int B= (int)(Math.random()*256);
        //comprobante de que nunca se sale de la paleta
        while((R<15)||(R>241)||(G<15)||(G>241)||(B<15)||(B>241)){
            R = (int)(Math.random()*256);
            G = (int)(Math.random()*256);
            B= (int)(Math.random()*256);
        }
        
        //creación del array de botones + ponerlos en el panel Botones
        for(int i=0;i<(area);i=i+1){
            boton[i]=new JButton();
            boton[i].setName(nombreBoton(i));
            boton[i].setBackground(new Color(R,G,B));
            boton[i].setForeground(new Color(R,G,B));
            panel.add(boton[i]);
            System.out.println("boton "+i+" generado");
        }
        dado=new Random();
        botonBueno=dado.nextInt(area);
        //cambio de color de la posicion correspondiente
        boton[botonBueno].setBackground(new Color(R+(11-complejidad),G+(11-complejidad),B+(11-complejidad)));

        }
        
    }
    public int getTurno(){
    return turno;
}
    public int getPuntuacion(){
    return puntuacion;
}
    public JComponent getPanel(){
        return panel;
    }
    
    public String nombreBoton (int dato){
        String nombre="BOTON "+dato;
        return nombre;
    }
    

    

}

