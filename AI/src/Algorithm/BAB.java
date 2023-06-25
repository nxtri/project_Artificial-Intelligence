
package Algorithm;

import Model.Dust;
import Model.Map;
import java.awt.Point;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Đ.Tee
 */
public class BAB {
    
    AStarPathFinding as = new AStarPathFinding();
    Map map;
    List<Dust> dustList;
    
    int[][] distances;
    int best_cost;
    int[] best_path;
    
    public BAB(List<Dust> dustList) {
        //Khởi tạo
        this.dustList = dustList;
        map = Map.getInstance();
        
        int size = dustList.size();

        distances = new int[size][size];
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(i == j) distances[i][j] = 0;
                else
                {
                    //Khoảng cách từ i -> j
                    distances[i][j] = distance(dustList.get(i).getPxy(), dustList.get(j).getPxy());
                    distances[j][i] = distances[i][j];
                }
            }
        }
        
    }
    
    //Tính khoảng cách giữa 2 điểm dựa vào A*
    private int distance(Point pStart, Point pTarget)
    {
//        double px = pStart.getX() - pTarget.getX();
//        double py = pStart.getY() - pTarget.getY();
//        return Math.sqrt(px * px + py * py);
        return as.getShortestPath(map.getM(), pStart, pTarget).size();
    }
    
    public double getCost() {
        return best_cost;
    }
    
    public int[] calculate() {
        HashSet<Integer> location_set = new HashSet<Integer>(distances.length);
        for (int i = 0; i < distances.length; i++) {
            location_set.add(i);
        }
        
        best_cost = findGreedyCost(0, location_set, distances);
        System.out.println("==== " + best_cost + " ====");
        
        int[] active_set = new int[distances.length];
        for (int i = 0; i < active_set.length; i++) {
            active_set[i] = i;
        }

        NodeBAB root = new NodeBAB(null, 0, distances, active_set, 0);
        traverse(root);
        
        return best_path;
    }
    
    private int findGreedyCost(int i, HashSet<Integer> location_set, int[][] distances) {

        location_set.remove(i);

        if (location_set.isEmpty()) {
            return distances[0][i];
        }
        
        int lowest = Integer.MAX_VALUE;
        int closest = 0;
        
        for (int location : location_set) {
            int cost = distances[i][location];
            if (cost < lowest) 
            {
                lowest = cost;
                closest = location;
            }
        }
        
        return lowest + findGreedyCost(closest, location_set, distances);
    }
    
    private void traverse(NodeBAB parent) {
        NodeBAB[] children = parent.generateChildren();

        for (NodeBAB child : children) 
        {
            if (child.isTerminal()) 
            {
                int cost = child.getPathCost();
                if (cost < best_cost) 
                {
                    best_cost = cost;
                    best_path = child.getPath();
                }
            } 
            else if (child.getLowerBound() <= best_cost) 
            {
                traverse(child);
            }
        }
    }
    
}
