// https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
// leetcode 103

public class Solution
{
    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        //正反向标志
        boolean isForward = true;

        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subList = new ArrayList<Integer>();
            for (int i = 0 ; i < size ; i++) {
                TreeNode treeNode = q.poll();
                subList.add(treeNode.val);
                if (treeNode.left != null) { 
                    q.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    q.offer(treeNode.right);
                }
            }


            //根据标志来确认当前层遍历的方向
            if (!isForward) {
                // 错误点: Collection忘记加复数
                Collections.reverse(subList);//翻转
            }
            //方向反转
            isForward = !isForward;
        
        
            ans.add(subList);

        }
        return ans;
    }
}