package nqueens;

public class NQueens
{
    private static final int N = 4;

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

        //check diagonals
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