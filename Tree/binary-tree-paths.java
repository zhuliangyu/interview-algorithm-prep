// https://leetcode-cn.com/problems/binary-tree-paths/solution/
// https://www.jiuzhang.com/solution/binary-tree-paths/
// leetcode 257

// traverse 版本
class Solution {
    // 全局变量小本子
    private List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return list;
        
        // 中间结果值
        // 单个分支上的结果
        String str = new String();
        
        preOrder(root , str);
        
        return list;
    }

    // help方法, 返回值是void
    // str是中间返回值
    public void preOrder(TreeNode root , String str){
        // 在最后一层需要做的事情
        // 递归结束条件, 这个就是套路, 背上
        if (root == null) {
            return;
        }

        // ----------------- 在这一层要做的事情 --------------------
        if (root.left == null && root.right == null){
            // 关键点: 判断叶子节点, 这个是新增的部分
            str += root.val;

            // 关键点: 把结果加入List中
            list.add(str);
        } else {
             // 不是叶子节点, 这一层该做的事情
            str += root.val + "->";
        }

        // ----------------- 在这一层要做的事情 --------------------


        // 带着中间值, 进入下一层左右分支
        preOrder(root.left , str);
        preOrder(root.right , str);
    }
}

// 分治法
public class Solution {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // 不用是全局变量
        List<String> paths = new ArrayList<>();
        
        // 套路关于null
        if (root == null) {
            // return new ArrayList<>()
            return paths;
        }

        
        // divide
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        // conquer
        // root.val == 1
        // [2 ->  5] -> [1 -> 2 ->  5]

        // 如果有左右分支的情况
        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }
        // [3] -> [1 -> 3]
        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }
        
        // 如果没有左右分支, 怎么办? 判断root is a leaf
        if (root.left == null && root.right == null) {
            // 让value从int变成string, 所以用加法
            paths.add("" + root.val);
        }

        // 套路
        return paths;
    }
}