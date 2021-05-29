public class Solution {
    /**
     * @param nums: An integer array.
     * @return: The second max number in the array.
     */

    public int secondMax(int[] nums) {

        // 设置老大和老二初始值
        // 求最大设最小
        int max = Integer.MIN_VALUE;
        // 思考: 为什么老二要设最大???
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
                
            } else if (nums[i] > second) {
                // 肯定是大于老二, 但是一定会小于老大的情况

                // 老二位置被夺走
                second = nums[i];
                // 老大一切照旧
                // max 不变

            }
        }
        
        return second;
    }
}