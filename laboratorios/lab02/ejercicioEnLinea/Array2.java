
public class Array2
{
    public int countEvens(int[] nums) {
        int cont = 0;
        for (int i=0; i <nums.length; i++){
            if (nums[i]%2 == 0) 
                cont++;
        }
        return cont;
    }

    public int centeredAverage(int[] nums) {
        int var1 =nums[0];
        int var2 =0;
        int acum =0;
        for(int i = 0; i<nums.length; i++){
            if (nums[i] < var1) var1 = nums[i];
            if (nums[i] > var2) var2 = nums[i];
            acum += nums[i];
        }
        acum-= (var1+var2);
        return acum/(nums.length-2);
    }

    public int sum67(int[] nums) {
        int trig = 0;
        int acum = 0;
        for(int i = 0; i<nums.length; i++){
            if (nums[i] == 6) trig = 1;
            if (trig == 0) acum += nums[i];
            if (nums[i] == 7) trig = 0;
        }
        return acum;
    }

    public boolean lucky13(int[] nums) {
        boolean cont = true;
        for(int i = 0; i<nums.length; i++){
            if (nums[i] == 1 || nums[i] == 3) 
                cont = false;
        }
        return cont;
    }

    public boolean more14(int[] nums) {
        int uno =0;
        int cua =0;
        for(int i = 0; i<nums.length; i++){
            if (nums[i] == 1) uno++;
            if (nums[i] == 4) cua++;
        }
        return (uno > cua);
    }

    public int[] withoutTen(int[] n) {
        int tmp=10;
        for(int i=0; i<n.length; i++){
            if(n[i]==10){
                n[i]=0;
                if(i<tmp)tmp=i;
            }
            else if(tmp!=10){
                n[tmp] = n[i];
                tmp=i;
                n[i]=0;
            }
        }
        return n;
    }

    public int[] zeroMax(int[] n) {
        for(int i=0; i<n.length; i++){
            if(n[i]==0){
                for(int j=i; j<n.length; j++){
                    if(n[j]%2 != 0){
                        if (n[i]<n[j])n[i]=n[j];
                    } } } } 
        return n;
    }
}
