package numbers;

public class _7_ReverseInteger {

    private int reverse2(int num) {
       int reversed = 0;

       while (num != 0) {
           int remainder = num % 10;
           int temp = (reversed * 10) + remainder;

           if ((temp - remainder) / 10 != reversed){
               return 0;
           }
           reversed = temp;
           num = num / 10;
       }
       return reversed;
    }

    public int reverse(int num) {
        int reversed = 0;
        while (num != 0) {
            // 1. 弹出末位
            int remainder = num % 10;
            num /= 10;

            // 2. 溢出检查
            // 如果 rev 已经大于 Integer.MAX_VALUE/10，则 rev*10 肯定溢出
            if (reversed > Integer.MAX_VALUE/10 ||
                    (reversed == Integer.MAX_VALUE/10 && remainder > 7)) {
                return 0;
            }

            // 如果 rev 已经小于 Integer.MIN_VALUE/10，则 rev*10 肯定溢出
            if (reversed < Integer.MIN_VALUE/10 ||
                    (reversed == Integer.MIN_VALUE/10 && remainder < -8)) {
                return 0;
            }

            // 3. 推入末位
            reversed = reversed * 10 + remainder;
        }
        return reversed;
    }




    public static void main(String[] args) {
        _7_ReverseInteger sol = new _7_ReverseInteger();

        test(sol, 123, 321);
        test(sol, -123, -321);
        test(sol, 120, 21);
        test(sol, 0, 0);
        // 溢出案例：翻转后 1534236469 -> 9646324351 超出 int 范围，应返回 0
        test(sol, 153423646, 646324351);
        test(sol, 1534236469, 0);
        // 边界值
        test(sol, Integer.MAX_VALUE, 0);
        test(sol, Integer.MIN_VALUE, 0);
    }

    private static void test(_7_ReverseInteger sol, int input, int enumpected) {
        int output = sol.reverse(input);
        System.out.printf("reverse(%d) = %d   [%s]\n",
                input, output, output == enumpected ? "PASS" : "FAIL, enumpected " + enumpected);
    }


}
