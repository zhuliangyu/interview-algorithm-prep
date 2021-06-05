// https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
// 图解在上面的链接里
// leetcode 46

//  全排列 = traverse
//  最关键, 先画出tree的图
//  递归的步进: 是index begin的题型? 是used题型? 
public class Solution {
    // 最终结果. 全局的小本本, 可以供各种递归使用
    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {

        // 记录「路径」临时的结果, 单个分支上的结果
        List<Integer> track = new LinkedList<>();

        backtrack(nums, track);
        return res;
    }

    // traverse的方法, 小人带着小本子进入每一层
    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(
        int[] nums, 
        List<Integer> track // 包含已经选过的数字 = USED的用途题型, 这个是递归的步进
        ) {
        
        // 触发递归的结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
        
        // 小人带着小本子, 在这一层要做的事情, 要选择这一层所有可能的元素
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
            // 小人带着小本子, 选择这一层的第一个元素
            track.add(nums[i]);

            // 进入下一层决策树
            // 递归的步进就是track里面的元素
            // 所以这个的步进并没有 index + 1之类的
            backtrack(nums, track);

            // 取消选择
            // 小人带着小本子, 撤销第一个元素, 然后进入下一个循环, 选择第二个元素
            // track.removeLast();
            track.remove(track.size() - 1);
        }
    }

}