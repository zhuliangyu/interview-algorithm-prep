import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
// 数组切分的问题 = 本质上还是组合的问题
public class Solution {

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
        // 注意：只使用 stack 相关的接口
        Deque<String> stack = new ArrayDeque<>();

        // string to charsArray
        char[] charArray = s.toCharArray();

        dfs(charArray, 0, len, stack, res);
        
        return res;
    }

    /**
     * @param charArray
     * @param index     起始字符的索引
     * @param len       字符串 s 的长度，可以设置为全局变量
     * @param path      记录从根结点到叶子结点的路径
     * @param res       记录所有的结果
     */
    private void dfs(
        char[] charArray, 
        int index, // 递归的步进 + 1每次
        int len, // 固定数值, 减少计算的复杂度, 这个是optional的
        Deque<String> path, // 本层记录
        List<List<String>> res // 总结果记录
        ) {

        // 递归结束条件
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            // 因为截取字符串是消耗性能的
            // 所以采用传子串下标的方式判断一个子串是否是回文子串
            if (!checkPalindrome(charArray, index, i)) {
                // 剪枝!!!! 只要判断不是回文, 就不要递归下去了
                // eg.[a, b, a, a]
                // 如果你 [a b, | a, a], ab已经不是回文了, 
                // 后面你再切出回文也没有意义了
                continue;
            }

            // 本层加入一个元素
            path.addLast(new String(charArray, index, i + 1 - index));
            
            // 这个明显是index begin的题型
            // 从下一个index + 1 开始切
            // 第一个index = 0, 1, 2, 3, 4... len
            // 递归后, 进入第二层, index = 1, 2, 3, 4 ... len (没有0了, 因为已经切过了)
            // 再继续进入递归, 进入第三层, index = 2, 3, 4 ... len (没有0 和 1了)
            dfs(charArray, i + 1, len, path, res);
            
            // 本层取消刚加入的元素
            // 类似stack原理, 删除最近进入的那个元素
            path.removeLast();
        }
    }

    /**
     * 这一步的时间复杂度是 O(N)，优化的解法是，先采用动态规划，把回文子串的结果记录在一个表格里
     *
     * @param charArray
     * @param left      子串的左边界，可以取到
     * @param right     子串的右边界，可以取到
     * @return
     */
    private boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// 作者：liweiwei1419
// 链接：https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
// 来源：力扣（LeetCode）
