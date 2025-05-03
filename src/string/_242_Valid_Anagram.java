package string;

import java.util.HashMap;

public class _242_Valid_Anagram {

    private boolean isAnagram3(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> counterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counterMap.put(c,counterMap.getOrDefault(c,0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!counterMap.containsKey(c) || counterMap.get(c) == 0){
                return false;
            }
            counterMap.put(c,counterMap.get(c) - 1);
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> counterMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            counterMap.put(c, counterMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            Integer cnt = counterMap.get(c);
            if (cnt == null || cnt == 0) {
                return false;
            }
            counterMap.put(c, cnt - 1);
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            count[index]++;

            char b = t.charAt(i);
            int index2 = b - 'a';
            count[index2]--;

//            count[s.charAt(i) - 'a']++;
//            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }


    // 一个简单的辅助函数，用来格式化输出测试结果
    private static void runTest(String s, String t, boolean expected) {
        _242_Valid_Anagram sol = new _242_Valid_Anagram();
        boolean result = sol.isAnagram(s, t);
        System.out.printf("isAnagram(\"%s\", \"%s\") = %s \t[expected: %s]%n",
                s, t, result, expected);
    }



    public static void main(String[] args) {
        // 典型用例
        runTest("anagram", "nagaram", true);
        runTest("rat",     "car",     false);

        // 边界用例
        runTest("",        "",        true);   // 空串互为重组
        runTest("a",       "a",       true);
        runTest("a",       "b",       false);
        runTest("ab",      "a",       false);  // 长度不同

        // 重复字符
        runTest("aaabb",   "ababa",   true);
        runTest("aabbcc",  "abcabc",  true);
        runTest("aabbcc",  "abccba",  true);
        runTest("aabbcc",  "aabbc",   false);

        // 随机测试
        runTest("listen",  "silent",  true);
        runTest("triangle","integral", true);
        runTest("apple",   "papel",   true);
        runTest("apple",   "appel",   true);
        runTest("apple",   "applf",   false);
    }
}
