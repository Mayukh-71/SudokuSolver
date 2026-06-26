import java.util.ArrayList;
public class BoardHistory 
{
    private ArrayList<BoardState>history;
    public BoardHistory()
    {
        history=new ArrayList<>();
    }
    public void addBoard(int[][] board,int row,int col,int value,boolean placement)
    {
        history.add(new BoardState
                    (
                        board,
                        row,
                        col,
                        value,
                        placement
                    ));
    }
    public ArrayList<BoardState> getHistory()
    {
        return history;
    }
}