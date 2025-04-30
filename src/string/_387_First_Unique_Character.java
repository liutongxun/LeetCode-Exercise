package string;

import java.util.HashMap;

public class _387_First_Unique_Character {


    private static int firstUniqCharHashMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1){
                return i;
            }
        }
        return -1;
    }


    public static int firstUniqChar(String s) {
        int[] count = new int[26];          // 全为 0
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    // 运行若干测试用例
    public static void main(String[] args) {
        String[] tests = {
                "leetcode",
                "loveleetcode",
                "aabb",
                "abcabcx",
                "",
                "z"
        };
        System.out.printf("%-15s  %-8s  %-8s%n", "输入", "HashMap", "Array");
        System.out.println("---------------  --------  --------");
        for (String s : tests) {
            int idx1 = firstUniqCharHashMap(s);
            int idx2 = firstUniqChar(s);
            System.out.printf("%-15s  %-8d  %-8d%n", "\"" + s + "\"",idx1, idx2);
        }
    }

}


