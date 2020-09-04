
/**
 * Write a description of class wx here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Punto3
{
    public int[] seriesUp(int n) {
        int c=0;
        int[] x = new int[n*(n + 1)/2];
        for(int i=1; i<=n;i++){
            for(int j=1; j<=i; j++){
                x[c]=j;
                c++;
            }
        }
        return x;
    }
}
