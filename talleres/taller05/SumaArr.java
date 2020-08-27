import java.util.Arrays;
/**
 * @author Pablo Maya Villegas
 */
public class SumaArr
{
    static int sumaArrCiclos(int [] a){
        int tot=0;
        for(int i=0; i<a.length; i++)
            tot += a[i];
        return tot;
    }

    static int sumaArrRecursion(int [] a, int n){
        if(n>=a.length) return 0;
        return a[n] + sumaArrRecursion(a,n+1);
    }

    static void timeTesterCiclos(int x, int y,int z){
        int [] a;
        long ti,tf;
        int X=x;
        while(x <= X + y*z){
            a = new int[x];
            Arrays.fill(a,7);
            ti = System.currentTimeMillis();
            System.out.println("Ciclos: "+sumaArrCiclos(a));
            tf = System.currentTimeMillis();
            System.out.println("Tiempo transcurrido:"+ (tf - ti));
            System.out.println("====="+x+"=====");
            x += z;
        }
    }

    static void timeTesterRecursion(int x, int y,int z){
        int [] a;
        long ti,tf;
        int X=x;
        while(x <= X + y*z){
            a = new int[x];
            Arrays.fill(a,7);
            ti = System.currentTimeMillis();
            System.out.println("Ciclos: "+sumaArrRecursion(a,0));
            tf = System.currentTimeMillis();
            System.out.println("Tiempo transcurrido:"+ (tf - ti));
            System.out.println("====="+x+"=====");
            x += z;
        }
    }

    static void timeTesterArchivo(int [] a){
        long ti,tf;
        ti = System.currentTimeMillis();
        System.out.println("Ciclos: "+sumaArrCiclos(a));
        tf = System.currentTimeMillis();
        System.out.println("Tiempo transcurrido:"+ (tf - ti));
        ti = System.currentTimeMillis();
        System.out.println("Recursion: "+sumaArrRecursion(a,0));
        tf = System.currentTimeMillis();
        System.out.println("Tiempo transcurrido:"+ (tf - ti));
        System.out.println("==========");
    }
}
