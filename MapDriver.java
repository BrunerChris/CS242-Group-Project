import java.util.*;
import java.lang.*;
import java.io.*;
public class MapDriver
{

	public static void DFS(NodeList m, Node v, int totWeight)
	{
		v.setVisit(true);

		ArrayList<MapPoint> mp = m.searchAll(v.getData().getStartPoint());

		for(int i = 0; i < mp.size(); i++)
		{
			if(mp.get(i).getVisit() == false)
			{
				String search = mp.get(i).getEndPoint();
				if(search.equals(null))
				{
					DFS(m, v.getPrevious(), totWeight);
				}

				System.out.println(search);
				totWeight = totWeight + mp.get(i).getDistance();
				System.out.println(totWeight);

				//ArrayList<MapPoint> mp = m.searchAll(v.getData().getStartPoint());
				Node w = m.search(search);

				if (w.getVisit() == false)
				{
					mp.get(i).setVisit(true);
					DFS(m, w, totWeight);
				}
				else
				{
					mp.get(i).setBackEdge(true);
					DFS(m, v.getPrevious(), totWeight);
				}
			}
		}

		System.out.println(totWeight);
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

			String output = map.toString();
			System.out.println(output);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
		}
		catch(NumberFormatException e)
		{
			System.out.println("Number format exception.");
		}

		Node start = map.search("Grand Forks");

		int totWeight = 0;
		DFS(map, start, totWeight);

	}
}
