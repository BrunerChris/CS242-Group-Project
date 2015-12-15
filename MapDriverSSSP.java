import java.util.*;
import java.lang.*;
import java.io.*;

public class MapDriverSSSP
{
  public static String SSSP(NodeList map, String source, String target)
  {
    ArrayList<Vertex> Q = new ArrayList<Vertex>();
    Node current = map.getHead();
    boolean flag = false;
    while(current != null)
    {
      Vertex v = new Vertex(current.getData(), Integer.MAX_VALUE, null);

      //find source Vertex
      if(v.getData().getStartPoint().equals(source) && !flag)
      {
        v.setDist(0);
        flag = true; //make only the first instance of source the beginning vertex
      }

      Q.add(v);
      current = current.getNext();
    }

    String out = "";

    ArrayList<String> visited = new ArrayList<String>();

    int min, foo, ctr=1;
    Vertex u;
    while(!Q.isEmpty())
    {
      //find minimum Vertex
      min = 10000; foo = 0;
      u = null;
      for(int j=0; j<Q.size(); j++)
      {
        foo = Q.get(j).getDist();
        if(foo < min)
        {
          min = foo;
          u = Q.get(j);
        }
      }
//System.out.println("minimum Vertex = " + u.getData().toString() + "\n" +  u.getDist());

      if(u.getData().getStartPoint().equals(target))
      {
        out = out + "Found Seattle!";
        break;
      }
      else
      {
        //find neighbors of u
        String start = "";
//        if(ctr == 1)
//          start = u.getData().getStartPoint();
//        else
//          start = u.getData().getEndPoint();

        start = u.getData().getStartPoint();
//        start = u.getData().getEndPoint();
        if(!visited.contains(start))// || visited.contains(u.getData().getEndPoint()))
          visited.add(start);

        ArrayList<MapPoint> mp = map.searchAllSSSP(start);

//for(MapPoint m : mp)
//  System.out.println("mp = " + m.toString());

        int altDist = 0;

//        Q.remove(u);

        //look through each neighbor to find shortest path
        Vertex neighbor = null;
        int pos = 0;
        for(int k=0; k<mp.size(); k++)
        {
          if(visited.contains(mp.get(k)))
            continue;
          //find corresponding Vertex
          for(Vertex v : Q)
          {
            if(v.getData().equals(mp.get(k)))
            {
              neighbor = v;
//System.out.println("\nneighbor = " + neighbor.getData().toString());
            }
          }
          
          if(k == 0)
            Q.remove(u);

          altDist = u.getDist() + mp.get(k).getDistance();
          if(altDist < neighbor.getDist())
          {
            //set distance of neighbor vertex to altDist
            neighbor.setDist(altDist);
            //set previous Vertex of the neighbor to u
            neighbor.setPrev(u);
            Q.add(neighbor);
          }
        }
        //out = out + u.getData().getEndPoint();
        out = out + start;
//System.out.println("\nout = " + out);
//for(Vertex v : Q)
//{
//  System.out.println(v.getData().getStartPoint() + " " + v.getData().getEndPoint() + " " + v.getDist());
//}
      }
    }
    return out;
  }

  public static void main(String[] args)
  {
    File file;
    Scanner input;
    String filename = "map.txt";

    NodeList map = new NodeList();
    NodeList ShortList = new NodeList();
    
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

      //ShortList = SSSP(map);
      //String output = ShortList.toString();
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

    String out = SSSP(map, "Grand Forks", "Seattle");
    System.out.println(out);
  } 
}
