/*
MODALIDADES PARA OBTENER Y VISUALIZAR LA FECHA Y HORA ACTUALES
 */
package clasepractica___14_12_2021;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class fechaHora {
    //método main
    public static void main(String [] argumentos) throws Exception {
        new fechaHora().metodoPrincipal();
    }
    
    //método metodoPrincipal
    private void metodoPrincipal()
    {
        //MODALIDAD 1
        DateTimeFormatter datos1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(datos1.format(LocalDateTime.now()));
        DateTimeFormatter datos2 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
        System.out.println(datos2.format(LocalDateTime.now()));
        DateTimeFormatter datos3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println(datos3.format(LocalDateTime.now()));
        
        //MODALIDAD 2
        String datos4=new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
        System.out.println(datos4);
    }
    
}
