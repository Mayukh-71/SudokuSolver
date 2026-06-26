public interface SolverListener
{
    void onBoardUpdated(int[][] board,int row,int col,int value,boolean placement);
}