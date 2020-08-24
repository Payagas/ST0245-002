
/**
 * Coding Bat exercices from recursion 2, laboratory practice 2.2
 *
 * @author Pablo Maya Villegas
 */
public class GroupSum6
{
    public boolean groupSum6(int start, int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]==6){
                target -= 6;
                nums[i]=0;
            }
        }
        if (target<0) return false;
        return groupSum(start,nums,target);
    }
    
    public boolean groupSum(int start, int[] nums, int target) {
        if(target == 0) return true;
        if(start > nums.length-1 && nums.length != 1) return false;
        if(nums[start]==target)   return true;
        if(nums.length == 1) return false;
        for(int i=start+1; i<nums.length; i++){
            int sum = nums[start]+nums[i];
            if(sum <= target){
                if(sum == target || groupSum(i+1,nums,target-sum))
                    return true;
            }
        }
        return groupSum(start+1,nums,target);
    }
}
