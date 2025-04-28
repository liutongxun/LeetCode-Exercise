package array;

public class _189_RotateArray {

    // 反转数组中指定区间的元素
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // 交换两个元素
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // 旋转数组
    public static void rotate(int[] nums, int k) {
        int n = nums.length;

        // 如果 k 大于数组的长度，取 k 对数组长度的模
        k = k % n;

        // 反转整个数组
        reverse(nums, 0, n - 1);

        // 反转前 k 个元素
        reverse(nums, 0, k - 1);

        // 反转后 n - k 个元素
        reverse(nums, k, n - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        // 执行旋转操作
        rotate(nums, k);

        // 打印结果
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
