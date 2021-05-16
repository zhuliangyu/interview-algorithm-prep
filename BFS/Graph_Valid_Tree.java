//https://www.jiuzhang.com/solutions/graph-valid-tree/
// 问一个图是否是树
// 关键问题1 : 如何从一个基本二维数组edges恢复成为graph的结构
// 关键问题2: 用BFS破题, 只要判断visted里面的数量和n是否一致, 因为visted里面没有重复

// graph + BFS 题型
public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }
        
        if (edges.length != n - 1) {
            return false;
        }
        
        // 关键点1: 恢复图的数据结构
        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
        
        // Graph bfs 模板
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();
        
        // queue和hash是一对好基友, 形影不离
        queue.offer(0);
        hash.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                // 不允许重复访问
                if (hash.contains(neighbor)) {
                    continue;
                }

                // queue和hash是一对好基友, 形影不离
                queue.offer(neighbor);
                hash.add(neighbor);

            }
        }
        
        // 破题点!!! 数量相等说明没有重复, 就是一棵树
        return (hash.size() == n);
    }
    
    private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return graph;
    }
}
