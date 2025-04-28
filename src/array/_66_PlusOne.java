package array;

public class _66_PlusOne {


    // while循环版本
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (digits[index] == 9) {
            if (index == 0){
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                return result;
            }
            digits[index--] = 0;
        }

        digits[index] = digits[index] + 1;
        return digits;
    }


    public int[] plusOne4(int[] digits) {

        int length = digits.length - 1;
        for (int i = length; i >= 0 ; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;

    }
    private int[] plusOne2(int[] digits1) {

        String str = "";
        for (int i = 0; i <digits1.length ; i++) {
            str += digits1[i];
        }

        Integer num = Integer.valueOf(str);
        num += 1;

        String numStr = String.valueOf(num);

        String[] split = numStr.split("");
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.valueOf(split[i]);
        }
        return result;
    }

    public int[] plusOne3(int[] digits) {
        // 从末尾开始处理
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                // 如果当前数字不是9，则直接加1
                digits[i]++;
                return digits;  // 直接返回结果
            }
            // 如果当前数字是9，设置为0，并继续进位
            digits[i] = 0;
        }

        // 如果所有数字都是9，那么此时数组的每一位都已被置为0
        // 需要一个新数组来存储最终的结果，长度比原数组多1
        int[] result = new int[digits.length + 1];
        result[0] = 1;  // 在数组的首位加1，其他位都默认是0
        return result;
    }
    public static void main(String[] args) {
        _66_PlusOne solution = new _66_PlusOne();

        // 测试用例1
        int[] digits1 = {1, 2, 3};
        int[] result1 = solution.plusOne(digits1);
        System.out.println("Result 1: " + java.util.Arrays.toString(result1));

        // 测试用例2
        int[] digits2 = {9, 9, 9};
        int[] result2 = solution.plusOne(digits2);
        System.out.println("Result 2: " + java.util.Arrays.toString(result2));

        // 测试用例3
        int[] digits3 = {2, 3, 4, 9, 9};
        int[] result3 = solution.plusOne(digits3);
        System.out.println("Result 3: " + java.util.Arrays.toString(result3));
    }


}
