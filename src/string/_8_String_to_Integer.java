package string;

public class _8_String_to_Integer {

    private int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0){
            return 0;
        }

        int sign = 1;
        int index = 0;
        if (s.charAt(0) == '-'){
            sign = -1;
            index = 1;
        }else if (s.charAt(0) == '+'){
            index = 1;
        }

        int result = 0;


        while (index < s.length() && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0'; // 获取数字
            // 错误
//            int digit2 = Integer.valueOf(s.charAt(index));

            if (result > Integer.MAX_VALUE / 10 ||
                            result == Integer.MAX_VALUE / 10 &&  digit > Integer.MAX_VALUE % 10){
                return  sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }

        return (int)sign * result;
    }



    public static void main(String[] args) {
        _8_String_to_Integer solution = new _8_String_to_Integer();

        // 测试用例 1：空字符串
        String s1 = "";
        System.out.println("Test case 1: " + solution.myAtoi(s1));  // 输出：0

        // 测试用例 2：前导空格
        String s2 = "   -42";
        System.out.println("Test case 2: " + solution.myAtoi(s2));  // 输出：-42

        // 测试用例 3：正号
        String s3 = "+123";
        System.out.println("Test case 3: " + solution.myAtoi(s3));  // 输出：123

        // 测试用例 4：包含字母
        String s4 = "42abc";
        System.out.println("Test case 4: " + solution.myAtoi(s4));  // 输出：42

        // 测试用例 5：溢出情况（大于 Integer.MAX_VALUE）
        String s5 = "2147483648";  // 超出整数最大值
        System.out.println("Test case 5: " + solution.myAtoi(s5));  // 输出：2147483647

        // 测试用例 6：负数溢出情况（小于 Integer.MIN_VALUE）
        String s6 = "-2147483649";  // 超出整数最小值
        System.out.println("Test case 6: " + solution.myAtoi(s6));  // 输出：-2147483648

        // 测试用例 7：只有符号没有数字
        String s7 = "+";
        System.out.println("Test case 7: " + solution.myAtoi(s7));  // 输出：0

        // 测试用例 8：只包含字母
        String s8 = "abc";
        System.out.println("Test case 8: " + solution.myAtoi(s8));  // 输出：0

        // 测试用例 9：包含多个符号（测试符号后面有数字）
        String s9 = "-+12";
        System.out.println("Test case 9: " + solution.myAtoi(s9));  // 输出：-12

        // 测试用例 10：前导零
        String s10 = "00000000000123";
        System.out.println("Test case 10: " + solution.myAtoi(s10));  // 输出：123

        // 测试用例 11：仅包含空格
        String s11 = "    ";
        System.out.println("Test case 11: " + solution.myAtoi(s11));  // 输出：0
    }


}
