import javax.swing.*;
import java.awt.*;
import java.io.*;
/**
 *This PlotPanel class basically for the standard drawing stuffs for our task using GUI.
 *We draw the rectangle,set background color,set up the visualization for our code.
 * We did some calculation and measurement for our drawing and visualization here.
 * @author (Minhajur Rahman, Student ID-302258) 
 * @version (Assignment-4, February 14,2019)
 */
public class PlotPanel extends JPanel
{
    private Data data = null;
    private int points = 0;
    
    // border width and height for rectangle and char_position number.
    private static final int BORDER_WIDTH = 50;
    private static final int BORDER_HEIGHT = 50;
    private static final int CHAR_POSITION = 20;
    public PlotPanel()// constructor
    {
        this.setBackground(Color.WHITE);
    }
    
    /**
     * Overriding the method paintComponent for our project
     * @param Graphics g.
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Dimension dim = getSize();// store dimension.
        double height = dim.getHeight()-2*BORDER_HEIGHT;
        double width = dim.getWidth()-2*BORDER_HEIGHT;
        
        // set the colour and fill the rectangle according to measurement.
        g.setColor(new Color(255,255,224));
        g.fillRect(BORDER_WIDTH, BORDER_HEIGHT,(int)Math.round(width), (int)Math.round(height));

        if (points <= 0 || data == null) return;

        int numPoints = Math.min(points, data.getSize());

        double[] range = data.getRange(numPoints);// array of range.
        
        // minimum value
        int min = (int) Math.floor(range[0]); 
        min -= min % 2;
        // max values.
        int max = (int) Math.ceil(range[1]);
        max += max % 2;
        g.setColor(Color.BLUE);// set the color for the ranges as blue.
        
        int diff = (max - min)/10;
        if (diff <= 2)
        {
            for(int i = min; i < max; i+=2)
            {
                g.drawString(Integer.toString(i), CHAR_POSITION, translateY(height, max, min, i));
            }
        }
        else
        {
            for(int i = 0; i < 10; i++)
            {
                g.drawString(Integer.toString(min + i*(diff)), CHAR_POSITION, translateY(height, max, min, min + i*(diff)));
            }
        }

        int xValues[] = new int [numPoints];
        int yValues[] = new int [numPoints];

        for(int i= 0; i < numPoints; i++)
        {
            xValues [i] = translateX(width,numPoints, i);
            yValues [i] = translateY(height, max, min, data.getValue(i));
        }
        
        g.setColor(Color.BLUE);
        g.drawPolyline(xValues, yValues,numPoints);// draw the polylines.

    }
    
    /**
     * Know the translateX
     * @param width
     * @param points
     * @param i
     * @retunr integer value as translateX.
     */
    private int translateX(double width,int points,int i)
    {
        return (int)Math.round(BORDER_WIDTH+width-(width-10)/(points-1)*i-5);
    }
    
    /**
     * know the trnaslateY
     * @param height
     * @param max
     * @param min
     * @param value
     * return the value for translateY.
     */
    private int translateY(double height, int max, int min,double value)
    {
        return (int) Math.round(BORDER_HEIGHT+height-(height*(value-min))/(max-min));
    }
    
    /**
     * Setter method for data
     * @param d(type Data)
     */
    public void setData(Data d)
    {
        data = d;
        repaint();
    }
    
    /**
     * setter method for set the points
     * @param numbers.
     */
    public void setPoints(int numbers)
    {
        points = numbers;
        repaint();
    }
}
