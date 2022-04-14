/*
IDEM CLASE contenedorJFrame_1.java Y ADEMÁS:
    - REDIMENSIONADO EL CONTENEDOR JFrame CON setSize(dimX,dimY).
    - ACTIVACIÓN CIERRE VENTANA WINDOWS EN EL CONTENEDOR JFrame A TRAVÉS
    DE setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 */
package claseteoria___12_04_2022;

import javax.swing.JFrame;

public class contenedorJFrame_2 {
    //declaración método main
    public static void main(String[] args) { 
        new contenedorJFrame_2().metodoPrincipal();
    }
    
    //declaración método metodoPrncipal
    private void metodoPrincipal() {    
        //CREACION DEL CONTENEDOR JFrame ventana
        JFrame ventana = new JFrame("MI PRIMERA VENTANA");
        
        //REDIMENSIONAMIENTO DEL CONTENEDOR JFrame ventana
        ventana.setSize(1000,300);

        //ACTIVACIÓN DEL CIERRE INTERACTIVO VENTANA EN EL CONTENEDOR JFrame ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        ventana.setLocationRelativeTo(null);
        
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        ventana.setVisible(true);
    }
}
