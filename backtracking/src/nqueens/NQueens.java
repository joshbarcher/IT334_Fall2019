package nqueens;

public class NQueens
{
    private static final int N = 28;

    public static void main(String[] args)
    {
        printNQueens();
    }

    private static void printNQueens()
    {
        boolean[][] board = new boolean[N][N];

        solve(board, 0, 0);

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                System.out.print(board[i][j] ? "|Q" : "|_");
            }
            System.out.println("|");
        }
    }

    private static boolean solve(boolean[][] board, int col, int row)
    {
        //base cases
        if (col >= N) { return true; }
        else if (row >= N) { return false; }

        if (isInvalid(board, col, row)) //if invalid check the next row
        {
            return solve(board, col, row + 1);
        }
        else //if valid check the next column, or backtrack if the entire col is invalid
        {
            board[col][row] = true;
            if (!solve(board, col + 1, 0))
            {
                board[col][row] = false;
                return solve(board, col, row + 1);
            }
            return true;
        }
    }

    private static boolean isInvalid(boolean[][] board, int col, int row)
    {
        //row and col
        for (int i = 0; i < N; i++)
        {
            if (i != col && board[i][row] || i != row && board[col][i])
            {
                return true;
            }
        }

        //diagonals
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
        {
            if (board[j][i]) { return true; }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++)
        {
            if (board[j][i]) { return true; }
        }

        for (int i = row + 1, j = col - 1; i < N && j >= 0; i++, j--)
        {
            if (board[j][i]) { return true; }
        }

        for (int i = row + 1, j = col + 1; i < N && j < N; i++, j++)
        {
            if (board[j][i]) { return true; }
        }

        return false;
    }
}
