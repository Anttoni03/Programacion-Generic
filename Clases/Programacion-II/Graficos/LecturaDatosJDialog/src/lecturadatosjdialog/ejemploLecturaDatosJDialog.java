/*
FUNCIONALIDAD:
EJEMPLO DE ENTRADA DE DATOS A TRAVÉS DE LA CLASE lecturaDatosJDialog

OBJETIVO: introducción programación gráfica

autor: Juan Montes de Oca
 */

package lecturadatosjdialog;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ejemploLecturaDatosJDialog {
    JFrame ventana;
    //declaración método main
    public static void main(String[] args) { 
        new ejemploLecturaDatosJDialog().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    public void metodoPrincipal() {  
        //DECLARACIÓN Y DEFINICIÓN CONTENEDOR JFrame
        ventana = new JFrame("Stroke");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);

        //DECLARACIÓN PANEL JContentPane DEL CONTENEDOR JFrame ventana
        Container panelContenidos=ventana.getContentPane(); 
        panelContenidos.setLayout(new GridLayout(3,1));

        //DECLARACIÓN COMPONENTES JButton
        JButton boton1=new JButton("NOMBRE y DIRECCIÓN");
        //asignación maniuplador de eventos
        boton1.addActionListener(new manipuladorEventos());
        JButton boton2=new JButton("INTRODUCIR UN VALOR ENTERO Y UNO REAL");
        boton2.addActionListener(new manipuladorEventos());
        JButton boton3=new JButton("INTRODUCIR 12 VALORES ENTEROS");
        boton3.addActionListener(new manipuladorEventos());
        
        //introducción contenedor JPanel panel en el panel de contenidos 
        //del contenedor JFrame
        panelContenidos.add(boton1);
        panelContenidos.add(boton2);
        panelContenidos.add(boton3);

        //activar el cierre interactivo del contenedor ventana para finalizar
        //ejecución
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //activar visualización contenedor ventana
        ventana.setVisible(true);
    }

////////MANIPULADOR DE EVENTOS manipuladorEventosGeneral
    private class manipuladorEventos implements ActionListener {
        String [] valores;
        @Override
        public void actionPerformed(ActionEvent evento)  { 
            switch (evento.getActionCommand()) {
                case "NOMBRE y DIRECCIÓN"      :     
                                        String [] literalesIntroduccion1={"NOMBRE","DIRECCIÓN"};
                                        literalesIntroduccion1=new lecturaDatosJDialog(ventana,literalesIntroduccion1).getDatosTexto();
                                        if (literalesIntroduccion1!=null) {
                                            for (int i=0;i<literalesIntroduccion1.length;i++) {
                                                System.out.println(literalesIntroduccion1[i]);      
                                            }
                                                                                  
                                        }

                                        break;
                case "INTRODUCIR UN VALOR ENTERO Y UNO REAL"   :   
                                        String [] literalesIntroduccion2={"INTRODUCE UN VALOR ENTERO",
                                                                          "INTRODUCE UN VALOR REAL"};
                                        literalesIntroduccion2=new lecturaDatosJDialog(ventana,literalesIntroduccion2).getDatosTexto();
                                        if (literalesIntroduccion2!=null) {
                                            System.out.println("VALOR ENTERO INTRODUCIDO:"+Integer.parseInt(literalesIntroduccion2[0]));
                                            System.out.println("VALOR REAL INTRODUCIDO:"+Double.parseDouble(literalesIntroduccion2[1]));                                          
                                        }

                                        break;
                case "INTRODUCIR 12 VALORES ENTEROS"   :       
                                        String [] literalesIntroduccion3=new String[12];
                                        for (int i=0;i<12;i++) { 
                                           literalesIntroduccion3[i]="INTRODUCIR VALOR "+(i+1);
                                        }
                                                                          
                                        literalesIntroduccion3=new lecturaDatosJDialog(ventana,literalesIntroduccion3).getDatosTexto();
                                        if (literalesIntroduccion3!=null) {
                                            for (int indice=0;indice<literalesIntroduccion3.length;indice++) {
                                                System.out.println("VALOR ENTERO INTRODUCIDO "+(indice+1)+":"+
                                                        Integer.parseInt(literalesIntroduccion3[indice]));
                                            }
                                        }
                                        break;

            }        
    }};  
}
