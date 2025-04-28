package array;

public class _283_MoveZeroes {

    private int[] moveZeros2(int[] nums1) {
        if (nums1.length < 2){
            return nums1;
        }

        int left = 0 ;
        int right = 1;

        while (right < nums1.length){
            if (nums1[left] != 0){
                left++;
                right++;
            }else {
                if (nums1[right] == 0){
                    right++;
                }else {
                    nums1[left] = nums1[right];
                    nums1[right] = 0;
                    left++;
                    right++;
                }
            }
        }
        return nums1;
    }

    private int[] moveZeros(int[] nums1) {
        if (nums1.length < 2){
            return nums1;
        }

        int left = 0 ;
        for (int right = 0; right < nums1.length; right++){
            if(nums1[right] != 0){
                int temp = nums1[right];
                nums1[right] = nums1[left];
                nums1[left] = temp;
                left++;
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        _283_MoveZeroes test = new _283_MoveZeroes();

        // 测试案例 1
        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.println("Test Case 1: ");
        printArray(test.moveZeros(nums1));  // 预期输出 [1, 3, 12, 0, 0]

        // 测试案例 2
        int[] nums2 = {0, 0, 1, 3, 0, 2};
        System.out.println("Test Case 2: ");
        printArray(test.moveZeros(nums2));  // 预期输出 [1, 3, 2, 0, 0, 0]

        // 测试案例 3
        int[] nums3 = {0, 0, 0, 1, 2, 3};
        System.out.println("Test Case 3: ");
        printArray(test.moveZeros(nums3));  // 预期输出 [1, 2, 3, 0, 0, 0]

        // 测试案例 4
        int[] nums4 = {0, 0, 0, 0, 0};
        System.out.println("Test Case 4: ");
        printArray(test.moveZeros(nums4));  // 预期输出 [0, 0, 0, 0, 0]

        // 测试案例 5
        int[] nums5 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 5: ");
        printArray(test.moveZeros(nums5));  // 预期输出 [1, 2, 3, 4, 5]

        // 测试案例 6
        int[] nums6 = {0};
        System.out.println("Test Case 6: ");
        printArray(test.moveZeros(nums6));  // 预期输出 [0]
    }



    // 打印数组的方法
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}
