/*
On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0. A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given the puzzle board board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
*/
class Solution {
    static class BoardState {
        int[][] board; // Current board configuration
        int x; // X position of the empty square (0)
        int y; // Y position of the empty square (0)
        int level; // Number of moves taken to reach this state

        // Constructor to initialize BoardState object
        BoardState(int[][] initBoard, int zeroX, int zeroY, int bfsLevel) {
            this.board = initBoard;
            this.x = zeroX;
            this.y = zeroY;
            this.level = bfsLevel;
        }
    }

    public int slidingPuzzle(int[][] board) {
        int x = 0, y = 0; // Initialize the positions of the empty square

        // Find the position of the empty square (0) in the board
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        BoardState state = new BoardState(board, x, y, 0); // Create the initial board state
        String end = "123450"; // Target configuration
        Queue<BoardState> bfs = new LinkedList<>(); // BFS queue
        bfs.offer(state); // Offer the initial state into the queue
        Set<String> v = new HashSet<>(); // Set to track visited states
        v.add(boardToString(board)); // Add the initial state into visited set

        while (!bfs.isEmpty()) {
            BoardState curr = bfs.poll(); // Get the current state from the queue

            // Check if we have reached the target configuration
            if (boardToString(curr.board).equals(end)) {
                return curr.level; // Return the number of moves taken
            }

            // You can use loop to make the code shorter, but I use if to each case to make it easy to understand

            // Go up
            if (curr.x != 0) {
                int[][] arr = cloneBoard(curr.board);
                swap(arr, curr.x, curr.y, curr.x - 1, curr.y); // Swap with the tile above
                if (!v.contains(boardToString(arr))) { // Check if this state has been visited
                    BoardState next = new BoardState(arr, curr.x - 1, curr.y, curr.level + 1); // Create the next state
                    bfs.offer(next); // Offer the next state into the queue
                    v.add(boardToString(arr)); // Mark this state as visited
                }
            }

            // Go left
            if (curr.y != 0) {
                int[][] arr = cloneBoard(curr.board);
                swap(arr, curr.x, curr.y, curr.x, curr.y - 1); // Swap with the tile to the left
                if (!v.contains(boardToString(arr))) { // Check if this state has been visited
                    BoardState next = new BoardState(arr, curr.x, curr.y - 1, curr.level + 1); // Create the next state
                    bfs.offer(next); // Offer the next state into the queue
                    v.add(boardToString(arr)); // Mark this state as visited
                }
            }

            // Go down
            if (curr.x != 1) {
                int[][] arr = cloneBoard(curr.board);
                swap(arr, curr.x, curr.y, curr.x + 1, curr.y); // Swap with the tile below
                if (!v.contains(boardToString(arr))) { // Check if this state has been visited
                    BoardState next = new BoardState(arr, curr.x + 1, curr.y, curr.level + 1); // Create the next state
                    bfs.offer(next); // Offer the next state into the queue
                    v.add(boardToString(arr)); // Mark this state as visited
                }
            }

            // Go right
            if (curr.y != 2) {
                int[][] arr = cloneBoard(curr.board);
                swap(arr, curr.x, curr.y, curr.x, curr.y + 1); // Swap with the tile to the right
                if (!v.contains(boardToString(arr))) { // Check if this state has been visited
                    BoardState next = new BoardState(arr, curr.x, curr.y + 1, curr.level + 1); // Create the next state
                    bfs.offer(next); // Offer the next state into the queue
                    v.add(boardToString(arr)); // Mark this state as visited
                }
            }
        }

        return -1; // Return -1 if the puzzle is unsolvable
    }

    private String boardToString(int[][] board) {
        StringBuilder res = new StringBuilder();
        // Convert the board to a string representation for easy comparison
        for (int[] row : board) {
            for (int num : row) {
                res.append(num);
            }
        }
        return res.toString();
    }

    private int[][] cloneBoard(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, board[i].length);
        }
        return newBoard;
    }

    private void swap(int[][] board, int x1, int y1, int x2, int y2) {
        int temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }
}
