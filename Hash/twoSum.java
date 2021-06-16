// https://leetcode-cn.com/problems/two-sum/
// leetcode 1

// hash解法
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // key == 目标的反数 (要寻找的) 
        // value == 目标 index
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();

        // 枚举法
        for (int i = 0; i < nums.length; ++i) {
            // 易错点: 先找再存, 想想为什么不能先存后找? 
            // 反例: [2, 4, 8] target = 8 
            // 你先存进4, 你再去找 8 - 4 的时候, 咦, 找到了!! 但是这个是错的, 是刚存进去的, 不是之前的!
            
            // 明确我要找的目标, 反向的
            if (hashtable.containsKey(target - nums[i])) {
                // 只要找到1对即可, 就可以return

                // 错误点: new int[2]{1, 2} 是错的, new int[]{1, 2}才是对的
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            
            // 本次数值存入
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}

// 双指针的算法, 见two pointers 文件夹

