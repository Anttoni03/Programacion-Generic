/*
FUNCIONALIDAD:
1.declaración objeto Estudiante con constructor inicializando sus atributos
2.declaración objeto Estudiante con constructor sin incialización de sus atributos
3. lectura del segundo objeto Estudiante
4. Visualización de os dos objetos Estudiante
 */
package claseteorica_19_11_2021;


public class Estudiante_uso_1 {
    //método main
    public static void main(String [] argumentros) throws Exception {
        new Estudiante_uso_1().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal() {
        //DECLARACIONES
        //1.declaración objeto Estudiante con constructor inicializando sus atributos
        Estudiante estudiante1=new Estudiante("43333333L","Fernando Fernandez",
                            "Ingeniería Informática",1,3);
        //2.declaración objeto Estudiante con constructor sin incialización de sus atributos
        Estudiante estudiante2=new Estudiante();
        
        //ACCIONES
        //3. lectura del segundo objeto Estudiante
        estudiante2.lectura();
        
        //4. Visualización de os dos objetos Estudiante
        System.out.println(estudiante1.toString()+"\n"+estudiante2.toString());
    }
    
}
