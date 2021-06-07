// https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
// leetcode 297

// 图解
// https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/shou-hui-tu-jie-gei-chu-dfshe-bfsliang-chong-jie-f/
public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "X,";

            // divide
            String leftSerialize = serialize(root.left); //左子树的序列化字符串
            String rightSerialize = serialize(root.right); //右子树的序列化字符串
            
            // conquer
            return root.val + "," + leftSerialize + rightSerialize;
        }

        // Decodes your encoded data to tree.
        /**
         * 构建树的函数 buildTree 接收的 “状态” 是 list 数组，由序列化字符串转成
         * 按照前序遍历的顺序：先构建根节点，再构建左子树、右子树
         * 将 list 数组的首项弹出，它是当前子树的 root 节点
         * 如果它为 'X' ，返回 null
         * 如果它不为 'X'，则为它创建节点，并递归调用 buildTree 构建左右子树，当前子树构建完毕，向上返回
         */
        public TreeNode deserialize(String data) {
            String[] temp = data.split(",");
            Deque<String> dp = new LinkedList<>(Arrays.asList(temp));
            return buildTree(dp);
        }
        private TreeNode buildTree(Deque<String> dq){
            // 每一次递归, 用一个, 少一个
            // 这个是递归的步进
            String s = dq.poll(); //返回当前结点
            
            if (s.equals("X")) return null;

            // divide
            // 递归的步进, 就是这个dp, 每次 dp.poll()
            TreeNode leftHead = buildTree(dq); //构建左子树
            TreeNode rightHead = buildTree(dq); //构建右子树

            // conquer
            TreeNode node = new TreeNode(Integer.parseInt(s));
            node.left = leftHead;
            node.right = rightHead;
            
            return node;
        }
    }