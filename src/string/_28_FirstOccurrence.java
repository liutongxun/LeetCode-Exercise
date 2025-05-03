package string;

public class _28_FirstOccurrence {


    public int strStr(String haystack, String needle) {
        int haylength = haystack.length();
        int needlelength = needle.length();
        // 如果 haystack 的长度小于 needle，肯定匹配不上
        if (haylength < needlelength)
            return -1;

        // 遍历 haystack 中所有可能的起始位置
        for (int i = 0; i <= haylength - needlelength; i++) {
            int j = 0;
            // 从当前位置 i 开始，一直匹配到 needle 的末尾或出现不等为止
            while (j < needlelength && haystack.charAt(i + j) == needle.charAt(j))
                j++;
            // 如果 j 已经跑完了整个 needle，说明在 i 处完全匹配
            if (j == needlelength) {
                return i;
            }
        }
        // 遍历完所有起点都没找到，返回 -1
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        if(haystack == null || needle.length() == 0 || haystack.length() < needle.length()){
            return -1;
        }
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            boolean matchFound = true;

                for (int j = 0; j < needle.length(); j++){
                    if (haystack.charAt(i + j) != needle.charAt(j)){
                        matchFound = false;
                        break;
                    }
                }

            if (matchFound){
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        _28_FirstOccurrence solution = new _28_FirstOccurrence();

        // 测试用例格式：{haystack, needle, expected}
        String[][] tests = {
                {"hello", "ll", "2"},
                {"aaaaa", "bba", "-1"},
                {"", "", "0"},
                {"", "a", "-1"},
                {"a", "a", "0"},
                {"hello", "", "0"},
                {"mississippi", "issip", "4"},
                {"abc", "c", "2"},
                {"abc", "d", "-1"},
                {"abcabc", "abc", "0"},
                {"abcabc", "cab", "2"}
        };

        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            String haystack = tests[i][0];
            String needle   = tests[i][1];
            int    expect   = Integer.parseInt(tests[i][2]);

            int result = solution.strStr(haystack, needle);
            boolean ok  = result == expect;

            System.out.printf("Test %2d: haystack=\"%s\", needle=\"%s\" → expected=%d, got=%d [%s]%n",
                    i + 1, haystack, needle, expect, result, ok ? "PASS" : "FAIL");

            if (ok) passed++;
        }

        System.out.printf("共 %d 个测试，%d 个通过，%d 个失败。%n",
                tests.length, passed, tests.length - passed);
    }


}
