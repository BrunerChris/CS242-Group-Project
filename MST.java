
import java.util.ArrayList;

public class MST {
    
    ArrayList<MapPoint> roads = new ArrayList<>();
    NodeList map;
    String start;
    
    public MST(NodeList map, String sp){        
        this.map = map;
        this.start = sp;
    }
    
    //add counter for total miles driven
    public void driveTo(String sp){
        //System.out.println("New drive...");

        ArrayList<MapPoint> mapPoints = map.searchAll(sp);
        if(mapPoints.isEmpty()){
            System.out.println("Dead end.");
            return;
        }
        
        MapPoint p = mapPoints.get(0);
        
        for(int i = 0; i < mapPoints.size(); i++){
            MapPoint thisPoint = mapPoints.get(i);
            if( (thisPoint.getDistance() <= p.getDistance()) && thisPoint.getVisit() == false)
                p = thisPoint;
        }

        this.roads.add(p);
        p.setVisit(true);
        map.search(p.getStartPoint()).setVisit(true);
        for(MapPoint m : mapPoints){
            m.setVisit(true);
        }
        
        System.out.println(p.getStartPoint()+"->"+p.getEndPoint());

        driveTo(p.getEndPoint()); 
    }
    
    public String getStats(){
        
        int roadsTravelled = roads.size();
        int distanceTravelled = 0;
        
        for(MapPoint p : roads)
            distanceTravelled+= p.getDistance();
        
        return "Travelled "+distanceTravelled+" miles on "+roadsTravelled+" roads.";        
    }
   
}
