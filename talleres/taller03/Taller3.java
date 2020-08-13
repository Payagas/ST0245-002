/**
 *
 * La clase Taller3 tiene como objtivo dar solución a los puntos del taller 3
 *
 * @author Mauricio Toro, Andrés Páez
 * @version 1
 */

public class Taller3 {

    public static void torresDeHannoi(int topN) {
        torresDeHannoiAux(topN, "Tower1", "Tower2", "Tower3");
    }

    public static void torresDeHannoiAux(int topN, String a, String b, String c){

        if (topN == 1)
        // de la torre en la que lo tenga a la última torre
            System.out.println (a + " -> " + c);

        else {
            torresDeHannoiAux(topN - 1 ,a , c ,b);
            torresDeHannoiAux(1 , a , b , c);
            torresDeHannoiAux(topN - 1 ,b , a ,c);
        }

    }

    public static void permutation(String str) {
        permutationAux("", str); 
    }

    private static void permutationAux(String prefix, String str) {
        if(prefix.length()==0) {
            for(int i = 0; str.length()>i; i++){
                permutationAux("" + str.charAt(i), str.substring(0, i) + str.substring(i+1));
            }   
        }else if(str.length()>1){
            permutationAux(prefix + str.charAt(0), str.substring(1));
            for(int i = 1; str.length()>i; i++){
                permutationAux(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1));
            }
        }else{ 
            System.out.printf(prefix + str + ", ");
        }
    }

    public static void combinations(String str) {
        combinationsAux("", str); 
    }

    private static void combinationsAux(String prefix, String s) {
        if(prefix.length()>0) {
            System.out.printf(prefix + ", ");
        }if(s.length()==0) {
            System.out.printf("");
        }else{
            combinationsAux(prefix + s.charAt(0), s.substring(1));
            if(s.length()>1) {
                for(int i = 1; s.length()>i; i++){
                    combinationsAux(prefix + s.charAt(i), s.substring(i+1));
                }
            }
        }
    }

}