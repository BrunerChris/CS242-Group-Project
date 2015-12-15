import java.util.*;

public class SSSP
{
  private NodeList map = null;

  public SSSP(NodeList m)
  {
    map = m;
  }

  public static String drive(NodeList map, String source, String target)
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

    int min, foo;
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

      if(u.getData().getStartPoint().equals(target))
      {
        //print out cities from target to source starting at target
        while(u.getPrev() != null)
        {
          out = out + u.getData().getStartPoint() + ", " + u.getDist() + "\n";
          u = u.getPrev();
        }

        //print out source
        out = out + u.getData().getStartPoint() + ", " + u.getDist() + "\n";
        return out;
      }
      else
      {
        //find neighbors of u
        String start = "";
        start = u.getData().getEndPoint();
        ArrayList<MapPoint> mp = map.searchAllSSSP(start);

        int altDist = 0;

        //look through each neighbor to find shortest path
        Vertex neighbor = null;
        int pos = 0;
        int len = mp.size();
        for(int k=0; k<len; k++)
        {
          //find corresponding Vertex to this neighbor
          for(Vertex v : Q)
          {
            if(v.getData().equals(mp.get(k)))
            {
              neighbor = v;
            }
          }

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
        out = out + ", " +  start;
      }

      //print out for testing purposes
      System.out.println("\nout = " + out);
    }
    return out;
  }
}
