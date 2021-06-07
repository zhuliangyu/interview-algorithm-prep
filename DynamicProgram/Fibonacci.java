// https://leetcode-cn.com/problems/fibonacci-number/
// leetcode 509

class Solution {
    public int fib(int n) {
        // edge cases
        if (n == 0) return 0;
        if (n <= 2) return 1;


        // 第n个数, 因为从0开始, 所以要n + 1个元素
        int[] dp = new int[n + 1];
        
        // base case
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
