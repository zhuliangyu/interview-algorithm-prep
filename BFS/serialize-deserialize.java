/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }

        // bfs 结果存储数组
        List<TreeNode> nodes = new ArrayList<>();

        // bfs 过度工具
        Queue<TreeNode> queue = new LinkedList<>();
        
        // 宽度优先搜索获得BFS序
        queue.add(root);
        while (! queue.isEmpty()) {
            TreeNode node = queue.poll();

            // node could be null
            nodes.add(node);
            
            if (node == null) {
                // 不需要继续下去了, stop
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        // 清除最后的null
        // [1, 2, nul, null, 3, null, null], 清除最后的null, 没有意义
        while (nodes.get(nodes.size() - 1) == null) {
            nodes.remove(nodes.size() - 1);
        }

        // 将BFS序序列化数组转成字符串
        StringBuffer result = new StringBuffer();
        result.append("{");
        for (int i = 0; i < nodes.size(); i++) {
            if (i > 0) {
                result.append(",");
            }
            if (nodes.get(i) == null) {
                result.append("#");
            }
            else {
                result.append(Integer.toString(nodes.get(i).val));
            }
        }
        result.append("}");
        return result.toString();
    }