/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioclase.programacionii;

public class EjercicioClaseProgramacionII {
    public static void main(String[] args){
        new EjercicioClaseProgramacionII().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        int seleccion = 0;
        System.out.print("Acabar? (1 o 2): ");
        try{
            seleccion = LT.readInt();
            if (seleccion < 1 || 2 < seleccion)
                throw new NumeroFueraDeRango("No es un numero dentro del rango válido. Es 1 o 2 subnormal");
        }
        catch (NumeroFueraDeRango e){
            System.out.println(e.toString());
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        while (seleccion == 1)
        {
            System.out.print("Acabar?: ");
            try{
            seleccion = LT.readInt();
            if (seleccion < 1 || 2 < seleccion)
                throw new NumeroFueraDeRango("No es un numero dentro del rango válido. Es 1 o 2 subnormal");
        }
        catch (NumeroFueraDeRango e){
            System.out.println(e.toString());
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
            
            System.out.print("Insertar un numerito entero: ");
            int numero;
            try {
                numero = LT.readInt();
                if (numero >= 0)
                    //Mostrar el factorial
                    System.out.println("Su factorial es " + fact(numero));
                else if (numero > 12)
                    //Gestionar la validez del número según el rango permitido
                    throw new NumeroRangoDesborado("El número introducido no se encuentra en un rango válido");
                else
                    //Gestionar la validez del número según el rango permitido
                    throw new NumeroFueraDeRango("El número introducido no se encuentra en un rango válido");
            }
            catch (NumeroRangoDesborado e){
                System.err.println("Error: " + e.toString());
            }
            catch (NumeroFueraDeRango e){
                System.err.println("Error: " + e.toString());
            }
            catch (NumberFormatException e){
                System.err.println("El dato introducido no es un número entero");
            }
            catch(Exception e)
            {
                System.out.println("Error: " + e.toString());
            }
        }
    }
    
    private int fact(int n)
    {
        if (n == 1 || n == 0)
            return 1;
        else
            return n*fact(n-1);
    }
}
