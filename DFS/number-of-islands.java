// https://leetcode-cn.com/problems/number-of-islands/
// leetcode 200

// Matrix + DFS 
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // matrix 行数
        int nr = grid.length;
        // matrix 列数
        int nc = grid[0].length;

        int num_islands = 0;

        // 循环一遍行, 再循环一遍列
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                // 找到一片岛屿的第一个头
                if (grid[r][c] == '1') {
                    num_islands++;
                    // 通过这个头, 抽出所有周边的, 见到1 → 变成0
                    dfs(grid, r, c);
                }
                // 进入下一个循环 继续找下一个岛屿的头
            }
        }

        return num_islands;
    }

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        // in area condition check 越界查询
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        // 见到1, 把他变成0
        grid[r][c] = '0';

        // dfs上下左右
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);

        // 这里为什么不用插销的操作? 因为没有记录的操作, 只是进入, 而且 r - 1并不会减少r
    }
}

// 时间复杂度：O(MN)，其中 MM 和 NN 分别为行数和列数。
// 空间复杂度：O(MN)，在最坏情况下，整个网格均为陆地，深度优先搜索的深度达到 M NMN。


// 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-shu-liang-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。