import javax.swing.JFrame;

public class Main
{
    public static void main(String[] args)
    {
        // -------------------------------
        // Read Sudoku
        // -------------------------------
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.inputBoard();
        // -------------------------------
        // Validate Sudoku
        // -------------------------------
        if(!sudoku.isValidSudoku())
        {
            System.out.println("Not solvable");
            return;
        }
        // -------------------------------
        // Create GUI
        // -------------------------------
        SudokuGUI gui = new SudokuGUI(sudoku.getBoard());
        JFrame frame = new JFrame("Sudoku Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gui);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // -------------------------------
        // Create Frame Recorder
        // -------------------------------
        FrameRecorder recorder = new FrameRecorder();
        // -------------------------------
        // Create Solver
        // -------------------------------
        SudokuSolver solver =new SudokuSolver(sudoku.getBoard());
        // Register listeners
        solver.addListener(gui);
        solver.addListener(recorder);
        // Give the window time to appear
        try
        {
            Thread.sleep(500);
        }
        catch(Exception e){}
        // -------------------------------
        // Solve Sudoku
        // -------------------------------
        recorder.saveScreenshot(sudoku.getBoard(),"StartingEndingState/initial.png");
        boolean solved=solver.solve();
        if(!solved)
        {
            System.out.println("Not solvable");
            return;
        }
        System.out.println("Sudoku Solved!");
        recorder.saveScreenshot(sudoku.getBoard(),"StartingEndingState/solved.png");
        // -------------------------------
        // Generate MP4 Video
        // -------------------------------
        try
        {
            ProcessBuilder pb=new ProcessBuilder
                              (
                                    "ffmpeg",
                                    "-y",
                                    "-framerate",
                                    "25",
                                    "-i",
                                    "frames/frame%04d.png",
                                    "-pix_fmt",
                                    "yuv420p",
                                    "Output/solution.mp4"
                              );

            pb.inheritIO();
            Process process=pb.start();
            process.waitFor();
            System.out.println("\nVideo saved as solution.mp4");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Program Finished.");
    }
}