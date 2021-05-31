// https://leetcode-cn.com/problems/contains-duplicat

// leetcode 217

// 先排序
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            } else {
                //什么也不做, 直接去下一个循环
            }
        }
        return false;
    }
}
