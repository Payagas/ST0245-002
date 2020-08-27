import java.util.*;
/**
 * Write a description of class InsertionSort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InsertionSort
{
    static int[] insertionSortCiclos(int[] a){
        int temp;
        for(int i=0; i<a.length-1; i++){
            for(int j=i; j>= 0; j--){
                if(a[j] > a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }else break;
            }
        }
        return a;
    }

    static void timeTester(int x, int y, int z){
        Random random = new Random();
        int[] a = random.ints(x, y,z).toArray();
        System.out.println(x);
        long ti = System.currentTimeMillis();
        insertionSortCiclos(a);
        long tf = System.currentTimeMillis();
        System.out.println("Tiempo transcurrido:"+ (tf - ti));
    }
    
    static void autoTester(int x, int y, int z, int aumento){
        int lim = x + aumento*20;
        while(x <= lim){
            timeTester(x,y,z);
            x += aumento;
        }
    }
}
