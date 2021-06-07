// https://leetcode-cn.com/problems/climbing-stairs/
// leetcode 70

class Solution {
    public int climbStairs(int n) {
        // 创建dp记录本
        int[] dp = new int[n + 1];

        // base case
        dp[0] = 1;
        dp[1] = 1;

        // i从2开始, 防止越界, i - 1, i - 2
        for(int i = 2; i < n + 1; i++) {
            // 动态转移方程
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
