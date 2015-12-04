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

  public void getEndPoint(String input)
  {
    EndingPoint = input;
  }

  public void getDistance(int input)
  {
    distance = input;
  }

  public String toString()
  {
    String output = "Starting point: " + getStartPoint() + "\nEnding point: " + getEndPoint() + "\nDistance: " + getDistance();

    return output;
  }
}
