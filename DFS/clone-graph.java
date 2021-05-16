// 数据结构: 图DFS题型

// https://leetcode-cn.com/problems/clone-graph/solution/ke-long-tu-by-leetcode-solution/
// DFS 复制一个图
class Solution {

    private HashMap <Node, Node> visited = new HashMap <> ();
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
        Node cloneNode = new Node(node.val, new ArrayList());
        // 哈希表存储
        visited.put(node, cloneNode);

        // 遍历该节点的邻居并更新克隆节点的邻居列表
        // graph数据结构做选择, 就是选择不同的edges
        // 递归结束的条件: 所有的点都被visted之后
        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        // 所有递归结束, 返回最终结果
        return cloneNode;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/clone-graph/solution/ke-long-tu-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。