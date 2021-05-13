// 链接：https://leetcode-cn.com/problems/subsets/solution/hui-su-suan-fa-by-powcai-5/

// 这个是数组-组合问题
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // 小本子记录总结果
        List<List<Integer>> res = new ArrayList<>();
        
        backtrack(0, nums, res, new ArrayList<Integer>());
        
        return res;

    }

    // DFS递归 + traverse(带小本子) + 回溯
    private void backtrack(
        int start, // 数组的index, 递归运行到哪个index
        int[] nums, // 原始数组
        List<List<Integer>> res, // 全部的结果 -- 全部结果的小本子记录
        ArrayList<Integer> tmp // 本行的结果 -- 本行结果的小本子
        ) {
        
        /**
        * @param nums: A set of numbers
        * @param nums: A set of numbers
        * @return: A list of lists
        */

        // 此题非常特殊，所有路径都应该加入结果集，所以不存在结束条件。
        // 或者说当 start 参数越过数组边界的时候，程序就自己跳过下一层递归了
        // 因此不需要手写结束条件,直接加入结果集

        // 记录总结果集
        res.add(new ArrayList<>(tmp));

        
        // for循环做选择, 关键找到选项!!!!
        // 为避免重复, 每次选择, 只能选择从start开始之后的数组的元素
        // 组合的问题, 这个是一般是index begin的题型
        for (int j = start; j < nums.length; j++) {
            
            // 本层先选择一个, 在结果加入一个元素
            // 记录本层结果集
            tmp.add(nums[j]);
            
            // 递归进入下一层
            // 递归步进: start起始点 + 1
            // + 1的原因是这个元素用过了, 之后就不能用了
            // 而且为了避免重复, 只能用从这个元素之后的组合, 这个元素之前的都不能用了
            backtrack(j + 1, nums, res, tmp);
            // 当运行到这行, 本层之后的下一层都的路径已经完整记录到小本子里面去了

            // 本层撤销选择, 删除最后一个加入的元素
            // 撤销本层结果集
            tmp.remove(tmp.size() - 1);
            // 进入下一个for循环, 本层选择另外一个元素....
        }

        // 递归的结束条件: 
        //   跳出for循环, 表示start >= nums.length的时候
        //   这个函数并不会无限的递归调用下去
    }
}

// 作者：powcai
// 链接：https://leetcode-cn.com/problems/subsets/solution/hui-su-suan-fa-by-powcai-5/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。