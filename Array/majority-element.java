// https://leetcode-cn.com/problems/majority-element/
// leetcode 169

// 方法一： 排序
// 因为答案占了一般多，排序一下，直接返回中间位置就是答案了。
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

// 方法二： Map
// 遍历一遍数组：key表示数组中的某个数，value表示该数出现了几次，当统计到某数出现的次数大于数组一半时返回该数。
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> ant = new HashMap<>();
        for(int num : nums){
            // 背诵!!!
            ant.put(num, ant.getOrDefault(num, 0) + 1);
            
            if(ant.get(num) > nums.length / 2) return num;
        }
        return 0;
    }
}
