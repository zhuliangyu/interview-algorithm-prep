public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */

    // Array + 同向双指针的题目
    // 1. 确认两个指针目的(一个是写入用, 一个是traverse用)
    // 2. 确认两个指针移动的规则, 什么时候++
    // 3. 考虑指针越界的情况
    public void moveZeroes(int[] nums) {
        // 确认两个指针各自的目的是什么
        // left指针是写入针
        // right指针是traverse指针
        int left = 0, right = 0;
        
        // traverse指针不越界 
        while (right < nums.length) {

            if (nums[right] != 0) {
                if (left != right) {
                    // 非swap, 是直接赋值
                    nums[left] = nums[right];
                }
                // 关键点: 什么时候移动写入指针?
                // 当写入完成之后
                left++;
            }
            // 关键点: 什么时候移动traverse指针? 
            right++;
        }

        // 之后所有的数组, 用0补齐
        while (left < nums.length) {
            if (nums[left] != 0) {
                nums[left] = 0;
            }
            left++;
        }
    }
}