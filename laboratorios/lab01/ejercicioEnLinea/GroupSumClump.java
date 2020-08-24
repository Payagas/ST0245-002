
/**
 * Coding Bat exercices from recursion 2, laboratory practice 2.2
 *
 * @author Pablo Maya Villegas
 */
public class GroupSumClump
{
    public boolean groupSumClump(int start, int[] nums, int target) {
        int target2 = target;
        int temp = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==nums[i+1]){
                temp = nums[i];
                target2 -= temp;
                nums[i]=0;
            }else if(nums[i]==temp){
                target2 -= temp;
                nums[i]=0;
            }
        }
        return groupSum(start,nums,target) || groupSum(start,nums,target2);
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
