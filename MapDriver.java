import java.util.*;
import java.lang.*;
import java.io.*;

public class MapDriver
{
  public static void main(String[] args)
  {
    File file;
    Scanner input;
    String filename = "map.txt";

    NodeList map = new NodeList();
    //int i = 0;
    
    try
    {
      file = new File(filename);
      input = new Scanner(file);
      String[] values = new String[3];

      while(input.hasNext())
      {
        String inputFile = input.nextLine().trim();
        System.out.println(inputFile);
        values = inputFile.split("|");
        char foo = '|';
        int ascii = (int)foo;
        System.out.println(ascii);
        //System.out.println("1\n");
        System.out.println(values[0] + ", " + values[1] + ", " + values[2]);
        //System.out.println("2\n");
        MapPoint newPoint = new MapPoint(values[0], values[1], Integer.parseInt(values[2]));
        //System.out.println("3\n");
        map.add(newPoint);
        //System.out.println("4\n");
     //   if(i == 0)
     //     head = newPoint;
     //   i++;
      }
    }
    catch(Exception e)
    {
      System.out.println("ERROR");
    }
  } 
}
