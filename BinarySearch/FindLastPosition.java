public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */

    // 二分法, 找最后一个元素
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
                // 你找到第一个, 不能return, 必须要把这个当做start再继续找
                // 因为我们这里找的是最后一个元素, 所以这里不能停
                start = mid;
            } else if ( target > nums[mid]) {
                // [start........mid.......target....end]
                // [............start......target....end]
                // 在右半部分
                start = mid;
            } else {
                // 在左半部分
                end = mid;
            }
        }
        
        // 比两次, 这个顺序发生了变化
        // 因为这里我们是找最后一个元素, 先从end开始找起
        if (nums[end] == target) {
            return end;
        }

        // 之后才去找start
        if (nums[start] == target) {
            return start;
        }

        // 没找到
        return -1;
    }
}