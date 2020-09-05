
public class InsertionSort
{
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

    static void timeTester(int numeroDatos){
        int[] array = worseCase(numeroDatos);
        System.out.println(numeroDatos);
        long ti = System.currentTimeMillis();
        insertionSort(array);
        long tf = System.currentTimeMillis();
        System.out.println("Tiempo transcurrido:"+ (tf - ti));
    }
    
    static void autoTester(int numeroDatos, int aumento, int veces){
        int lim = numeroDatos + aumento*veces;
        while(numeroDatos <= lim){
            timeTester(numeroDatos);
            numeroDatos += aumento;
        }
    }
    
    static int[] worseCase(int numeroDatos){
        int[] wc = new int[numeroDatos];
        for(int i=0; i<numeroDatos; i++){
            wc[i] = numeroDatos-i;
        }
        return wc;
    }
}
