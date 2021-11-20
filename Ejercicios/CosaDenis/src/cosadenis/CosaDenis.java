/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosadenis;

/**
 *
 * @author tonif
 */
public class CosaDenis {

    String texto, returnText;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new CosaDenis().metodoPrincipal();
    }
    
    private void metodoPrincipal()
    {
        texto = LT.readLine();
        returnText = "";
        
        interact();
        
        System.out.println(returnText);
    }
    
    private void interact()
    {
        for (int i = 0; i< texto.length(); i++)
        {
            
            if (i != texto.length()-1)
            {
                int z = i;
                for (int j = 0; j <9; j++)
                {
                    if (texto.charAt(i) == '8' && texto.charAt(i+1) == '9')
                    {
                        i++;
                        returnText += '0';
                        break;
                    }
                    else if (texto.charAt(i) == '9' && texto.charAt(i+1) == '0')
                    {
                        i++;
                        returnText += '1';
                        break;
                    }
                    else if (texto.charAt(i) == Integer.toString(j).charAt(0) &&
                            texto.charAt(i+1) == Integer.toString(j+1).charAt(0))
                    {
                        returnText += Integer.toString(j+2).charAt(0);
                        i++;
                        break;
                    }
                }
                if (z == i)
                {
                    returnText += texto.charAt(i);
                }
            }
            else
                returnText += texto.charAt(i);
        }
    }
}
