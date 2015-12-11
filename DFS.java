import java.util.ArrayList;

public class DFS
{
    
    private  int cities = 1;
    private int totWeight = 0;
    private NodeList m;
    private ArrayList<String> cityNames = new ArrayList<>();
    
    public DFS(NodeList m){
        
        this.m = m;
        
    }
    
    public void drive(String start){
      
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

		drive(search);
	    }
			
	}        
        
    }
        
}
