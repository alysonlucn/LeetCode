import java.util.HashMap;
import java.util.Map;

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

    //3. Roman to Integer
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;

        for(int i = 0; i < s.length(); i++) {
            int current = romanMap.get(s.charAt(i));

            if((i + 1) < s.length()) {
                int next = romanMap.get(s.charAt(i + 1));

                if(current < next) {
                    total -= current;
                } else {
                    total += current;
                }
            } else {
                total += current;
            }
        }
        return total;
    }

    //4. Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        String word = strs[0];

        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(word) != 0) {
                word = word.substring(0, word.length() -1);

                if(word.isEmpty()) return "";
            }
        }
        return word;
    }

    //5. Find Most Frequent Vowel and Consonant
    public int maxFreqSum(String s) {
        String vowels = s.replaceAll("[^aeiouAEIOU]", "");
        String consonants = s.replaceAll("[aeiouAEIOU]", "");

        int maxVowel = 0;
        for (int i = 0; i < vowels.length(); i++) {
            char currentChar = vowels.charAt(i);
            int currentFreq = 0;
            for (int j = 0; j < vowels.length(); j++) {
                if (currentChar == vowels.charAt(j)) {
                    currentFreq++;
                }
            }
            if (currentFreq > maxVowel) {
                maxVowel = currentFreq;
            }
        }

        int maxConsonant = 0;
        for (int i = 0; i < consonants.length(); i++) {
            char currentChar = consonants.charAt(i);
            int currentFreq = 0;
            for (int j = 0; j < consonants.length(); j++) {
                if (currentChar == consonants.charAt(j)) {
                    currentFreq++;
                }
            }
            if (currentFreq > maxConsonant) {
                maxConsonant = currentFreq;
            }
        }

        return maxVowel + maxConsonant;
    }

    //6. Maximum Number of Words You Can Type
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");

        int count = 0;
        for (String word : words) {
            boolean isValid = true;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (brokenLetters.indexOf(c) != -1) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                count++;
            }
        }

        return count;
    }

    //7. Find the Index of the First Occurrence in a String
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    //8. Remove Element
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    //9. Search Insert Position
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}