public class Vertex
{
  private MapPoint current = null;
  private int distance = Integer.MAX_VALUE;
  private Vertex prev = null;

  public Vertex(MapPoint c, int d, Vertex p)
  {
    current = c;
    distance = d;
    prev = p;
  }

  public MapPoint getData()
  {
    return current;
  }

  public void setDist(int input)
  {
    distance = input;
  }

  public int getDist()
  {
    return distance;
  }

  public void setPrev(Vertex input)
  {
    prev = input;
  }
  
  public Vertex getPrev()
  {
    return prev;
  }
}
