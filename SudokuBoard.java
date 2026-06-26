import java.util.Scanner;
public class SudokuBoard 
{
    private int[][] board;
    public SudokuBoard() 
    {
        board=new int[9][9];
    }
    public void inputBoard() 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Sudoku (0 for empty cells):");
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                board[i][j]=sc.nextInt();
            }
        }
    }
    public void printBoard() 
    {
        System.out.println();
        for(int i=0;i<9;i++)
        {
            if(i%3==0)
                System.out.println("+-------+-------+-------+");
            for(int j=0;j<9;j++)
            {
                if(j%3==0)
                    System.out.print("| ");
                if(board[i][j]==0)
                    System.out.print(". ");
                else
                    System.out.print(board[i][j]+" ");
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+");
    }
    public int[][] getBoard() 
    {
        return board;
    }
    private boolean isRowValid(int row)
    {
        boolean[] seen=new boolean[10];
        for(int col=0;col<9;col++)
        {
            int num=board[row][col];
            if(num==0)
                continue;
            if(seen[num])
                return false;
            seen[num]=true;
        }
        return true;
    }
    private boolean isColumnValid(int col)
    {
        boolean[] seen=new boolean[10];
        for(int row=0;row<9;row++)
        {
            int num=board[row][col];
            if(num==0)
                continue;
            if(seen[num])
                return false;
            seen[num] = true;
        }
        return true;
    }
    private boolean isBoxValid(int startRow, int startCol)
    {
        boolean[] seen=new boolean[10];
        for(int i=startRow;i<startRow+3;i++)
        {
            for(int j=startCol;j<startCol+3;j++)
            {
                int num=board[i][j];
                if(num==0)
                    continue;
                if(seen[num])
                    return false;
                seen[num]=true;
            }
        }
        return true;
    }
    public boolean isValidSudoku()
    {
        for(int i=0;i<9;i++)
        {
            if(!isRowValid(i))
                return false;
            if(!isColumnValid(i))
                return false;
        }
        for(int i=0;i<9;i+=3)
        {
            for(int j=0;j<9;j+=3)
            {
                if(!isBoxValid(i,j))
                    return false;
            }
        }
        return true;
    }
}