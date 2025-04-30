package string;

import java.util.Arrays;

public class _344_ReverseString {


    private void reverseCharArray(char[] chars) {
//        if (chars.length < 2) 这句可以省略——因为，如果 length 是 0 或 1，
//        那么，while (left < right) 就不会进入循环，也就不会对数组元素做出不必要对调整。
//        if (chars.length < 2){
//            return;
//        }
        int left = 0, right = chars.length - 1;
        while (left < right){
            char temp =  chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        testReverseCharArray();
    }

    private static void testReverseCharArray() {
        _344_ReverseString sol = new _344_ReverseString();

        // 测试用例 1：普通数组
        char[] arr1 = {'h','e','l','l','o'};
        sol.reverseCharArray(arr1);
        System.out.println("Expected [o, l, l, e, h], got " + Arrays.toString(arr1));

        // 测试用例 2：偶数长度
        char[] arr2 = {'J','a','v','a'};
        sol.reverseCharArray(arr2);
        System.out.println("Expected [a, v, a, J], got " + Arrays.toString(arr2));

        // 测试用例 3：长度 1
        char[] arr3 = {'x'};
        sol.reverseCharArray(arr3);
        System.out.println("Expected [x], got " + Arrays.toString(arr3));

        // 测试用例 4：空数组
        char[] arr4 = {};
        sol.reverseCharArray(arr4);
        System.out.println("Expected [], got " + Arrays.toString(arr4));
    }



}
