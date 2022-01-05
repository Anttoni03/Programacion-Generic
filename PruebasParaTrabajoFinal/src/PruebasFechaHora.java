/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PruebasFechaHora {
    public static void main(String[] args) throws Exception
    {
        new PruebasFechaHora().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        System.out.println(LocalDateTime.now());
        
        //MODALIDAD 1
        DateTimeFormatter datos1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(datos1.format(LocalDateTime.now()));
        DateTimeFormatter datos2 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
        System.out.println(datos2.format(LocalDateTime.now()));
        DateTimeFormatter datos3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println(datos3.format(LocalDateTime.now()));
        
        //MODALIDAD 2
        String datos4=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(datos4);
    }
}
