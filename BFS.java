
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
        Queue<Node> q = new LinkedList();
        Node root = map.search(s);
        
        //add where you start to the queue
        q.add(root);
        root.setVisit(true);
        
        while(!q.isEmpty()){
            
            //remove the first object in the queue
            Node v = q.poll();
            
            s = v.getData().getStartPoint();
            ArrayList<MapPoint> mapPoints = map.searchAll(s);
            for(//each node connected to the initial node){
                if(//the connected node has not been visited){
                    
                }
                
            }
//        if(mapPoints.isEmpty()){
//            return;
//        }
        
        }
        
    }
    
}
