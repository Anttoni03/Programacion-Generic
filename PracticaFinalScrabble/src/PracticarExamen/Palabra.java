
package PracticarExamen;

public class Palabra
{
    private char[] caracteres = new char[20];
    private int numeroCaracteres;
    public Palabra(){
        numeroCaracteres = 0;
    }

    public void adicionCaracter(char car){
        caracteres[numeroCaracteres] = car;
        numeroCaracteres++;
    }

    public boolean esValida(){
        char[] caracteresUsados = new char[20];
        if (numeroCaracteres > 10){
            for (int indice1 = 0; indice1 < numeroCaracteres; indice1++){
                boolean valida = true;
                for (int indice2 = 0;  indice2 < indice1 && valida; indice2++){
                    if (caracteres[indice1] == caracteresUsados[indice2]){
                        valida = false;
                    }
                }
                if (valida){
                    caracteresUsados[indice1] = caracteres[indice1];
                }
                else{
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public char last()
    {
        return caracteres[numeroCaracteres-1];
    }
    public String toString(){
        String salida = "";
        for (int indice = 0; indice < numeroCaracteres; indice++){
            salida += caracteres[indice];
        }
        return salida;
    }
}