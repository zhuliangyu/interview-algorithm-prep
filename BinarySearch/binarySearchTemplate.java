public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0; 
        int end = nums.length - 1;

        // 相邻就退出, start == 1, end == 2 就退出
        // 出while循环之后, 这样会留下两个值, 去比较
        while (start + 1 < end) {
            // 防止溢出
            // int mid = (start + end) / 2;
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                // 刚好找到
                return mid;
            } else if ( target > nums[mid]) {
                // 在右半部分
                start = mid;
            } else {
                // 在左半部分
                end = mid;
            }
        }
        
        // 比两次
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }

        // 没找到
        return -1;
    }
}