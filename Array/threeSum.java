// https://leetcode-cn.com/problems/3sum/
// leetcode 15

public class Solution {
    /**
     * @param nums : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */

    // 排序 + 双指针的方法
    // 利用2sum作为过渡
    public List<List<Integer>> threeSum(int[] nums) {
        // 要找到所有合适的结果, 不是像2sum一样, 只找到一个即可return, 所以这里是list of list
        List<List<Integer>> results = new ArrayList<>();
        
        if (nums == null || nums.length < 3) {
            return results;
        }
        
        // 排序 关键!!!
        Arrays.sort(nums);

        // 时间复杂度: O(n^2)
        for (int i = 0; i < nums.length; i++) {

            // skip duplicate triples with the same first number
            // 因为已经排过序了, 所以可以这样前后做比较
            // 错误点: 我遗漏了这条, 题目要求: 答案中不可以包含重复的三元组。
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 技巧: i > 0 放在and前面, 避免数组越界情况
                continue;
            }

            // 数组的左右边界
            // 这是个排序的问题, 如果i顺序取了几个数字, 剩下的数字, 只要从i之后开始取就可以了
            int left = i + 1;

            // 错误点: 我忘记 - 1, 就报空指针异常
            int right = nums.length - 1;

            int target = -nums[i];
            
            twoSum(nums, left, right, target, results);
        }
        
        return results;
    }
    
    public void twoSum(int[] nums,
                    int left,
                    int right,
                    int target,
                    List<List<Integer>> results) {
        // 头尾双指针往中间靠的题型
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                ArrayList<Integer> triple = new ArrayList<>();
                //  target == -nums[i] 所以这个其实就是把num[i]存入
                triple.add(-target);
                triple.add(nums[left]);
                triple.add(nums[right]);
                results.add(triple);
                
                // 错误点: 完全忘记相等也要--
                left++;
                right--;

                // optional: 
                // skip duplicate pairs with the same left
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                
                // optional: 
                // skip duplicate pairs with the same right
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        
        // left == right 退出2sum
    }
}

// 时间复杂度 O(n^2)