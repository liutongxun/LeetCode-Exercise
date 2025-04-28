package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {

    private List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return null;

        // 先对数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int sum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;

                }else if(sum < 0){
                    left++;
                }else {
                    right--;
                }

            }
        }
        return result;
    }


    public static void main(String[] args) {
        _15_3Sum solution = new _15_3Sum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);

        // 输出结果
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }

}
