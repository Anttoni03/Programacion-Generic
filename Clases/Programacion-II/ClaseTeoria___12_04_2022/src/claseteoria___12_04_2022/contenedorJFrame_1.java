/*
CREACIÓN DE UNA VENTANA A TRAVÉS DE UN CONTENEDOR JFrame
 */
package claseteoria___12_04_2022;

import javax.swing.JFrame;

public class contenedorJFrame_1 {
    //declaración método main
    public static void main(String[] args) { 
        new contenedorJFrame_1().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    private void metodoPrincipal() {    
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("MI PRIMERA VENTANA");
        
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
//        ventana.setVisible(true);
    }
}
