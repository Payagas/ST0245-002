
/**
 * Coding Bat exercices from recursion 2, laboratory practice 2.2
 *
 * @author Pablo Maya Villegas
 */
public class GroupSum5
{
    public boolean groupSum5(int start, int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]%5==0){
                target -= nums[i];
                nums[i]=0;
                if(i<nums.length-1 && nums[i+1]==1)
                    nums[i+1]=0;
            }
        }
        if (target<0) return false;
        return groupSum(start,nums,target);
    }

    public boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;
        if (groupSum(start + 1, nums, target - nums[start]) |
        groupSum(start + 1, nums, target))
            return true;
        return false;
    }
}
