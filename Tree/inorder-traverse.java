// https://leetcode-cn.com/problems/binary-tree-inorder-traversal
// leetcode 94

// 这道题目有三种解法都需要掌握: 
// 1. traverse, 2. divide conquer, 3. 非递归版本

// Version 1: traverse 模板
class Solution {
    
    // 小本子, 最终结果
    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        
        // 把小本子带进递归
        // inorder(root, res);
        inorder(root);
        return res;
    }

    // traverse 不需要返回值, 只要void即可
    // traverse 必须要一个单独的help方法
    // public void inorder(TreeNode root, List<Integer> res) {
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        // 从上到下的思维去解决问题

        // 把小本子带进递归, 对答案进行记录
        // 小人从左分支, 继续走下去
        // inorder(root.left, res);
        inorder(root.left);

        // 有一个小人, 在这一层需要做的事情
        res.add(root.val);
        
        // 小人从右分支, 继续走下去, 把小本子带下去
        // inorder(root.right, res);
        inorder(root.right);
    }

}

//Version 2: Divide & Conquer
public class Solution {
    // 分治法, 必须要返回值
    // 分治法, 不需要一个help方法
    // 一般情况下, 想分治法, 因为这个写起来简单, 只有一个方法, 不需要写help method
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        // null or leaf
        if (root == null) {
            return result;
        }

        // Divide
        // 关键点: 假设已经完成了, 并且返回了结果
        // 没有小本本!!!!
        ArrayList<Integer> left = inorderTraversal(root.left);
        ArrayList<Integer> right = inorderTraversal(root.right);

        // Conquer
        // 对所有的结果进行处理
        // 把所有的左边的结果集加入
        result.addAll(left);

        result.add(root.val);

        // 把所有的有右边结果集加入
        result.addAll(right);
        
        return result;
    }
}

// 非递归版本
// 图解 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
// 这个题解的宗旨就是使用一个颜色或者任何东西，记录节点的访问次数。在中序中，节点第二次访问会被输出。因此使用颜色，或者hash表来记录节点的访问次数，次数使用hash表来记录

// 其解题核心思想如下：
// 使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
// 如果遇到的节点为白色(没见过)，则将其标记为灰色(第一次见)，然后将其右子节点、自身、左子节点依次入栈。
// 如果遇到的节点为灰色(已经见过一次了, 这次是第二次见)，则将节点的值输出。

// 解释一下为什么需要“右子节点、自身、左子节点依次入栈”
// 前序遍历：中，左，右
// 中序遍历：左，中，右
// 后序遍历：左，右，中
// 本题需要中序遍历。

// 栈是一种 先进后出的结构，出栈顺序为左，中，右
// 那么入栈顺序必须调整为倒序，也就是右，中，左

// 同理，如果是前序遍历，入栈顺序为 右，左，中；后序遍历，入栈顺序中，右，左

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        // 套路, 一上来就这么写, 先设好结果, 然后判断一下空的情况
        List<Integer> result = new ArrayList<>();        
        // 错误点: 没有做判断空的情况
        if(root == null) {
            return result;   //初始检查
        }
        
        // 要有两个数据结构, 一个查重用的map, 一个是模拟栈的stack
        Map<TreeNode, Integer> map = new HashMap<>(); // key是Node, value是访问次数
        // 错误点: 以为stack是LinkedList, 其实不是, 是单独的stack
        Stack<TreeNode> stack = new Stack<>();
        
        // 双胞胎形影不离
        stack.push(root);
        map.put(root,1);//1表示第一次访问,2表示第二次访问。

        // 手工模拟一个栈
        while (!stack.isEmpty())
        {
            //弹栈
            TreeNode currNode = stack.pop();

            //如果是第一次访问的话，则将其右子节点，自身，左子结点入栈
            if (1 == map.get(currNode)) 
            {
                // 以下的是三个部分其实和递归是一样的, 只不过push的顺序反了

                // push右: 将右子节点入栈
                if(currNode.right != null)
                {
                    // 两个好兄弟
                    stack.push(currNode.right);
                    map.put(currNode.right,1);
                }

                // 两个好兄弟
                // push中: 将自身入栈，改变访问次数
                stack.push(currNode);
                // 访问次数只有2种, 或者1 或者2, 所以这里可以hard coding
                map.put(currNode,2);    //更新访问次数

                // push左: 将左子节点入栈
                if(currNode.left!=null)
                {
                    // 两个好兄弟
                    stack.push(currNode.left);
                    map.put(currNode.left,1);
                }

            } else {
                //else表示是第2次访问，就输出
                result.add(currNode.val);
            }
        }
        return result;
    }
}