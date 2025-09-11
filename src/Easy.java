public class Easy {
    //1. Two Sum
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    //2. Palindrome Number
    public boolean isPalindrome(int x) {
        String number = Integer.toString(x);
        String contrary = "";

        for(int i = number.length() - 1; i > -1; i--) {
            contrary += number.charAt(i);
        }

        if(contrary.equals(number)) {
            return true;
        }

        return false;
    }
}