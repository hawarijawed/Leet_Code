/*
Given a square matrix mat[][] of size n x n. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space. 
*/
class Solution {
    // Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int mat[][]) {
        // code here  
        int row=mat.length;
        int col=mat[0].length;
        
        //Transpose of matrix
        for(int i=0; i<row; i++){
            for(int j=0; j<i; j++){
                if(i==j) continue;
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        
        //Reverse or swap each column
        for(int i=0; i<col; i++){
            int r = 0;
            //swap elements
            while(r!=row/2){
                int temp = mat[r][i];
                mat[r][i] = mat[row-1-r][i];
                mat[row-1-r][i] = temp;
                r++;
            }
        }
        
    }
}
