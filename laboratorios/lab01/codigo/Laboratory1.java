import java.util.*;
import java.io.*; 
/**
 *
 * @author Pablo Maya Villegas
 * This class contains the methods that solve points 1.1 and 1.2 of laboratory 
 * practice 1
 */
public class Laboratory1 {

    public static long bucles = 0;

    /**
     * This method calculates the longest common sequence between two strings
     * @param s1 First string
     * @param s2 Second string
     * @return length of the largest common sequence between cadena
     */
    public static int lcsDNA(String s1, String s2){
        return lcsDNAAux(s1,s2,s1.length(),s2.length());
    }

    /**
     * This method is an auxiliar for lcsDNA
     * @param s1 first characters string
     * @param s2 second characters string
     * @param m length of s1
     * @param n length of s2
     * @return length of the largest common sequence between two strings
     */
    private static int lcsDNAAux(String s1, String s2, int m, int n) {
        bucles++;
        if(m<1||n<1) return 0;
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return 1 + lcsDNAAux(s1.substring(0,m-1),s2.substring(0,n-1),m-1,n-1);
        }
        return Math.max(
            lcsDNAAux(s1,s2.substring(0,n-1),m,n-1), 
            lcsDNAAux(s1.substring(0,m-1),s2,m-1,n));
    }

    /**
     * This method calculates how many ways there are for organizing rectangles
     * of 1x2 in a rectangle of 2xn
     * @param n side n of the rectangle 2xn
     * @return number of ways that rectangles of 1x2 can be organized 
     * in a rectangle of 2xn
     */
    public static int ways(int n){
        if(n<2) return 1;
        return ways(n-1) + ways(n-2);
    }

    /**
     * Empty testing method
     */
    public static void timeCalculator(){
        timeCalculator(
            "C:\\Users\\Pablo\\Desktop\\Anoplogaster.txt",
            "C:\\Users\\Pablo\\Desktop\\Acipenser.txt",
            1, 200, 10);
    }

    /**
     * This metod calculates the time requiered to process strings.
     * It has multiple variables to choose.
     * @param uno first text file to read
     * @param dos second text file to read
     * @param X rate of change between increasing tests
     * @param Y starting point of the string
     * @param Z starting characters
     */
    public static void timeCalculator (
    String arcUno, String arcDos, int X, int Y, int Z){
        int x = X;
        int y = Y;
        int z = Z;
        String uno="";
        String dos="";
        try {
            uno = read(arcUno);
            dos = read(arcDos);
        } catch (FileNotFoundException e) {
            System.out.print(e.getMessage()); 
        }
        for(int i=1; i<=20; i++){
            System.out.println("=========="+i+"==========");
            String a1 = uno.substring(y,y + z + x*i);
            String a2 = dos.substring(y,y + z + x*i);
            System.out.println(a1);
            System.out.println(a2);
            System.out.println("Tamaño: "+a1.length());
            long ti = System.currentTimeMillis();
            System.out.println("Encontrado: "+lcsDNA(a1,a2));
            long tf = System.currentTimeMillis();
            System.out.println("Tiempo transcurrido:"+ (tf - ti));
            System.out.println("Recursion "+bucles);
        }
    }

    /**
     * Metod used to read archives used in the timeCalculator method;
     */
    public static String read(String name) throws FileNotFoundException {
        Scanner file = new Scanner(new File(name));
        return file.next();
    }
}