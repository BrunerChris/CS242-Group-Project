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
      }

      String output = map.toString();
      //System.out.println(output);
    }
    catch(FileNotFoundException e)
    {
      System.out.println("File not found.");
    }
    catch(NumberFormatException e)
    {
      System.out.println("Number format exception.");
    }
    
    //Minimum Spanning Tree
    MST mst = new MST(map, "Grand Forks");
    mst.driveTo(mst.start);
    System.out.println(mst.getStats());
    
    //Depth First Search
    DFS dfs = new DFS(map);
    dfs.drive("Grand Forks");
    
  } 
}
