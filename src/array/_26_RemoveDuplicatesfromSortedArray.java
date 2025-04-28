package array;

public class _26_RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        _26_RemoveDuplicatesfromSortedArray solution = new _26_RemoveDuplicatesfromSortedArray();
        int[] nums = {0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = solution.removeDuplicates(nums);

        System.out.println("Unique elements count: " + k);
        System.out.println("Updated array: ");

        // 输出更新后的数组
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private int removeDuplicates(int[] nums) {

        // 如果数组为空，返回 0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[count]){
                count++;
                nums[count] = nums[i];
            }
        }
        return count+1;
    }
}
