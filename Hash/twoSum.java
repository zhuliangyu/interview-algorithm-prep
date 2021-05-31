// https://leetcode-cn.com/problems/two-sum/
// leetcode 1

// hash解法
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // key == 目标的反数 (要寻找的) 
        // value == 目标 index
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            // 找key
            if (hashtable.containsKey(target - nums[i])) {
                // 只要找到1对即可, 就可以return
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}

