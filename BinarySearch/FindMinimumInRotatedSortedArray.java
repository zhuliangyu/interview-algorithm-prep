// https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/

public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */


    // 寻找旋转排序数组中的最小值
    // find the first item < last item
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            // 这题并没有一个target让我去找, 所以没有 if (target == nums[mid])的语句
            // 只是不停的改变start 和 end的指针
            // 最终离开这个while循环语句
            
            // 解题关键: 寻找第一个index <= 最后一个元素
            if (nums[mid] <= nums[end]) {
                // 满足条件, 因为是找第一个, 赋值end, 继续找
                end = mid;
                
            } else {
                // 取反即可!, 不用管理由
                start = mid;
            }
        }
        
        // 两个指针内的数据, 我比较一下, 到底哪个更小
        return Math.min(nums[start], nums[end]);
    }
}