
/**
 * Coding Bat exercices from recursion 1, laboratory practice 2.1
 *
 * @author Pablo Maya Villegas, Miguel Angel Martinez
 */
public class Recursion1
{

    public int countX(String str) {
        if(str.length() < 1)
            return 0;
        if(str.charAt(0) == 'x')
            return 1 + countX(str.substring(1,str.length()));
        else return countX(str.substring(1,str.length()));
    }

    public int array11(int[] nums, int index) {
        if(index == nums.length)
            return 0;
        if(nums[index] == 11)
            return 1 + array11(nums, index+1);
        else return array11(nums, index+1);
    }

    public String noX(String str) {
        if(str.length() < 1)
            return "";
        if(str.charAt(0) == 'x')
            return noX(str.substring(1,str.length()));
        else return str.charAt(0) + noX(str.substring(1,str.length()));
    }

    public int fibonacci(int n) {
        if(n <= 1) return n;
        return (fibonacci(n-1)+fibonacci(n-2));
    }

    public String changeXY(String str) {
        if(str.length() < 1)
            return "";
        if(str.charAt(0) == 'x')
            return 'y' + changeXY(str.substring(1,str.length()));
        else return str.charAt(0) + changeXY(str.substring(1,str.length()));
    }
}
