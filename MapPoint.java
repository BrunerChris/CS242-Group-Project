public class MapPoint
{
	private String StartingPoint = null;
	private String EndingPoint = null;
	private int distance = 0;
	private boolean visited = false;
	private boolean backEdge = false;

	public MapPoint(String sp, String ep, int d)
	{
		StartingPoint = sp;
		EndingPoint = ep;
		distance = d;
		visited = false;
		backEdge = false;
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

	public boolean getVisit()
	{
		return visited;
	}

	public boolean getBackEdge()
	{
		return backEdge;
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

	public void setVisit(boolean b)
	{
		visited = b;
	}

	public void setBackEdge(boolean t)
	{
		backEdge = t;
	}

	public String toString()
	{
		String output = "Starting point: " + getStartPoint() + "\nEnding point: " + getEndPoint() + "\nDistance: " + getDistance();
		return output;
	}

}
