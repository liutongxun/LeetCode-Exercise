package array;

public class _136_SingleNumber {

    public int singleNumber(int[] nums) {
       int finder = 0;
       for (int num : nums) {
           finder ^= num;
       }
       return finder;
    }

    public static void main(String[] args) {
        _136_SingleNumber solution = new _136_SingleNumber();

        // 示例数组，只有一个数字出现一次
        int[] nums = {4, 5, 5, 1, 2, 1, 2};

        // 输出唯一出现一次的数字
        System.out.println(solution.singleNumber(nums));  // 输出 4
    }
}
