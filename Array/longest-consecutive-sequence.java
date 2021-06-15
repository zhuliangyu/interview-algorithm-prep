// https://leetcode-cn.com/problems/longest-consecutive-sequence/
// leetcode 128

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            
            int down = nums[i] - 1;
            while (set.contains(down)) {
                // 找到自己最down的部分
                set.remove(down);
                down--;
            }
            
            int up = nums[i] + 1;
            while (set.contains(up)) {
                // 找到自己最up的部分
                set.remove(up);
                up++;
            }

            // 打擂台
            longest = Math.max(longest, up - down - 1);
        }
        
        return longest;
    }
}
