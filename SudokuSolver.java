import java.util.ArrayList;

public class SudokuSolver
{
    private int[][] board;
    private ArrayList<SolverListener>listeners;
    public SudokuSolver(int[][] board)
    {
        this.board=board;
        listeners=new ArrayList<>();
    }
    //----------------------------------------------------
    // Add a listener
    //----------------------------------------------------
    public void addListener(SolverListener listener)
    {
        listeners.add(listener);
    }
    //----------------------------------------------------
    // Notify all listeners
    //----------------------------------------------------
    private void notifyListeners(int row,int col,int value,boolean placement)
    {
        for(SolverListener listener:listeners)
        {
            listener.onBoardUpdated
            (
                board,
                row,
                col,
                value,
                placement
            );
        }
    }
    //----------------------------------------------------
    // Check if placing num is valid
    //----------------------------------------------------
    private boolean isSafe(int row,int col,int num)
    {
        // Check row
        for(int j=0;j<9;j++)
        {
            if(board[row][j]==num)
                return false;
        }
        // Check column
        for(int i=0;i<9;i++)
        {
            if(board[i][col]==num)
                return false;
        }
        // Check 3x3 box
        int startRow=row-row%3;
        int startCol=col-col%3;
        for(int i=startRow;i<startRow+3;i++)
        {
            for(int j=startCol;j<startCol+3;j++)
            {
                if(board[i][j]==num)
                    return false;
            }
        }
        return true;
    }
    //----------------------------------------------------
    // Find next empty cell
    //----------------------------------------------------
    private int[] findEmptyCell()
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]==0)
                    return new int[]{i, j};
            }
        }
        return null;
    }
    //----------------------------------------------------
    // Recursive Solver
    //----------------------------------------------------
    public boolean solve()
    {
        int[] empty=findEmptyCell();
        if(empty==null)
            return true;
        int row=empty[0];
        int col=empty[1];
        for(int num=1;num<=9;num++)
        {
            if(isSafe(row, col, num))
            {
                // Place number
                board[row][col]=num;
                notifyListeners
                (
                        row,
                        col,
                        num,
                        true
                );
                try
                {
                    Thread.sleep(40);
                }
                catch(Exception e){}
                if(solve())
                    return true;
                // Backtrack
                board[row][col]=0;
                notifyListeners
                (
                        row,
                        col,
                        0,
                        false
                );
                try
                {
                    Thread.sleep(40);
                }
                catch(Exception e){}
            }
        }
        return false;
    }
}