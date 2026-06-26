import javax.swing.*;
import java.awt.*;

public class SudokuGUI extends JPanel implements SolverListener
{
    private int[][] board;
    private int activeRow=-1;
    private int activeCol=-1;
    private boolean placement=true;
    private static final int CELL_SIZE=60;
    private static final int TOP_MARGIN=70;
    private static final int BOARD_SIZE=9*CELL_SIZE;
    public SudokuGUI(int[][] board)
    {
        this.board = board;
        setPreferredSize(new Dimension(BOARD_SIZE+1,BOARD_SIZE+TOP_MARGIN+1));
        setBackground(Color.WHITE);
    }
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        //-------------------------------
        // Better Graphics
        //-------------------------------
        g2.setRenderingHint
        (
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2.setRenderingHint
        (
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON
        );
        //-------------------------------
        // Draw Title
        //-------------------------------
        g2.setColor(Color.BLACK);
        Font titleFont=new Font("Segoe UI", Font.BOLD, 28);
        g2.setFont(titleFont);
        String title="Sudoku Solver";
        FontMetrics titleFM=g2.getFontMetrics();
        int titleX=(getWidth() - titleFM.stringWidth(title))/2;
        g2.drawString(title, titleX, 40);
        //-------------------------------
        // Highlight Current Cell
        //-------------------------------
        if(activeRow!=-1&&activeCol!=-1)
        {
            if(placement)
                g2.setColor(new Color(190,255,190));
            else
                g2.setColor(new Color(255,190,190));
            g2.fillRect
            (
                    activeCol*CELL_SIZE,
                    TOP_MARGIN+activeRow*CELL_SIZE,
                    CELL_SIZE,
                    CELL_SIZE
            );
        }
        //-------------------------------
        // Draw Grid
        //-------------------------------
        g2.setColor(Color.BLACK);
        for(int i=0;i<=9;i++)
        {
            if(i%3==0)
                g2.setStroke(new BasicStroke(3));
            else
                g2.setStroke(new BasicStroke(1));
            // Horizontal line
            g2.drawLine
            (
                    0,
                    TOP_MARGIN+i*CELL_SIZE,
                    BOARD_SIZE,
                    TOP_MARGIN+i*CELL_SIZE
            );
            // Vertical line
            g2.drawLine
            (
                    i*CELL_SIZE,
                    TOP_MARGIN,
                    i*CELL_SIZE,
                    TOP_MARGIN+BOARD_SIZE
            );
        }
        //-------------------------------
        // Draw Numbers
        //-------------------------------
        Font numberFont=new Font("Segoe UI", Font.BOLD, 30);
        g2.setFont(numberFont);
        FontMetrics fm=g2.getFontMetrics();
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!=0)
                {
                    String s=Integer.toString(board[i][j]);
                    int x=j*CELL_SIZE+(CELL_SIZE-fm.stringWidth(s))/2;
                    int y=TOP_MARGIN+i*CELL_SIZE+((CELL_SIZE-fm.getHeight())/2)+fm.getAscent();
                    g2.setColor(Color.BLACK);
                    g2.drawString(s,x,y);
                }
            }
        }
    }
    @Override
    public void onBoardUpdated(int[][] board,int row,int col,int value,boolean placement)
    {
        this.activeRow=row;
        this.activeCol=col;
        this.placement=placement;
        repaint();
    }
}