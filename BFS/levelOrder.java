public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        // 记录总结果
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        // 把root压入队尾, 爆炸的引子
        queue.offer(root);

        while (!queue.isEmpty()) {

            // 本层临时的记录
            ArrayList<Integer> level = new ArrayList<Integer>();
            
            // 本层元素的数量
            int size = queue.size();
            
            // 第二重循环: 在本层数量里面循环
            // 因为这个程序必须精确到每一层该做什么
            for (int i = 0; i < size; i++) {
                
                // 取queue头 -- root
                TreeNode head = queue.poll();
                
                // 本层记录加入
                level.add(head.val);
                
                //////////////////////////////////
                // for 节点 in cur的所有相邻节点：
                if (head.left != null) {
                    // 下一层node加入
                    queue.offer(head.left);
                }
                
                if (head.right != null) {
                    // 下一层node加入
                    queue.offer(head.right);
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