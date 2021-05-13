// https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/


//  全排列
//  最关键, 先画出tree的图
//  递归的步进: 是index begin的题型? 是used题型? 
public class Solution {

/* 主函数，输入一组不重复的数字，返回它们的全排列 */
List<List<Integer>> permute(int[] nums) {

    // 最终结果
    List<List<Integer>> res = new LinkedList<>();

    // 记录「路径」临时的结果
    List<Integer> track = new LinkedList<>();

    backtrack(nums, track, res);
    return res;
}

// 路径：记录在 track 中
// 选择列表：nums 中不存在于 track 的那些元素
// 结束条件：nums 中的元素全都在 track 中出现
void backtrack(
    int[] nums, 
    List<Integer> track, // 包含已经选过的数字 = USED的用途题型, 这个是递归的步进
    List<List<Integer>> res // 最终结果
    ) {
    
    // 触发递归的结束条件
    if (track.size() == nums.length) {
        res.add(new LinkedList(track));
        return;
    }
    
    for (int i = 0; i < nums.length; i++) {
        // 虽然每次递归都是从0开始选, 但是如果已经在track已经选过的数字
        // 就不能再选了, 这个就是这个算法最妙的地方, 所以可以选择的数字越来越小
        
        // 排除不合法的选择
        // 不可以重复选择, 只要选过了(在track里面的)就不能再选了
        // 全排列这里明显是used的题型
        if (track.contains(nums[i])) {
            continue;
        }

        // 做选择
        track.add(nums[i]);

        // 进入下一层决策树
        // 递归的步进就是track里面的元素
        // 所以这个的步进并没有 index + 1之类的
        backtrack(nums, track, res);

        // 取消选择
        track.removeLast();
    }
}

}