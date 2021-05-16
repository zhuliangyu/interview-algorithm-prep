/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

// topological + Graph + BFS
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */ 

    // 只能用于有向图
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {

        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();

        // 制作入度表
        // 入度表里只有 >= 1的node
        HashMap<DirectedGraphNode, Integer> map = new HashMap();

        for (DirectedGraphNode node : graph) { // 所有点
            for (DirectedGraphNode neighbor : node.neighbors) { // 点对应的邻居
                // 每包含一次, + 1
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    // 初次进入, 设置为 1
                    map.put(neighbor, 1); 
                }
            }
        }

        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        
        // 完全孤立的点, 没有任何邻居
        // root 入队
        for (DirectedGraphNode node : graph) {
            // 这是筛选出入度点 == 0 的node
            // result只能加入入度 == 0的点
            if (!map.containsKey(node)) {
                //入度==0, 入队 + 加结果
                q.offer(node);
                result.add(node);
            }
        }
        
        // Graph + BFS模板
        while (!q.isEmpty()) {
            // 出队
            DirectedGraphNode node = q.poll();

            for (DirectedGraphNode n : node.neighbors) {
                //破局关键: 这个点的所有邻居的入度 - 1
                map.put(n, map.get(n) - 1);

                // when 入度 == 0, 加入result
                if (map.get(n) == 0) {
                    //入度==0, 入队 + 加结果
                    result.add(n);
                    q.offer(n);
                }
            }
        }

        return result;
    }
}

// 更详细的解答
// https://leetcode-cn.com/problems/course-schedule/solution/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/
// https://www.jiuzhang.com/solutions/topological-sorting/