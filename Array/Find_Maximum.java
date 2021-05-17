public class Solution {
    /**
     * @param nums: the list of numbers
     * @return: return the maximum number.
     */

    // 第一个版本: 递归版本
    public int maxNum(List<Integer> nums) {
        return maxNum(nums, 0, nums.size() - 1);
    }

    private int maxNum(List<Integer> nums, int start, int end) {
        // 递归结束条件
        if (start > end) {
            return Integer.MIN_VALUE;
        }

        return Math.max(nums.get(start), maxNum(nums, start + 1, end));
    }
}

// 第二个版本, 打擂台的版本. 