// https://leetcode-cn.com/problems/longest-palindromic-substring/
// leetcode 5

// 最长回文子串 O(n^2),空间复杂度 (O(n^2))
// 方法三: 动态规划 (区间型动态规划)
public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */

    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return "";
        }

        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        int maxLen = 1;
        int start = 0;
        
        // 为什么要初始化? 因为边边上你套不上这个状态转移方程式, 你需要手动去init 
        // 状态转移方程有 + 1 有 -1, 所以我需要把两个以下的状态先初始化

        // 初始化 一个数字的情况
        // 将长度为 1 的 dp 值设为真
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
        }

        // 初始化 两个数字的情况
        // 考虑前后两个数字, 如果一致, 就是回文
        for (int i = 0; i + 1 < len; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                maxLen = 2;
                start = i;
            }
        }

        // 穷举所有可能性
        for (int left = len - 1; left >= 0; left--) {// 为什么left从大到小, 你要看你依赖的是前面还是后面的?
            for (int right = left + 2; right < len; right++) {// 为什么这里是从+2开始? 因为前后两个 + 1的情况, 已经在line31已经处理完了
                // 动态规划状态转移方程 
                // 从左边 + 1, 右边 - 1是回文串, 然后 左边右边各是回文串

                // 关键点!!!!!
                // 这里的left依赖的是更大的left +1, 所以left应该是从大到小, 先把大的求了, 让你你直接帮助小的数字
                // right 依赖的是更小的right - 1, 所以right可以从小到大, 先把小的求了, 让你帮你求大的
                if (isPalindrome[left + 1][right - 1]
                        && s.charAt(left) == s.charAt(right)) {
                    
                    isPalindrome[left][right] = true;
                    
                    // 打擂台, 更新答案
                    if (right - left + 1 > maxLen) {
                        maxLen = right - left + 1;
                        start = left;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}