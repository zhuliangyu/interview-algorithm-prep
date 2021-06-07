// https://leetcode-cn.com/problems/coin-change/
// leetcode 322

// 完全背包问题
// 不考虑排列顺序的完全背包问题
public class Solution {
    public int coinChange(int[] coins, int amount) {
        // 思考这里为什么要 + 1
        // 因为后面无论你怎么减, amount + 1 都是一个不可能达到的数字
        // 这里其实就是一个作为判断的条件, 这个值判断一下是否完全没有被碰过
        // 如果被计算过, 肯定不可能是amount + 1

        // 因为必须要取到dp[amount], 所以要建amount + 1个元素
        int[] dp = new int[amount + 1];
        
        // dp初始值给了一个不可能达到的值
        // dp的value是计算之后放的是target最小硬币数量 (题目中要求的数值)
        // dp的index代表每一步的金额
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // base case
        dp[0] = 0;
        
        // 错误点: 不是 i < amount
        // 为什么i从1开始而不是0? 因为do[0]已经是初始值了, 只能从1开始
        for (int i = 1; i <= amount; i++) { // 所有钱的可能性, 头是1, 尾巴是amount, 减数
            for (int j = 0; j < coins.length; j++) {// 所有硬币的可能性, 被减数
                if (coins[j] <= i) { // amount 足够扣钱
                    // 打擂台, 所有硬币的可能性取最小
                    // dp的index代表的是每一步的金额
                    // dp的value代表的是最少可用的硬币数量
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        // == Max 说明 amount这个值没有计算结果, 还是初始值Max
        // 说明硬币根本凑不到amount这个数字
        // return dp[amount] == max ? -1 : dp[amount];
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
