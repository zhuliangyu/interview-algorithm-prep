// leetcode 102
// https://leetcode-cn.com/problems/binary-tree-level-order-traversal/

// 数据结构: Tree + BFS
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        // 记录总结果
        List<List<Integer>> result = new ArrayList<>();

        // 错误点: 自己没有加上这条防护
        if (root == null) {
            return result;
        }

        // 错误点: 不是ArrayList, 而是LinkedList
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        // 把root压入队尾, 爆炸的引子
        queue.offer(root);

       // 记住结构: 有两个循环, 外面是while循环, 里面是for循环
       // 有三个结果, 一个level层级结果, 一个result总结果, 最后一个是queue
        while (!queue.isEmpty()) {

            // 本层临时的记录
            List<Integer> level = new ArrayList<Integer>();
            
            // 本层元素的数量
            // 错误点: 忘记这个size怎么算
            int size = queue.size();
            
            // 第二重循环: 在本层数量里面循环
            // 因为这个程序必须精确到每一层该做什么
            for (int i = 0; i < size; i++) {
                
                // 取queue头 -- root
                TreeNode currNode = queue.remove();
                
                // 本层记录加入
                // 错误点: 需要有两个加入, 一个加入level, 一个加入是queue
                level.add(currNode.val);
                
                // for 节点 in cur的所有相邻节点：
                // if 该节点有效且未被访问过：
                if (currNode.left != null) {
                    // 下一层node加入
                    queue.add(currNode.left);
                }
                
                // if 该节点有效且未被访问过：
                if (currNode.right != null) {
                    // 下一层node加入
                    queue.add(currNode.right);
                }
            }

            // eg. [[1],[2,3]] 
            // result is list of list
            // level is a list
            // 把本层的临时数据记录进总结果中
            result.add(level);

            // 接下来进入下一层
            // level ++
        }

        return result;
    }
}