输入：
[
    [1,1,0,0,0],
    [0,1,0,0,1],
    [0,0,0,1,1],
    [0,0,0,0,0],
    [0,0,0,0,1]
]
输出：
3


class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// Matrix + BFS
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    int[] deltaX = {0, 1, -1, 0};
    int[] deltaY = {1, 0, 0, -1};
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        int islands = 0;
        int n = grid.length, m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) { // 行
            for (int j = 0; j < m; j++) { // 列
                if (grid[i][j] && !visited[i][j]) {
                    // 找到一个头
                    // 从这个头, 用bfs抓出一大片东西来, 全部把isVisited从false变到true
                    // 但是这题解法不改Matrix原始值
                    bfs(grid, i, j, visited);
                    // 改完,  岛屿 + 1, 找到一个群岛
                    islands++;

                }
            }
        }
        
        return islands;
    }
    
    private void bfs(boolean[][] grid, int x, int y, boolean[][] visited) {
        Queue<Coordinate> queue = new ArrayDeque<>();

        // 一对好基友
        queue.offer(new Coordinate(x, y));
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Coordinate coor = queue.poll();

            // 对应的四个方向
            for (int direction = 0; direction < 4; direction++) {
                int newX = coor.x + deltaX[direction];
                int newY = coor.y + deltaY[direction];
                
                if (!isVaild(grid, newX, newY, visited)) {
                    continue;
                }

                //一对好基友
                queue.offer(new Coordinate(newX, newY));
                visited[newX][newY] = true;
            }
        }
    }
    
    private boolean isVaild(boolean[][] grid, int x, int y, boolean[][] visited) {
        int n = grid.length, m = grid[0].length;
        // 越界 → false
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        // 已经访问过了 → false
        if (visited[x][y]) {
            return false;
        }

        // 只有返回的值1才会是true 
        return grid[x][y];
    }
}

// https://www.jiuzhang.com/solutions/number-of-islands/