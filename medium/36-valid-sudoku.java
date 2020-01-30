class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new Set[9];
        Set<Character>[] cols = new Set[9];
        Set<Character>[] boxes = new Set[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cur = board[i][j];
                if (cur != '.') {
                    int boxIdx = (i / 3) * 3 + j / 3;
                    if (rows[i].contains(cur) || cols[j].contains(cur) || boxes[boxIdx].contains(cur)) {
                        return false;
                    } else {
                        rows[i].add(cur);
                        cols[j].add(cur);
                        boxes[boxIdx].add(cur);
                    }   
                }
            }
        }
        return true;
    }
}
