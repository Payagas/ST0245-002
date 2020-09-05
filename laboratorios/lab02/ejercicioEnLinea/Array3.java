
public class Array3
{
    public int maxSpan(int[] nums) {
        if(nums.length==0)return 0;
        int temp; int max; int MAX=0;
        for(int i=0; i<nums.length; i++){
            temp = max = 1;
            for(int j=i+1; j<nums.length; j++){
                temp++;
                if(nums[i]==nums[j])max = temp;
            }
            MAX = Math.max(max, MAX);
        }
        return MAX;
    }

    public boolean canBalance(int[] nums) {
        int L=0; int R=0;
        for(int i=0; i<nums.length; i++){
            L += nums[i];
            R = 0;
            for(int j=nums.length-1; j>i; j--){
                R += nums[j];
                if(L == R && i == j-1) return true;
            }
        }
        return false;
    }

    public boolean linearIn(int[] outer, int[] inner) {
        int count=0; int in=0;
        for(int i=0; i<outer.length; i++){
            for(int j=in; j<inner.length; j++){
                if(outer[i] == inner[j]){
                    count++; in++;
                }
            }
        }
        return count == inner.length;
    }

    public int[] squareUp(int n) {
        int[] arr = new int[n*n];
        int N; int i=0; int en=n;
        while(i <= n){
            N = n*i -n+en;
            while(N < arr.length){
                arr[N] = i;
                N += n;
            }
            i++; en--;
        }
        return arr;
    }

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

    public int maxMirror(int[] nums) {
        int len = nums.length;
        int count= 0;
        int max = 0;
        for (int i = 0; i < len; i++){
            count=0;
            for (int j = len-1; i + count < len && j > -1; j--){
                if(nums[i+count] == nums[j]){
                    count++;
                }
                else if (count > 0){
                    max = Math.max(count,max);
                    count = 0;
                }
            }
            max = Math.max(count,max);
        }
        return max;
    }

    public int countClumps(int[] nums) {
        boolean clump=true;
        int cont=0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==nums[i+1]){
                if(clump){
                    cont++;
                    clump = false;
                } 
            }else clump = true;
        }
        return cont;
    }
}
