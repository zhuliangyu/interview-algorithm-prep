// https://leetcode-cn.com/problems/word-search/
// leetcode 79

public class Solution {

    // 偏移量数组在二维平面内是经常使用的，可以把它的设置当做一个技巧
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int rows;
    private int cols;
    private boolean[][] visited;
    private char[] charArray;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        // 确定长度和宽度
        rows = board.length;
        if (rows == 0) {
            return false;
        }
        cols = board[0].length;

        // 所有的点都设置未访问过
        visited = new boolean[rows][cols];

        this.charArray = word.toCharArray();
        this.board = board;

        // 棋盘类, 两个for循环是套路
        // 这个是棋盘类很特殊的
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // begin代表匹配到了第几个字符
    private boolean dfs(int x, int y, int begin) {
        // 结束递归的条件, 现在走到了最后一个字符
        if (begin == word.length() - 1) {
            // 只要最后一个字符匹配上, 就大功告成了
            return board[x][y] == charArray[begin];
        }

        // 第一个匹配
        if (board[x][y] == charArray[begin]) {
            // 回溯三部曲

            // 本层要做的事情
            visited[x][y] = true;

            // 递归, 去下一层
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    // 在第一个匹配的情况下
                    // 剩余所有的都匹配, 返回true
                    if (dfs(newX, newY, begin + 1)) {
                        return true;
                    }
                }
            }

            // 撤销本层做的事情
            visited[x][y] = false;
        }

        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
