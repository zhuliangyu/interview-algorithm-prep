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
        List<List<Integer>> results = new ArrayList<>();
        
        if (nums == null || nums.length < 3) {
            return results;
        }
        
        Arrays.sort(nums);

        // 时间复杂度: O(n^2)
        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicate triples with the same first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                // i > 0 避免不够减的情况发生
                continue;
            }

            // 数组的左右边界
            // 这是个排序的问题, 如果i顺序取了几个数字, 剩下的数字, 只要从i之后开始取就可以了
            int left = i + 1;
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
        // 头尾双指针往中间靠
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                ArrayList<Integer> triple = new ArrayList<>();
                //  target == -nums[i] 所以这个其实就是把num[i]存入
                triple.add(-target);
                triple.add(nums[left]);
                triple.add(nums[right]);
                results.add(triple);
                
                left++;
                right--;

                // skip duplicate pairs with the same left
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                
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