/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author alexsanchez
 */
public class ProgramaPrueba {
    public static void main(String []args)throws Exception{
        clasePrincipal mimi = new clasePrincipal();
        int menu;
        
        menu = mimi.menu();
        if(menu == 1){
            mimi.menuJugar();
        }
        
        mimi.nombre();
        mimi.numTurnos();
        mimi.generacionArrays();
        mimi.visualizarCaracteres();
        mimi.visualizarNumeros();
    }
}
