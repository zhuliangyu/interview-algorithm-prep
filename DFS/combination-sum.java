// version 1: Remove duplicates & generate a new array
public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return results;
        }

        // 排序 + 去重
        int[] nums = removeDuplicates(candidates);

        dfs(nums, 0, new ArrayList<Integer>(), target, results);

        return results;
    }

    private void dfs(int[] nums,
                     int startIndex,
                     List<Integer> combination,
                     int remainTarget,
                     List<List<Integer>> results) {

        // 递归结束
        if (remainTarget == 0) {
            results.add(new ArrayList<Integer>(combination));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {

            // 剪枝
            // 这个必须是排序之后的才可以这样剪枝
            // 因为我们是从最小开始往大了排序, 如果本身这个元素已经比剩余target小的, 之后更大的元素就不用考虑了
            if (remainTarget < nums[i]) {
                break;
            }

            combination.add(nums[i]);
            
            // 递归步进: remainTarget - nums[i]
            // index begin 并没有 + 1, 因为是可以重复使用同一个数字
            // 但是for 循环时候只能用这个元素之后的元素, 不能用之前的
            dfs(nums, i, combination, remainTarget - nums[i], results);

            // 回溯, 删除最后一个记录
            combination.remove(combination.size() - 1);
        }
    }

    private int[] removeDuplicates(int[] candidates) {
        Arrays.sort(candidates);

        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                candidates[++index] = candidates[i];
            }
        }

        // 重新复制一个不带重复数据的数组
        int[] nums = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            nums[i] = candidates[i];
        }

        return nums;
    }
}