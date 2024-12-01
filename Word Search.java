/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
*/
class Solution {
    public boolean DFS(char[][] board, int r, int c, String word, int WI){
        //Best case
        if(WI == word.length()) return true;
        
        //OutofBound case
        int rows = board.length;
        int cols = board[0].length;
        if(r<0 || r>=rows || c<0 || c>=cols){
            return false;
        }

        //Invalid cases
        // $ is character with wich we will be replacing matched character
        if(board[r][c] == '$' || board[r][c] != word.charAt(WI)){
            return false;
        }

        //Replacing matched character
        char ch = board[r][c]; //holds the character 
        board[r][c] = '$';

        //Make call for another character search
        if(DFS(board, r-1, c, word, WI+1)||
           DFS(board, r+1, c, word, WI+1)||
           DFS(board, r, c+1, word, WI+1)||
           DFS(board, r, c-1, word, WI+1)){
            return true;
        }
        //backtrack
        board[r][c] = ch;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0;j<n; j++){
                //If there is first character match
                if(word.charAt(0) == board[i][j]){
                    boolean found = DFS(board, i, j, word, 0);
                    if(found) return true;
                }
            }
        }

        return false;
    }
}
