import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS{
    
    private int cityCount = 1;
    private int weight = 0;
    private NodeList map;
    private ArrayList<String> cities = new ArrayList<>();
    
    public BFS(NodeList m){
        
        this.map = m;
        
    }
    
    public void drive(String start){
        
        String s = start;
        Queue<MapPoint> q = new LinkedList();
        
        //Adds all connections from the start to the queue and sets them to visited.
        ArrayList<MapPoint> mp = map.searchAll(s);
        for(MapPoint p : mp){
            q.add(p);
            p.setVisit(true);
            weight = weight + p.getDistance();
            cities.add(p.getEndPoint());
            
            System.out.println(p.getStartPoint()+"->"+p.getEndPoint());
            System.out.println("Total Weight: " + weight);
            System.out.println("");
        }
        
        while(!q.isEmpty()){
            
            //dequeue the first MapPoint, set to visited and get all MapPoints from their endPoints.
            MapPoint n = q.poll();
            n.setVisit(true);
            mp = map.searchAll(n.getEndPoint());
            
            //goes through all points from the next city in the queue and adds them to the queue if unvisited.
            for(MapPoint p : mp){
                if(p.getVisit() == false && !cities.contains(p.getEndPoint())){
                    q.add(p);
                    p.setVisit(true);
                    weight = weight + p.getDistance();
                    cities.add(p.getEndPoint());
                    
                    System.out.println(p.getStartPoint()+"->"+p.getEndPoint());
                    System.out.println("Total Weight: " + weight);
                    System.out.println("");
                }
            }

        }

      }
    
}
