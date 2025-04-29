package array;

import java.util.*;

public class _49_GroupAnagrams {



    private List<List<String>> groupAnagrams(String[] inputStrs) {

        if (inputStrs == null ){
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : inputStrs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }




    public static void main(String[] args) {
        _49_GroupAnagrams solution = new _49_GroupAnagrams();

        // 测试用例 1
        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = solution.groupAnagrams(input1);
        System.out.println("Test 1 input:  " + Arrays.toString(input1));
        System.out.println("Test 1 output: " + listOfListsToString(result1));
        System.out.println();

        // 测试用例 2：包含空串和单字符
        String[] input2 = {"", "b", "", "bb", "b"};
        List<List<String>> result2 = solution.groupAnagrams(input2);
        System.out.println("Test 2 input:  " + Arrays.toString(input2));
        System.out.println("Test 2 output: " + listOfListsToString(result2));
        System.out.println();

        // 测试用例 3：所有字符串不同
        String[] input3 = {"abc", "def", "ghi"};
        List<List<String>> result3 = solution.groupAnagrams(input3);
        System.out.println("Test 3 input:  " + Arrays.toString(input3));
        System.out.println("Test 3 output: " + listOfListsToString(result3));
        System.out.println();

        // 测试用例 4：所有字符串相同
        String[] input4 = {"zzz", "zzz", "zzz"};
        List<List<String>> result4 = solution.groupAnagrams(input4);
        System.out.println("Test 4 input:  " + Arrays.toString(input4));
        System.out.println("Test 4 output: " + listOfListsToString(result4));
    }

    // 将 List<List<String>> 格式化为易读的字符串
    private static String listOfListsToString(List<List<String>> groups) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (List<String> group : groups) {
            sb.append("  ").append(group).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
