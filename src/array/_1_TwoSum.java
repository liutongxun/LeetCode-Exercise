package array;

import java.util.HashMap;

public class _1_TwoSum {

    private int[] twoSum2(int[] numbs1, int target1) {

        int left = 0;
        for (int right = 1; right < numbs1.length; right++) {
            if (numbs1[left] + numbs1[right] == target1) {
                return new int[]{left, right};
            }
            left++;
        }
        return null;
    }

    private int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> finder = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            if (finder.containsKey(complement)) {
                return new int[]{finder.get(complement), i};
            }
            finder.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        _1_TwoSum solution = new _1_TwoSum();

        // 示例 1
        int[] numbs1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(numbs1, target1);
        System.out.println("Result 1: [" + result1[0] + ", " + result1[1] + "]");  // 输出 [0, 1]

        // 示例 2
        int[] numbs2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(numbs2, target2);
        System.out.println("Result 2: [" + result2[0] + ", " + result2[1] + "]");  // 输出 [1, 2]

        // 示例 3
        int[] numbs3 = {7, 4};
        int target3 = 11;
        int[] result3 = solution.twoSum(numbs3, target3);
        System.out.println("Result 3: [" + result3[0] + ", " + result3[1] + "]");  // 输出 [0, 1]
    }


}
