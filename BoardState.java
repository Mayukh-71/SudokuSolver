public class BoardState 
{
    private int[][] board;
    private int row;
    private int col;
    private int value;
    private boolean placement;
    public BoardState(int[][] board, int row, int col, int value, boolean placement)
    {
        this.board=new int[9][9];
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                this.board[i][j]=board[i][j];
            }
        }
        this.row=row;
        this.col=col;
        this.value=value;
        this.placement=placement;
    }
    public int[][] getBoard()
    {
        return board;
    }
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
    public int getValue()
    {
        return value;
    }
    public boolean isPlacement()
    {
        return placement;
    }
}