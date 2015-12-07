public class DFS
{
	public DFS(NodeList m, Node v)
	{
		//System.out.println("You made it in the constructor");

		int totWeight = 0;
		v.setVisit(true);



		//NOT DONE YET
		/*for (MapPoint mp :
		{
			if(mp.getVisit() == false)
			{
				Node w = mp.getEndPoint();
				if (w.getVisit() == false)
				{
					totWeight = totWeight + mp.getDistance();
					mp.setVisit(true);
					DFS go2 = new DFS(m, w);
				}
				else
				{
					mp.setBackEdge(true);
					DFS go3 = new DFS(m, v);
				}
			}
		}*/
	}
}
