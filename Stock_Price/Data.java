import java.util.Scanner;
import java.io.*;
import java.util.*;
/**
 * This Data class is for reading the textfiles.Beside reading the file
 * it also get the range maximum and minimum for the both comapnie's data
 * It also handling to provide the size.(how many numbers or data on each).
 * 
 * @author (Minhajur Rahman,Student ID-302258) 
 * @version (Assignment-4)
 */
public class Data
{
    private ArrayList<Double> numbers;

    public Data(File file) // constructor which is taking file as parameter.
    {
        numbers = readFile(file);
    }
    
    /**
     * Read the files and gives the list of stored numbers after that.
     * @param file 
     * @return numberList(an ArrayList with numbers type double).
     */
    public ArrayList <Double> readFile(File file)
    {
        ArrayList <Double> numberList = new ArrayList<Double>();
        try{
            Scanner in = new Scanner(file);
            while(in.hasNextDouble())
            {
                numberList.add(in.nextDouble());
                in.nextLine();
            }
        }
        catch(FileNotFoundException e)
        {
            System.err.println(e);
        }

        return numberList;
    }

    /**
     * Get the number range(Max and Min)
     * @param numberpoints
     * @return range(type double max or min).
     */
    public double [] getRange(int numberPoints)
    {
        double [] range = new double[2];

        range[0] = Double.MAX_VALUE;
        range[1] = Double.MIN_VALUE;

        double temp;

        for (int i = 0; i < Math.min(numberPoints, numbers.size()); i++)
        {
            temp = numbers.get(i);

            if(temp < range[0])
            {
                range[0] = temp;
            }

            if(temp > range[1])
            {
                range[1] = temp;
            }
        }
        return range;
    }
    
    /**
     * Get the size of the numbers(file)
     * @return numbers.size().
     */
    public int getSize()
    {
        return numbers.size();
    }
    
    /**
     * Get the value from file.
     * @return numbers.get(i);
     */
    public double getValue(int i)
    {
        return numbers.get(i);
    }
}