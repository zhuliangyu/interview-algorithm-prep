// https://leetcode-cn.com/problems/longest-palindromic-substring/
// leetcode 5

// 最长回文子串

// 方法一
// 暴力方法 O(n^3)
public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 0;
        String result = null;
        // 关键: 找不重复的起始点和结束点
        for (int start = 0; start < len; start++) {
            for (int end = start; end < len; end++) {
                // 小优化
                // 排除了比maxLen小的情况了!
                if (end - start + 1 <= maxLen) {
                    continue;
                }
                
                // 如果是回文串的话，更新答案
                if (isPalindrome(s, start, end)) {
                    // 思考这里为什么不需要打擂台: 因为前面的小优化
                    maxLen = end - start + 1;
                    result = s.substring(start, end + 1);
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int start, int end) {
        for (int i = 0; start + i < end - i; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }
}

// 方法二: 中心串回文法
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

        return len;
    }
}

// 方法三: 动态规划 (区间型动态规划)
// 见区间型动态规划文件夹

