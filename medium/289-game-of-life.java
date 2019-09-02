class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = countNeighbor(board, i, j);
                int cur = board[i][j];
                if (cur == 0 && count == 3) {
                    board[i][j] = 2;
                } else if (cur == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = -1;
                    }
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int cur = board[i][j];
                if (cur == -1) {
                    board[i][j] = 0;
                } else if (cur == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    // mark live -> die = -1
    // mark die -> live = 2
    int[][] dirs = {{-1, -1},{-1, 0},{-1, 1},{0, -1},{0, 1}, {1, -1}, {1, 0}, {1, 1}};
    private int countNeighbor(int[][] board, int i, int j) {
        int res = 0;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI >= 0 && nextJ >= 0 && nextI < board.length && nextJ < board[0].length) {
                if (board[nextI][nextJ] == 1 || board[nextI][nextJ] == -1) {
                    res++;   
                }
            }
        }
        return res;
    }
}
