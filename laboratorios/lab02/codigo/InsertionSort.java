
/**
 * This class uses the insertion sort algorithm
 * to organise arrays from low to high
 * and test the delay time.
 * 
 * @autor Pablo Maya Villegas & Miguel Angel Martinez
 */
public class InsertionSort
{
    /**
     * The algorithm that organises the array.
     * 
     * @param array the base to organise
     * @return the organised array
     */
    static int[] insertionSort(int[] array){
        int temp;
        for(int i=0; i<array.length-1; i++){
            for(int j=i; j>= 0; j--){
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }else break;
            }
        }
        return array;
    }

    /**
     * This method tests how much time the algorithm takes
     * in the worst case scenario
     * 
     * @param numeroDatos the size of the array
     */
    static void timeTester(int numeroDatos){
        int[] array = worseCase(numeroDatos);
        System.out.println(numeroDatos);
        long ti = System.currentTimeMillis();
        insertionSort(array);
        long tf = System.currentTimeMillis();
        System.out.println("Tiempo transcurrido:"+ (tf - ti));
    }
    
    /**
     * This method automates the creacion of time testers
     * so that they can be easily compared.
     * 
     * @param numeroDatos the size of the starter array
     * @param aumento the increase that the size goes through each cycle
     * @param veces the amount of time testers called
     */
    static void autoTester(int numeroDatos, int aumento, int veces){
        int lim = numeroDatos + aumento*veces;
        while(numeroDatos <= lim){
            timeTester(numeroDatos);
            numeroDatos += aumento;
        }
    }
    
    /**
     * This method creates an array organised from high to low
     * to compare the algorithms in their worst case scenario.
     * 
     * @param numeroDatos the size of the array
     * @return wc the worse case array 
     */
    static int[] worseCase(int numeroDatos){
        int[] wc = new int[numeroDatos];
        for(int i=0; i<numeroDatos; i++){
            wc[i] = numeroDatos-i;
        }
        return wc;
    }
}
