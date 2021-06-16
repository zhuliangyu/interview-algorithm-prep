// https://leetcode-cn.com/problems/longest-palindromic-substring/
// leetcode 5

// 最长回文子串

// 方法二: 中心串回文法 (背向双指针!) n^2时间复杂度
public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // longest不能用全局变量, 这是不好的习惯
        int start = 0, len = 0, longest = 0;
        for (int i = 0; i < s.length(); i++) {

            // 奇数情况, 只要考虑中心点, 往两边扩散即可
            len = findLongestPalindromeFrom(s, i, i);
            if (len > longest) { // 打擂台
                longest = len;
                start = i - len / 2; // 记录回文的起始点
            }

            // 偶数情况, 考虑中心2个点, 然后两边扩散
            len = findLongestPalindromeFrom(s, i, i + 1); 
            if (len > longest) {
                longest = len;
                start = i - len / 2 + 1;
            }
        }

        // 回文起点: start
        // 回文终点: start + longest
        return s.substring(start, start + longest);
    }

    private int findLongestPalindromeFrom(String s, int left, int right) {
        int len = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            // 如果左边==右边, 这个表示只有1个字符, 回文串len + 1
            // 如果左边不等于右边, 这个表示aba, 回文串len + 2, 一左一右
            len += (left == right ? 1 : 2);
            left--;
            right++;
        }

        // 跳出while的限制
        // 或者left < 0, 或者 right == s.length() 
        return len;
    }
}