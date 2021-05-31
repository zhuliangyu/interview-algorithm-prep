// https://leetcode-cn.com/problems/contains-duplicate/
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        
        for (int x : nums) {
            // 判断如何能存进去!!!
            if (!set.add(x)) {
                return true;
            }
        }
        
        return false;
    }
}
