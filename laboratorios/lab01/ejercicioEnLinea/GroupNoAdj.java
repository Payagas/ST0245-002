
/**
 * Coding Bat exercices from recursion 2, laboratory practice 2.2
 *
 * @author Pablo Maya Villegas
 */
public class GroupNoAdj
{
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(target == 0) return true;
        if(start > nums.length-2 && nums.length != 1) return false;
        if(nums[start]==target)   return true;
        if(nums.length == 1) return false;
        for(int i=start+2; i<nums.length; i++){
            int sum = nums[start]+nums[i];
            if(sum <= target){
                if(sum == target || groupNoAdj(i+1,nums,target-sum))
                    return true;
            }
        }
        return groupNoAdj(start+1,nums,target);
    }
}
