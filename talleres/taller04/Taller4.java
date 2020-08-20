
public class Taller4 {

    public static int arrayMax(int [] array, int start) {
        if(start < 0) return 0;
        int max, temp;
        temp =  array[start];
        max = arrayMax(array, start-1);
        if(temp > max) max = temp;
        return max;
    }

    public static boolean groupSum(int start, int[] nums, int target) {
        if(start > nums.length-1) return false;
        if(nums[start]==target)   return true;
        for(int i=start+1; i<nums.length; i++){
            int sum = nums[start]+nums[i];
            if(sum < target){
                if(sum == target || groupSum(i+1,nums,target-sum))
                    return true;
            }
        }
        return groupSum(start+1,nums,target);
    }

    public static long fibonacci(int n) { 
        if(n < 1) return 0;
        if(n < 2) return 1;
        return (fibonacci(n-1)+fibonacci(n-2));
    }
}