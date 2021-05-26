public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */

    // 二分法, 找第一个元素
    public int findFirstPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0; 
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                // 这个地方是和模板不同的部分!!!!!!
                // 你找到第一个, 不能return, 必须要把这个当做end再继续找
                // 有可能end之前再没有了, end就是第一个
                // 如果end 之前还有, end就被替换更前面的index
                end = mid;
            } else if ( target > nums[mid]) {
                // [start........mid.......target....end]
                // [............start......target....end]
                // target 在右半部分
                start = mid;
            } else {
                // target 在左半部分
                end = mid;
            }
        }
        
        // 比两次

        // 如果start有, start肯定是第一个元素, 所以先返回
        if (nums[start] == target) {
            return start;
        }
        // 如果start没有我想要的, end肯定有一个保底 
        if (nums[end] == target) {
            return end;
        }

        // 没找到
        return -1;
    }
}