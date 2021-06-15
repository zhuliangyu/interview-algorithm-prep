// 287. Find the Duplicate Number
// https://leetcode-cn.com/problems/find-the-duplicate-number/

// 1.不能修改数组(假设数组只能读) (不能对数组进行排序)
// 2.只能用额外的O(1)的空间 (不能使用hash算法)
// 3.时间复杂度小于O(n^2)
// 4.数组中只有一个重复的数，但可能重复超过一次

class Solution {

    public int findDuplicate(int[] nums) {
        
        int fast = 0, slow = 0;
        while (true) {
            
            // 链表中：
            // 慢指针 slow = slow.next
            // 快指针 fast = fast.next.next
            // 数组中：
            // 慢指针 slow = nums[slow]；
            // 快指针 fast = nums[nums[fast]]，因为 nums 中的元素值都在 1 到 n 之间（包括 1 和 n），所以这样不会造成数组越界问题。

            slow = nums[slow];
            
            // 非常牛B的想法
            fast = nums[nums[fast]];

            // 指针相遇
            if (slow == fast) {

                fast = 0;
                while (nums[slow] != nums[fast]) {
                    
                    // slow 和 fast 指针的速度相同
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return nums[slow];
            }
        }
    }
}
