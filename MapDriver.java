import java.util.*;
import java.lang.*;
import java.io.*;

public class MapDriver
{
    
  public static void main(String[] args)
  {
    Scanner input;
    String filename = "map.txt";

    NodeList map = new NodeList();
    
    try
    {
      input = new Scanner(new File(filename));
      String[] values;

      while(input.hasNext())
      {
        values = input.nextLine().trim().split("\\|");
        map.add(new MapPoint(values[0], values[1], Integer.parseInt(values[2])));
      }
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
    NodeList mstMap = map;
    MST mst = new MST(mstMap, "Grand Forks");
    mst.driveTo(mst.start);
    System.out.println(mst.getStats());
    
    //Depth First Search
    NodeList dfsMap = map;
    DFS dfs = new DFS(dfsMap);
    dfs.drive("Grand Forks");
    
  }
  
}
