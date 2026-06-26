import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRecorder implements SolverListener
{
    private ArrayList<BufferedImage>frames;
    private static final int CELL=60;
    private static final int TOP=70;
    public AnimationRecorder()
    {
        frames=new ArrayList<>();
    }
    @Override
    public void onBoardUpdated(int[][] board,int row,int col,int value,boolean placement)
    {
        BufferedImage image=new BufferedImage(540,610,BufferedImage.TYPE_INT_RGB);
        Graphics2D g=image.createGraphics();
        drawBoard(g,board,row,col,placement);
        g.dispose();
        frames.add(image);
    }
    public ArrayList<BufferedImage> getFrames()
    {
        return frames;
    }
    private void drawBoard(Graphics2D g,int[][] board,int activeRow,int activeCol,boolean placement)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,540,610);
        g.setFont(new Font("Segoe UI",Font.BOLD,28));
        g.setColor(Color.BLACK);
        g.drawString("Sudoku Solver",150,40);
        if(activeRow!=-1)
        {
            if(placement)
                g.setColor(new Color(180,255,180));
            else
                g.setColor(new Color(255,180,180));
            g.fillRect
            (
                activeCol*CELL,
                TOP+activeRow*CELL,
                CELL,
                CELL
            );
        }
        g.setColor(Color.BLACK);
        for(int i=0;i<=9;i++)
        {
            if(i%3==0)
                g.setStroke(new BasicStroke(3));
            else
                g.setStroke(new BasicStroke(1));
            g.drawLine
            (
                0,
                TOP+i*CELL,
                540,
                TOP+i*CELL
            );
            g.drawLine
            (
                i*CELL,
                TOP,
                i*CELL,
                TOP+540
            );
        }
        Font f=new Font(
                            "Segoe UI",
                            Font.BOLD,
                            30
                        );
        g.setFont(f);
        FontMetrics fm=g.getFontMetrics();
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!=0)
                {
                    String s=Integer.toString(board[i][j]);
                    int x=j*CELL+(CELL-fm.stringWidth(s))/2;
                    int y=TOP+i*CELL+((CELL-fm.getHeight())/2)+fm.getAscent();
                    g.drawString(s,x,y);
                }
            }
        }
    }
}