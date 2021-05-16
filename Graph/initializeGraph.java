// https://www.jiuzhang.com/solutions/graph-valid-tree/
// n = 5, 表示的节点个数 
// edges = [[0, 1], [0, 2], [0, 3], [1, 4]]

result = Map{
                key: set(不能右重复的),
                0, [1, 2, 3],
                1, [0, 4],
                2, [0],
                3, [0],
                4, {1}

            }

private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
    
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    
    for (int i = 0; i < n; i++) {
        // 有几个节点, 就有几行的记录
        // 每一行的记录都是 key = 节点数, value = 另一边的节点数(去重后的)
        graph.put(i, new HashSet<Integer>());
    }
    
    for (int i = 0; i < edges.length; i++) {
        // edges = [[0, 1], [0, 2], [0, 3], [1, 4]]

        // u = index of 节点
        int u = edges[i][0];

        // v = 这条edge对应的另外一个节点
        int v = edges[i][1];

        // 无向的节点, 所以每条边都可以从左到右, 也可以从右到左
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    
    return graph;
}