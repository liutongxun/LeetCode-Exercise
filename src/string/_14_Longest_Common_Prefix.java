package string;

public class _14_Longest_Common_Prefix {

    private String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }

        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            String tempPrefix = "";

            int loopLen = Math.min(prefix.length(), strs[i].length());
            for(int j = 0; j < loopLen; j++){
                if(prefix.charAt(j) == strs[i].charAt(j)){
                    tempPrefix += strs[i].charAt(j);
                }else {
                    break;
                }
            }
            prefix = tempPrefix;
        }
        return prefix;
    }


    private String longestCommonPrefix2(String[] strs) {

        if (strs == null || strs.length == 0){
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){

            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        _14_Longest_Common_Prefix solution = new _14_Longest_Common_Prefix();

        // 测试用例格式：{输入数组, 预期输出}
        Object[][] tests = {
                {new String[]{"flower", "flow", "flight"}, "fl"},
                {new String[]{"dog", "racecar", "car"}, ""},
                {new String[]{"interview", "internet", "international"}, "inter"},
                {new String[]{"apple", "applet", "application"}, "appl"},
                {new String[]{"a", "b", "c"}, ""},
                {new String[]{"a"}, "a"},
                {new String[]{}, ""},  // 边界情况：空数组
                {new String[]{"same", "same", "same"}, "same"},  // 所有字符串都相同
                {new String[]{"longest", "long", "lon"}, "lon"}  // 最长公共前缀是前缀的一部分
        };

        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            String[] strs = (String[]) tests[i][0];
            String expected = (String) tests[i][1];

            String result = solution.longestCommonPrefix(strs);
            boolean ok = result.equals(expected);

            System.out.printf("Test %2d: strs=%s → expected=%s, got=%s [%s]%n",
                    i + 1, java.util.Arrays.toString(strs), expected, result, ok ? "PASS" : "FAIL");

            if (ok) passed++;
        }

        System.out.printf("共 %d 个测试，%d 个通过，%d 个失败。%n",
                tests.length, passed, tests.length - passed);
    }


}
