import javax.swing.JFrame;
/**
 * This class is for visaulize our final modified frame. We do have main method here for that.
 * 
 * @author (Minhajur Rahman, Student ID-302258) 
 * @version (Assignment-4, February 14,2019)
 */
public class Display
{
    public static void main(String [] args)
    {
        JFrame frame = new JFrame();

        frame.setSize(500, 500);
        //frame.setTitle();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new PlottingPanel());

        frame.setVisible(true);
    }
}
