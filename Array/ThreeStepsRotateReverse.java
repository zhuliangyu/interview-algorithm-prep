// https://leetcode-cn.com/problems/rotate-array/
// leetcode 189

// 图解: https://leetcode-cn.com/problems/rotate-array/solution/shu-zu-fan-zhuan-xuan-zhuan-shu-zu-by-de-5937/
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        // 三步翻转法

        // 全翻转
        reverse(nums, 0, nums.length - 1);
        // 翻转左边
        reverse(nums, 0, k - 1);
        // 翻转右边
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start += 1;
            end -= 1;
        }
    }

    private void swap([] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}

