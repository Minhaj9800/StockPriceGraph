import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
/**
 * In this class PlottingPanel we create buttons namely appl, and nflix(two companies name)
 * radiobutton for 5days, 10days and 30 days options. In this class we provide
 * the data as well as and do the implementation for the ployline according to data
 * In this class we also implements the ActionListner Class for our buttons too.
 * 
 * @author (Minhajur Rahman, Student ID-302258) 
 * @version (Assignment-4, February 14, 2019)
 */
public class PlottingPanel extends JPanel
{
    private JLabel title;
    private PlotPanel plot;
    private JButton button1;
    private JButton button2;
    
    // two companies data 
    private Data netflix = new Data(new File("stock_prices/nflx_price.txt"));
    private Data apple = new Data(new File("stock_prices/aapl_price.txt"));
    public PlottingPanel()// constructor
    {
        // setLayout.
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        plot = new PlotPanel();
        
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));
        
        // centered labeling.
        title = new JLabel("Stock Price Plotting\n", JLabel.CENTER);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(title);
        labelPanel.add(Box.createHorizontalGlue());
        
        this.add(labelPanel);// adding the labelPanel
        // craeting buttonPanle object and setLayout.
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        
        // creating two companies button.
        button1 = new JButton("nflix");
        button1.addActionListener(new StockListener(netflix, plot));
        button2 = new JButton("appl");
        button2.addActionListener(new StockListener(apple, plot));
        
        // craeting radiobuttons for days option.
        JRadioButton radio5 = new JRadioButton("5 Days");
        radio5.addActionListener(new DaysListener(5,plot));

        
        JRadioButton radio10 = new JRadioButton("10 Days");
        radio10.addActionListener(new DaysListener(10,plot));
        
        JRadioButton radio30 = new JRadioButton("30 Days");
        radio30.addActionListener(new DaysListener(30,plot));
       
        // add all the radio button in ButtonGroup.
        ButtonGroup group = new ButtonGroup();
        group.add(radio5);
        group.add(radio10);
        group.add(radio30);
        
        // adding all the buttons and radiobuttons to the buttonpanel.
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(button2);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(button1);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(radio5);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(radio10);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(radio30);
        buttonPanel.add(Box.createHorizontalGlue());
        
        buttonPanel.setBackground(Color.GRAY);
        
        this.add(buttonPanel);
        
        
        
        this.add(plot);
    }
    
    // implements the ActonListener interface for the buttons.
    private class StockListener implements ActionListener
    {
        private Data data;
        private PlotPanel plot;
        StockListener(Data data, PlotPanel plot)
        {
            this.data = data;
            this.plot = plot;
        }
        
        public void actionPerformed(ActionEvent ae)
        {
            plot.setData(data);
        }
    }
    
    
    private class DaysListener implements ActionListener
    {
        private int days;
        private PlotPanel plot;
        DaysListener(int days, PlotPanel plot)
        {
            this.days = days;
            this.plot = plot;
        }
        
        public void actionPerformed(ActionEvent ae)
        {
            plot.setPoints(days);
        }
    }
}
