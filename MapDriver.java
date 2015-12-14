import java.util.*;
import java.lang.*;
import java.io.*;

public class MapDriver
{

	public static NodeList createMap()
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

		return map;
	}  

	public static void main(String[] args)
	{
		String start = "Grand Forks";

		//Depth First Search
		System.out.println("DFS Results");
		System.out.println("");
		System.out.println(start);
		System.out.println("Total Weight: " + 0);
		System.out.println("# of Cities: " + 0);
		System.out.println("");

		NodeList map = createMap();
		DFS dfs = new DFS(map);
		dfs.drive(start);

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("");

		//Breadth First Search
		System.out.println("BFS Results");
		System.out.println("");
		map = createMap();
		BFS bfs = new BFS(map);
		bfs.drive(start);

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("");

		//Minimum Spanning Tree
		System.out.println("MST Results");
		System.out.println("");
		map = createMap();
		MST mst = new MST(map, start);
		mst.driveTo(mst.start);
		System.out.println(mst.getStats());

		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("");

	}

}
