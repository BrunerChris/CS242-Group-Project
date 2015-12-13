public class MapPoint
{
  private String StartingPoint = null;
  private String EndingPoint = null;
  private int distance = 0;

  public MapPoint(String sp, String ep, int d)
  {
    StartingPoint = sp;
    EndingPoint = ep;
    distance = d;
  }

  public String getStartPoint()
  {
    return StartingPoint;
  }

  public String getEndPoint()
  {
    return EndingPoint;
  }

  public int getDistance()
  {
    return distance;
  }

  public void setStartPoint(String input)
  {
    StartingPoint = input;
  }

  public void setEndPoint(String input)
  {
    EndingPoint = input;
  }

  public void setDistance(int input)
  {
    distance = input;
  }

  public String toString()
  {
    String output = "Starting point: " + getStartPoint() + "\nEnding point: " + getEndPoint() + "\nDistance: " + getDistance();

    return output;
  }

  public boolean equals(MapPoint p)
  {
    if(this.getStartPoint().equals(p.getStartPoint()) && this.getEndPoint().equals(p.getEndPoint()) && this.getDistance() == p.getDistance())
      return true;
    else
      return false;
  }
}
