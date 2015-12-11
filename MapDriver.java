import java.util.*;
import java.lang.*;
import java.io.*;

public class MapDriver
{
	private static int cities = 1;
	private static int totWeight = 0;
	private static ArrayList<String> cityNames = new ArrayList<String>();

	public static void DFS(NodeList m, String start)
	{
		cityNames.add(start);

		ArrayList<MapPoint> mp = m.searchAll(start);

		for(int i = 0; i < mp.size(); i++)
		{
			if(mp.get(i).getVisit() == false && mp.get(i).getBackEdge() == false && !cityNames.contains(mp.get(i).getEndPoint()))
			{
				mp.get(i).setVisit(true);
				mp.get(i).setBackEdge(true);

				String search = mp.get(i).getEndPoint();
				System.out.println("City: " + search);

				totWeight = totWeight + mp.get(i).getDistance();
				System.out.println("Total Weight: " + totWeight);

				cities = cities + 1;
				System.out.println("# of Cities: " + cities);

				System.out.println("");

				DFS(m, search);
			}
			
		}

	}


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

			//String output = map.toString();
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

		/*MST herp = new MST(map, "Grand Forks");
		herp.driveTo("Grand Forks");
		System.out.println(herp.getStats());*/

		String start = "Grand Forks";

		System.out.println("City: " + start);
		System.out.println("Total Weight: " + totWeight);
		System.out.println("# of Cities: " + cities);
		System.out.println("");

		DFS(map, start);

		/*for(int x = 0; x < cityNames.size(); x++)
		{
			System.out.println(cityNames.get(x));
		}*/
	}
}
