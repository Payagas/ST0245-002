
public class Punto1
{
    public static void hanoi(int  topN){

     hanoi(topN, "Tower1", "Tower2", "Tower3");

  }
 
 public static void hanoi(int topN, String a, String b, String c){

     if (topN == 1)

         // de la torre en la que lo tenga a la última torre

         System.out.println (a + " -> " + c);

     else {

         hanoi(topN - 1 ,a , c ,b);

         hanoi(1 , a , b , c);

         hanoi(topN - 1 ,b , a ,c);

     }

  }
 
 public static void main(String[] args){

    hanoi(3);

  }

}
