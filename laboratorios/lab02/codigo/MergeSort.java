
/**
 * This algorithm takes the principal of divide to concor
 * It separates recursively the array and organises it by section
 * 
 * @autor Pablo Maya Villegas & Miguel Angel Martinez
 */
class MergeSort { 
    /**
     * This is the starter method to facilitate the first call
     * 
     * @param arr the array to be organised
     */
    static void sort(int arr[]) { 
        sort(arr,0,arr.length-1);
    } 
    
    /**
     * This is the part of the algorithm that divides the current
     * array in 2 parts, it doesn't directly tamper with the array,
     * it keeps count of the limits to tamper only with one 
     * section at a time.
     * 
     * @param arr the array being organised
     * @param l the leftmost limit of the section of the array
     * @param m the middle point of the section of the array
     * @param r the rightmost limit of the section of the array
     * 
     *   Adapted from:
     * Autor: Rajat Mishra
     * Tittle: MergeSort
     * Type: Method
     * Publisher: www.geeksforgeeks.org/merge-sort/
     */
    static void sort(int arr[], int l, int r) { 
        if (l < r) { 
            int m = (l + r) / 2; 

            sort(arr, l, m); 
            sort(arr, m + 1, r); 

            merge(arr, l, m, r); 
        } 
    } 

    /**
     * This is the part of the algorithm that joins organised
     * arrays to be efficient.
     * 
     * @param arr the array being organised
     * @param l the leftmost limit of the section of the array
     * @param m the middle point of the section of the array
     * @param r the rightmost limit of the section of the array
     * 
     *   Adapted from:
     * Autor: Rajat Mishra
     * Tittle: MergeSort
     * Type: Method
     * Publisher: www.geeksforgeeks.org/merge-sort/
     */
    static void merge(int arr[], int l, int m, int r) { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 

        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j]; 

        int i = 0, j = 0, k = l; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                arr[k] = L[i]; 
                i++; 
            } else { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 

        while (i < n1) { 
            arr[k] = L[i]; 
            i++; k++; 
        } 

        while (j < n2) { 
            arr[k] = R[j]; 
            j++; k++; 
        } 
    } 
    
    /**
     * This method tests how much time the algorithm takes
     * in the worst case scenario
     * 
     * @param numeroDatos the size of the array
     */
    static void timeTester(int numeroDatos){
        int[] a = worseCase(numeroDatos);
        System.out.println(numeroDatos);
        long ti = System.currentTimeMillis();
        sort(a);
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
