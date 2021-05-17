public class Solution {
    /**
     * @param nums: An integer array.
     * @return: The second max number in the array.
     */

    public int secondMax(int[] nums) {

        // 设置老大和老二初始值
        int max = Integer.MIN_VALUE;
        int second = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            // 两种情况分别处理

            // > max, 肯定>second
            if (nums[i] > max) {
                // 老大位置被夺走

                // 关键点: 先处理老二, 然后再处理老大
                // 如果先覆盖了老大, 前老大就丢失了, 老二就无法找到了

                // 前老大顺位老二
                second = max;
                // 新老大上位
                max = nums[i];
                
                // 肯定是 > second, 但是< max
            } else if (nums[i] > second) {
                // 老二位置被夺走
                second = nums[i];
                // 老大一切照旧
                // max 不变

            }
        }
        
        return second;
    }
}