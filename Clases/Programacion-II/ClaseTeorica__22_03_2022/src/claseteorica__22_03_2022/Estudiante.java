/*
CLASE Estudiante
 */
package claseteorica__22_03_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Estudiante implements java.io.Serializable {
    //DECLARACIÓN DE ATRIBUTOS
    private int nif;
    private String nombre;
    private String estudios;
    private int grupo;
    private String asignatura;
    
    //declaración objeto CENTINELA
    private static final Estudiante CENTINELA=new Estudiante(Integer.MAX_VALUE,"","",0,""); 
    
    //MÉTODOS CONSTRUCTORES
    
    public Estudiante() {}
    
    public Estudiante(int dato1, String dato2, String dato3,
                   int dato4, String dato5) {
        nif=dato1;
        nombre=dato2;
        estudios=dato3;
        grupo=dato4;
        asignatura=dato5;
    }
    
    //MÉTODOS GET's
    public int getNif() {
        return nif;
    }
    
    public String getNombre() {
        return nombre;
    }    
    
    public String getEstudios() {
        return estudios;
    }
    
    public int getGrupo() {
        return grupo;
    }
    
    public String getAsignatura() {
        return asignatura;
    }
    
    //MÉTODOS SET's
    public void setNif(int dato) {
        nif=dato;
    }
    
    public void setNombre(String dato) {
        nombre=dato;
    }    
    
    public void setEstudios(String dato) {
        estudios=dato;
    }
    
    public void setGrupo(int dato) {
        grupo=dato;
    }
    
    public void setAsignatura(String dato) {
        asignatura=dato;
    }
    
    //método letura que lleva a cabo la lectura de un objeto Estudiante
    //desde el teclado
    public void lectura() {
        //DECLARACIONES
        //instanciación objeto BufferedReader para enlazar el teclado posibilitando
        //la lectura a través de dicho objeto desde el teclado
        BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
        
        //ACCIONES
        try {
            //mensaje usuario para introducir objeto Estudiante
            System.out.println("INTRODUCCIÓN DATOS NUEVO ESTUDIANTE");
            //Mensajes y lecturas de los diferentes atributos del nuevo estudiante
            System.out.print("NIF: ");
            nif=Integer.parseInt(teclado.readLine());       
            System.out.print("NOMBRE: ");
            nombre=teclado.readLine();
            System.out.print("ESTUDIOS: ");
            estudios=teclado.readLine();
            System.out.print("GRUPO [G01->1/G02->2/G03->3]: ");
            grupo=Integer.parseInt(teclado.readLine());
            System.out.print("ASIGNATURA: ");
            asignatura=teclado.readLine();           
        }catch (IOException error) {
            System.out.println("ERROR LECTURA DE DATOS");
        }
    }
    
    //método toString
    @Override
    public String toString() {
        return "NIF: "+nif+" - NOMBRE: "+nombre+" - ESTUDIOS: "+estudios+"\n"+
               "GRUPO: G0"+grupo+"  - ASIGNATURA: "+asignatura;
    }
    
    //método esCentinela
    public boolean esCentinela() {
        return nif==CENTINELA.nif;
    }
    
    //método getCentinela
    public static Estudiante getCentinela() {
        return CENTINELA;
    }
    
    public static int menor(Estudiante [] datos) {
        int nifMenor=datos[0].nif;
        int menor=0;
        for (int indice=1;indice<datos.length-1;indice++) {
            if (datos[indice].nif<nifMenor) {
                menor=indice;
            }
        }
        return menor;
    }
}
