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

