package string;

public class _125_Valid_Palindrome {

    private boolean isPalindrome2(String s1) {

        if (s1.length() <= 1){
            return true;
        }

        int left = 0, right = s1.length() - 1;
        while (left < right){
            if (!Character.isLetterOrDigit(s1.charAt(left))){
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s1.charAt(right))){
                right--;
                continue;
            }
            if (Character.toLowerCase(s1.charAt(left)) != Character.toLowerCase(s1.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s1) {

        if (s1.length() <= 1){
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stringBuilder.append(Character.toLowerCase(c));
            }
        }

        s1 = stringBuilder.toString();

        int left = 0, right = s1.length() - 1;
        while (left < right){
            if (s1.charAt(left) != s1.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        _125_Valid_Palindrome solution = new _125_Valid_Palindrome();

        // 测试用例 1：回文字符串，包含特殊字符和大小写字母
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("Test case 1: " + solution.isPalindrome(s1));  // true

        // 测试用例 2：非回文字符串
        String s2 = "race a car";
        System.out.println("Test case 2: " + solution.isPalindrome(s2));  // false

        // 测试用例 3：回文字符串，只有一个字符
        String s3 = "a";
        System.out.println("Test case 3: " + solution.isPalindrome(s3));  // true

        // 测试用例 4：空字符串
        String s4 = "";
        System.out.println("Test case 4: " + solution.isPalindrome(s4));  // true

        // 测试用例 5：包含空格和特殊字符的回文字符串
        String s5 = "No 'x' in Nixon";
        System.out.println("Test case 5: " + solution.isPalindrome(s5));  // true

        // 测试用例 6：非回文字符串，包含数字和字母
        String s6 = "Hello, World!";
        System.out.println("Test case 6: " + solution.isPalindrome(s6));  // false

        // 测试用例 7：只包含数字的回文
        String s7 = "12321";
        System.out.println("Test case 7: " + solution.isPalindrome(s7));  // true

        // 测试用例 8：只包含数字的非回文
        String s8 = "12345";
        System.out.println("Test case 8: " + solution.isPalindrome(s8));  // false
    }


}
