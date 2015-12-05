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
        values = inputFile.split("\\|");

        MapPoint newPoint = new MapPoint(values[0], values[1], Integer.parseInt(values[2]));
        map.add(newPoint);
     //   if(i == 0)
     //     head = newPoint;
     //   i++;
      }
    }
    catch(FileNotFoundException | NumberFormatException e)
    {
      System.out.println("ERROR");
    }
    
  } 
}
