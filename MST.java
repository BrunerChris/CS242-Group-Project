
import java.util.ArrayList;

public class MST {
    
    ArrayList<MapPoint> roads = new ArrayList<>();
    NodeList map;
    String start;
    
    public MST(NodeList map, String sp){        
        this.map = map;
        this.start = sp;
    }
    
    //make this recursive?
    public void driveTo(String sp){
        //Search for the smallest distance MapPoint based on given starting point.
        ArrayList<MapPoint> mp = map.searchAll(sp);
        MapPoint d = mp.get(0);
        for(int i = 1; i < mp.size(); i++){
            if((mp.get(i).getDistance() < d.getDistance())  ) //add notVisited logic check
                d = mp.get(i);
        }
         
        this.roads.add(d);
        System.out.println(d.getEndPoint());
        //return driveTo(d.getEndPoint());
        
    }
    
    public static void main(String[] args){
        
        
        
    }
   
}
