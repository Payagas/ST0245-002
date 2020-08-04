
/**
 * Clase principal.
 *
 * @author Pablo Maya
 * @author Miguel Angel Martinez
 * @version Julio, 2020
 */
public class Taller2 {
    
    public static int gcd(int q, int p){
        int res=p * q;
        if (res == 0)
            return p;
        return gcd(p%q,q);
    }

    public static boolean SumaGrupo(int[] nums, int target) {
        return SumaGrupo(0, nums, target);
    }	

    private static boolean SumaGrupo(int start, int[] nums, int target) {
        if(start > nums.length-1) return false;
        if(nums[start]==target)   return true;
        for(int i=start+1; i<nums.length; i++){
            int sum = nums[start]+nums[i];
            if(sum < target){
                if(sum == target || SumaGrupo(i+1,nums,target-sum))
                    return true;
            }
        }
        return SumaGrupo(start+1,nums,target);
    }

    public static void combinations(String s) { 
        combinationsAux("", s); 
    }

    private static void combinationsAux(String prefix, String s) {
        if(prefix.length()>0) {
            System.out.printf(prefix + ", ");
        }if(s.length()==0) {
            System.out.printf("");
        }else{
            combinationsAux(prefix + s.charAt(0), s.substring(1));
            if(s.length()>1) {
                for(int i = 1; s.length()>i; i++){
                    combinationsAux(prefix + s.charAt(i), s.substring(i+1));
                }
            }
        }
    }
}
