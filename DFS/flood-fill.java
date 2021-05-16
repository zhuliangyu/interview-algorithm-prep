public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];

        // 如果颜色相同, 根本不需要flood
        if (oldColor != newColor) {
            dfs(image, sr, sc, image.length, image[0].length, oldColor, newColor);
        }

        return image;
    }

    private void dfs(
        int[][] image,
        int row,
        int col,
        int n, // 固定的, image.length = 2DArray的行数
        int m, // 固定的, image[0].length = 2DArray的列数
        int oldColor,
        int newColor
    ) {
        // 越界或者不等于oldColor，直接return
        // 递归结束的条件
        if (row < 0 || row >= n         // row越界
                || col < 0 || col >= m  // col越界
                || image[row][col] != oldColor) {

            return;
        }

        // 这层该做的事情: flood paint
        image[row][col] = newColor;

        // 这个就是DFS的for循环的四个options
        // 上下左右 递归
        // 递归的步进就是index(row or col)+1 -1
        dfs(image, row - 1, col, n, m, oldColor, newColor);
        dfs(image, row, col - 1, n, m, oldColor, newColor);
        dfs(image, row + 1, col, n, m, oldColor, newColor);
        dfs(image, row, col + 1, n, m, oldColor, newColor);

        // 这里不用考虑撤销回溯!!!
    }
}

// 作者：xdz0201
// 链接：https://leetcode-cn.com/problems/flood-fill/solution/dfs-chao-jian-shuang-100-by-xdz0201-br3e/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。