public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // Key存字母，Item存整数：整数为字母后面一位，目的是记录出现重复字符时，将指针移动到重复字符的后面一位开始下一步扩窗
        // 扩窗过程：try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            // i:前沿指针 J:后沿指针
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
                //当出现重复字母时，i 移动到重复字母后者的后一位
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
