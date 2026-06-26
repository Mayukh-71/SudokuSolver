import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class FrameRecorder implements SolverListener
{
    private static final int CELL_SIZE=60;
    private static final int TOP_MARGIN=70;
    private static final int WIDTH=540;
    private static final int HEIGHT=610;
    private int frameNumber=0;
    public FrameRecorder()
    {
        File dir=new File("frames");
        if(!dir.exists())
            dir.mkdir();
    }
    @Override
    public void onBoardUpdated(int[][] board,int row,int col,int value,boolean placement)
    {
        try
        {
            BufferedImage image=new BufferedImage
            (
                WIDTH,
                HEIGHT,
                BufferedImage.TYPE_INT_RGB
            );
            Graphics2D g=image.createGraphics();
            drawBoard(g,board,row,col,placement);
            g.dispose();
            ImageIO.write
            (
                image,
                "png",
                new File(String.format("frames/frame%04d.png",frameNumber++))
            );
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void drawBoard(Graphics2D g,int[][] board,int activeRow,int activeCol,boolean placement)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,WIDTH,HEIGHT);
        //---------------- Title ----------------
        g.setFont(new Font("Segoe UI",Font.BOLD,28));
        g.setColor(Color.BLACK);
        g.drawString("Sudoku Solver",150,40);
        //---------------- Highlight ------------
        if(activeRow!=-1)
        {
            if(placement)
                g.setColor(new Color(190,255,190));
            else
                g.setColor(new Color(255,190,190));
            g.fillRect
            (
                    activeCol*CELL_SIZE,
                    TOP_MARGIN+activeRow*CELL_SIZE,
                    CELL_SIZE,
                    CELL_SIZE
            );
        }
        //---------------- Grid -----------------
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
                    TOP_MARGIN+i*CELL_SIZE,
                    9*CELL_SIZE,
                    TOP_MARGIN+i*CELL_SIZE
            );
            g.drawLine
            (
                    i*CELL_SIZE,
                    TOP_MARGIN,
                    i*CELL_SIZE,
                    TOP_MARGIN+9*CELL_SIZE
            );
        }
        //---------------- Numbers -------------
        g.setFont(new Font
                (
                        "Segoe UI",
                        Font.BOLD,
                        30
                ));
        FontMetrics fm=g.getFontMetrics();
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!=0)
                {
                    String s=Integer.toString(board[i][j]);
                    int x=j*CELL_SIZE+(CELL_SIZE-fm.stringWidth(s))/2;
                    int y=TOP_MARGIN+i*CELL_SIZE+((CELL_SIZE-fm.getHeight())/2)+fm.getAscent();
                    g.drawString(s,x,y);
                }
            }
        }
    }
    public int getFrameCount()
    {
        return frameNumber;
    }
    public void saveScreenshot(int[][] board,String filename)
    {
        try
        {
                BufferedImage image =new BufferedImage
                                        (
                                                WIDTH,
                                                HEIGHT,
                                                BufferedImage.TYPE_INT_RGB
                                        );
                Graphics2D g = image.createGraphics();
                drawBoard
                (
                        g,
                        board,
                        -1,
                        -1,
                        true
                );
                g.dispose();
                ImageIO.write
                (
                        image,
                        "png",
                        new File(filename)
                );
        }
        catch(Exception e)
        {
                e.printStackTrace();
        }
    }
}