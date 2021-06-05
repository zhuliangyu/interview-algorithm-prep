// https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
// Leetcode 104


// traverse 版本
class Solution {

    // 错误点: 这里我把max当做参数传入递归, 这个是错误的, 因为max必须只能维护一个值
    // 小本子, 最终结果的记录
    private int max = 0;

    public int maxDepth(TreeNode root) {

        // 错误点!! 这个必修是全局变量; 不能放在这里
        //int max = 0;

        int curr = 0;
        help(root, curr);

        return max;
    }

    private void help(TreeNode root, int curr) {
        
        // 递归出口
        if (root == null) {
            return;
        }
        // 本层需要做的事情
        curr += 1;
        if (curr > max) {
            max = curr;
        }

        help(root.left, curr);
        // 这个是错误的写法, 这个max只能看到这个分支上的最大值, 是不正确的
        //help(root.left, curr, max);
        
        help(root.right, curr);
    }
}

// 分治版本
// 尽量写这个分治的版本, 因为简单
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}