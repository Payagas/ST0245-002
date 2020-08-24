
/**
 * Coding Bat exercices from recursion 2, laboratory practice 2.2
 *
 * @author Pablo Maya Villegas
 */
public class SplitOdd10
{
    public boolean splitOdd10(int[] nums) {
        return groupSum(nums,0,0,0);
    }

    private boolean groupSum(int[] nums,int start,int sum1,int sum2) {
        if (start >= nums.length) 
            return (sum1%10==0 && sum2%2!=0);
        if (groupSum(nums,start+1,sum1+nums[start],sum2)) return true;
        if (groupSum(nums,start+1,sum1,sum2+nums[start])) return true;
        return false;
    }
}
