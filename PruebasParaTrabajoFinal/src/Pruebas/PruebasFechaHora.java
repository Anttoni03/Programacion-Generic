package Pruebas;


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
        char[] numero = separarNumero(-91080);
        for (int i = 0; i < numero.length; i++) {
            System.out.println(numero[i]);
        }
        //MODALIDAD 1
        //DateTimeFormatter datos1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //System.out.println(datos1.format(LocalDateTime.now()));
        //DateTimeFormatter datos2 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
        //System.out.println(datos2.format(LocalDateTime.now()));
        //DateTimeFormatter datos3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        //System.out.println(datos3.format(LocalDateTime.now()));
        
        //MODALIDAD 2
        //String datos4=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        //System.out.println(datos4);
    }
    
    private char[] separarNumero(int num)
    {
        char[] digitos = new char[12];
        int aux = Math.abs(num), aux2;
        int contador = 0;
        boolean negativo = num < 0;
        boolean primerNoCero = false;
        for (int i = digitos.length-1; i >=0; i--) {
            aux2 = aux/(int)Math.pow(10, i);
            aux -= aux2 * Math.pow(10, i);
            digitos[digitos.length-1-i] = (char)(aux2+(int)'0');
            if (!primerNoCero && digitos[digitos.length-1-i] != '0')
            {
                primerNoCero = true;
            }
            if (primerNoCero)
            {
                contador++;
            }
        }
        char[] digitosFinal;
        if (!negativo)
        {
            digitosFinal = new char[contador];
            for (int i = digitos.length-contador, j = 0; i < digitos.length; i++,j++) {
                digitosFinal[j] = digitos[i];
            }
        }
        else
        {
            digitosFinal = new char[contador+1];
            digitosFinal[0] = '-';
            for (int i = digitos.length-contador , j = 1; i < digitos.length; i++,j++) {
                digitosFinal[j] = digitos[i];
            }
        }
        return digitosFinal;
    }
}
