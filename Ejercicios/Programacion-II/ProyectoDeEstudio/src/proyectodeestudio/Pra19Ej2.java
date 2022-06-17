
import java.util.Random;
import proyectodeestudio.LT;


public class Pra19Ej2{
    
    public static void main(String[] args){
        new Pra19Ej2().principal();
    }
    
    private void principal(){
        TaulerTortuga t = new TaulerTortuga(20);
        System.out.print(t);
        LT.lecturaCaracter();
        t.endavant(2);
        System.out.print(t);
        LT.lecturaCaracter();
        t.dreta();
        t.endavant(3);
        System.out.print(t);
        LT.lecturaCaracter();
        t.dreta();t.dreta();t.dreta();
        t.endavant(4);
        System.out.print(t);
        LT.lecturaCaracter();
        t.dreta();t.dreta();t.dreta();
        t.endavant(3);
        System.out.print(t);
        LT.lecturaCaracter();
        t.dreta();
        t.endavant(2);
        System.out.print(t);
        LT.lecturaCaracter();
        t.dreta();
        t.endavant(7);
        System.out.print(t);
        LT.lecturaCaracter();
        t.dreta();
        t.endavant(9);
        System.out.print(t);
        LT.lecturaCaracter();
        t.dreta();
        t.endavant(7);
        System.out.println(t);
    }
    
    private class TaulerTortuga{
        private char[][] tauler;
        private int direc = 1; //direcció 0(N) 1(E) 2 (S) 3 (O)
        private final char TORTUGA = 'o', CAMI = '*', BUIT = '-';
        private int[] pos = new int[2];
        
        public TaulerTortuga(int n){
            tauler = new char[n][n];
            Random r = new Random();
            
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    tauler[i][j] = BUIT;
                }
            }
            int[] inici = {r.nextInt(n), r.nextInt(n)};
            tauler[inici[0]][inici[1]] = TORTUGA;
            pos = inici.clone();
        }
        
        public void dreta(){
            direc  = (direc + 1) % 4;
        }
        
        public void endavant(int n){
            int[] dir = new int[2];
            switch (direc){
                case 0: dir = new int[]{-1,0}; break;
                case 1: dir = new int[]{0,1}; break;
                case 2: dir = new int[]{1,0}; break;
                case 3: dir = new int[]{0,-1}; break;
            }
            for (int i = 0; i < n; i++){
                int[] nova = {pos[0]+dir[0], pos[1]+dir[1]};
                if (nova[0] >= tauler.length || nova[0] < 0 ||
                    nova[1] >= tauler.length || nova[1] < 0)
                    return;
                
                setPosicio(nova);
            }
        }
        
        private void setPosicio(int[] nova){
            tauler[pos[0]][pos[1]] = CAMI;
            tauler[nova[0]][nova[1]] = TORTUGA;
            pos = nova.clone();
        }
        
        public String toString()
        {
            String r = "";
            for (int i = 0; i < tauler.length; i++){
                for (int j = 0; j < tauler.length; j++){
                    r += tauler[i][j];
                }
                r += '\n';
            }
            return r;
        }
    }
}