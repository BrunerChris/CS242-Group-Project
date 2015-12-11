import java.util.*;
import java.lang.*;
import java.io.*;

public class MapDriver
{
  
  public static NodeList createMap(){
     
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
    
    return map;
  }  
    
  public static void main(String[] args)
  {
        
    //Minimum Spanning Tree
    NodeList map = createMap();
    MST mst = new MST(map, "Grand Forks");
    mst.driveTo(mst.start);
    System.out.println(mst.getStats());
    
    System.out.println();
    
    //Depth First Search
    map = createMap();
    DFS dfs = new DFS(map);
    dfs.drive("Grand Forks");
    
  }
  
}
