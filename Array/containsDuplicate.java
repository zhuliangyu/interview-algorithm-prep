// https://leetcode-cn.com/problems/contains-duplicate/

// leetcode 217

// 先排序, 然后前后比一下
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // 错误点, 携程Array, 而不是Arrays
        Arrays.sort(nums);

        // 避免把算长度放在for循环里面, 否则每次循环都在算
        int n = nums.length;

        // 当你比较数组内前后两个元素的时候
        // 错误点: 注意这里不是n ,而是n-1, 否则会数组越界!!一定要小心
        for (int i = 0; i < n - 1; i++) {
            // 前后比
            if (nums[i] == nums[i + 1]) {
                return true;
            } else {
                //什么也不做, 直接去下一个循环
            }
        }
        return false;
    }
}
