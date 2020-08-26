
/**
 * Write a description of class Taller5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Taller5{ 
 public static int suma(int[] a){

      int sum = 0;  // c1 

      for (int i = 0; i < a.length; i++) // c2 + c3n

         sum = sum + a[i]; // c4n

      return sum; // c5

   }               // T(n) = c1 + c2 + c5 + (c3 + c4)n

                   // T(n) es O(n)


   

 }

