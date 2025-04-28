package array;

import java.util.*;

public class _350_IntersectionofTwoArrays_II {
    // 查找两个数组交集的函数
    public int[] intersect2(int[] nums1, int[] nums2) {
        // 使用 HashMap 存储 nums1 数组中元素的频率
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // 将 nums1 数组中元素及其频率存储到 HashMap
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 遍历 nums2 数组，查找与 nums1 交集的元素
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);  // 将交集元素添加到结果列表
                map.put(num, map.get(num) - 1);  // 在 HashMap 中减少该元素的频率
            }
        }

        // 将结果列表转换为数组
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
    // 查找两个数组交集的函数
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> counterMap = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            counterMap.put(nums1[i],counterMap.getOrDefault(nums1[i],0)+1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (counterMap.containsKey(nums2[i])) {
                result.add(nums2[i]);
                counterMap.put(nums2[i],counterMap.get(nums2[i])-1);
                if (counterMap.get(nums2[i]) == 0) {
                    counterMap.remove(nums2[i]);
                }
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    // 测试函数
    public static void main(String[] args) {
        _350_IntersectionofTwoArrays_II solution = new _350_IntersectionofTwoArrays_II();

        // 测试案例 1
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println("交集: " + Arrays.toString(solution.intersect(nums1, nums2)));

        // 测试案例 2
        int[] nums11 = {4, 9, 5};
        int[] nums22 = {9, 4, 9, 8, 4};
        System.out.println("交集: " + Arrays.toString(solution.intersect(nums11, nums22)));

        // 测试案例 3
        int[] nums1111 = {1, 1, 1, 1};
        int[] nums2222 = {1, 1};
        System.out.println("交集: " + Arrays.toString(solution.intersect(nums1111, nums2222)));
    }
}
