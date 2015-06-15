public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                Character currentChar = board[i][j];
                if (currentChar == '.') {
                    continue;
                }
                if (set.contains(currentChar)) {
                    return false;
                } else {
                    set.add(currentChar);
                }
            }
        }
        
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                Character currentChar = board[i][j];
                if (currentChar == '.') {
                    continue;
                }
                if (set.contains(currentChar)){
                    return false;
                } else {
                    set.add(currentChar);
                }
            }
        }
        
        for (int n = 0; n < 3; n++) {
            for (int m = 0; m < 3; m++) {
                set.clear();
                for (int i = n * 3; i < n*3 + 3; i++) {
                    for (int j = m * 3; j < m * 3 + 3; j++) {
                       Character currentChar = board[i][j];
                       if (currentChar == '.') {
                           continue;
                       }
                       if (set.contains(currentChar)) {
                           return false;
                       } else {
                           set.add(currentChar);
                       }
                    }
                }
            }
        }
        
        return true;
        
    }
}