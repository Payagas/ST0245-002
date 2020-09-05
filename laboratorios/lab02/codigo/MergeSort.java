
class MergeSort { 
    static void sort(int arr[]) 
    { 
        sort(arr,0,arr.length-1);
    } 
    
    static void sort(int arr[], int l, int r) 
    { 
        if (l < r) { 
            int m = (l + r) / 2; 

            sort(arr, l, m); 
            sort(arr, m + 1, r); 

            merge(arr, l, m, r); 
        } 
    } 

    static void merge(int arr[], int l, int m, int r) 
    { 
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
    
    static void timeTester(int numeroDatos){
        int[] a = worseCase(numeroDatos);
        System.out.println(numeroDatos);
        long ti = System.currentTimeMillis();
        sort(a);
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
