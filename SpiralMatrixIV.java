/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 /*
You are given two integers m and n, which represent the dimensions of a matrix.

You are also given the head of a linked list of integers.

Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise), starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.

Return the generated matrix.
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int [][] matrix = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = -1;
            }
        }
        //Use four border variables
        int topRow = 0, bottomRow = m-1, leftCol = 0, rightCol = n-1;
        while(head!=null){
            //First row
            for(int col = leftCol; col<=rightCol; col++){
                if(head == null){
                    break;
                }
                matrix[topRow][col] = head.val;
                head = head.next;
            }

            //Right most column
            topRow++;
            for(int row = topRow; row <= bottomRow; row++){
                if(head == null){
                    break;
                }
                matrix[row][rightCol] = head.val;
                head = head.next;
            }
            //From right to left bottom row fillup
            rightCol--;
            for(int col = rightCol; col>=leftCol; col--){
                if(head == null){
                    break;
                }
                matrix[bottomRow][col] = head.val;
                head = head.next;
            }
            //First Column bottom to up
            bottomRow--;
            for(int row=bottomRow; row>=topRow; row--){
                if(head == null){
                    break;
                }
                matrix[row][leftCol] = head.val;
                head = head.next;
            }
            leftCol++;
        }
        return matrix;

    }
}
