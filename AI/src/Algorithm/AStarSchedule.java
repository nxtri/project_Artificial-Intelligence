
package Algorithm;

import Model.Dust;
import Model.Map;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class AStarSchedule {
    //Ma trận khoảng cách (chi phí) giữa 2 điểm
    int distanceMap[][];
    Map map;
    
    AStarPathFinding as = new AStarPathFinding();
    List<Dust> dustList;
    
    //Constructor
    public AStarSchedule(List<Dust> dustList)
    {
        //Khởi tạo
        this.dustList = dustList;
        map = Map.getInstance();
        
        int size = dustList.size();
        //Khởi tạo ma trận chi phí giữa các điểm
        distanceMap = new int[size][size];
        
        //Tính quãng đường giữa 2 điểm (ma trận chi phí)
        //Tính quãng đường từ i -> j ==> quãng đường j -> i = i -> j
        //Khoảng cách tới chính nó = 0
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(i == j) distanceMap[i][j] = 0;
                else
                {
                    //Khoảng cách từ i -> j
                    distanceMap[i][j] = distance(dustList.get(i).getPxy(), dustList.get(j).getPxy());
                    distanceMap[j][i] = distanceMap[i][j];
                }
            }
        }
        
//        for(Dust d : dustList) System.out.println(d.getPxy().toString());
//        
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                System.out.print(distanceMap[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    
    //Thực hiện tìm lộ trình bắt đầu từ điểm đầu tiên bằng A*
    public List<Point> getSchedule()
    {
        int[] index = createSchedule(dustList);
        List<Point> list = new ArrayList<>();
        
        for(int i = 0; i < index.length; i++)
        {
            //System.out.println((index[i] + 1) + " ");
            list.add(dustList.get(index[i]).getPxy());
        }
        
        return list;
    }
    
    
    
    //Tính khoảng cách giữa 2 điểm dựa vào A*
    private int distance(Point pStart, Point pTarget)
    {
        //return Math.abs(pStart.x - pTarget.x) + Math.abs(pStart.y - pTarget.y);
        //return (int) Math.sqrt(Math.pow((pStart.x - pTarget.x),2) + Math.pow((pStart.y - pTarget.y),2));
        return as.getShortestPath(map.getM(), pStart, pTarget).size();
    }
    
    
    
    //Thuật toán A* sử dụng hàm heuristic là MST: cây khung nhỏ nhất
    private int[] createSchedule(List<Dust> listDust)
    {
        int size = listDust.size();
        
        List<NodeAS> closeList = new ArrayList<>();
        
        //PriorityQueue: hàng đợi ưu tiên (ưu tiên: theo thứ tự tăng dần), vào trước ra trước
        //Các node khi được thêm vào sẽ sắp xếp theo thứ tự tăng dần của fCost
        //Khi lấy node ra <=> lấy ptử có fCost min       
        PriorityQueue<NodeAS> openList = new PriorityQueue<>();
        
        //Khởi tạo node start là vị trí đầu tiên (vị trí bắt đầu - [0,0]) với path rỗng
        //Path: chứa vị trí các điểm tương ứng trong listDust (các đỉnh đã duyệt rồi)
        // 0 <=> listDust.get(0) ...
        int[] initialPath = {};
        NodeAS start = new NodeAS(initialPath, 0, 0, listDust.get(0), 0);
        
        openList.add(start);
        
        while(openList.size() > 0)
        {
            //Lấy ra p` tử có fCost nhỏ nhất nhờ PriorityQueue
            NodeAS current = openList.remove();
            
            //path của node current (các đỉnh đã qua)
            int[] path = current.path;
            
            if(path != null)
            {
                //Trường hợp độ dài path == size (kích thước list Dust) <=> Đến đích
                if(path.length == size)
                {
                    return current.path;
                }

                //int[] neighbours: mảng vị trí tất cả các điểm tương ứng trong listDust
                //XĐ các điểm chưa đi qua
                //Thuộc path (đã đi qua) -> gán = 0, không thuộc path (chưa đi qua) -> gán = 1
                int[] neighbours = new int[size];
                Arrays.fill(neighbours, 1); //Fill: gán tất cả giá trị của neighbours[] = 1
                //Nếu đã có trong path => gán = 0
                for(int i : path) neighbours[i] = 0;


                for (int i = 0; i < size; i++) 
                {
                    if(neighbours[i] != 0) //Các node hàng xóm không thuộc path (chưa duyệt)
                    {
                        //Thêm các điểm chưa duyệt vào ds
                        List<Dust> remainingDust = new ArrayList<>(); //chứa các điểm còn lại mà chưa duyệt
                        for(int k = 0; k < size; k++)
                        {
                            // k != i -> bỏ qua vị trí đang xét neighbours[i]
                            if (neighbours[k] == 1 && k != i) {
                                remainingDust.add(listDust.get(k));
                            }
                        }
                        
                        //Tính các hàm đánh giá của neighbours[i]
                        int hCost = remainingDust.size() == 0 ? 0 : MST(remainingDust);
                        int gCost = current.gCost + distanceMap[current.index][i]; // khoảng cách từ index của current -> i
                        int fCost = gCost + hCost;
                        
                        //Thêm vào path
                        int[] newPath = new int[path.length + 1];
                        for (int j = 0; j < path.length; j++) {
                            newPath[j] = path[j];
                        }
                        newPath[path.length] = i;

                        NodeAS node = new NodeAS(newPath, gCost, fCost, listDust.get(i), i);
                        openList.add(node);
                    }
                }
                closeList.add(current);
            }
        }
        
        return null;
    }
    
    
    
    //Tạo Minimum Spanning Tree (MST) dựa vào list dust
    //Áp dụng thuật toán Prim's
    private int MST(List<Dust> list)
    {
        int size = list.size();
        
        //Khởi tạo
        int[] distance = new int[size];
        int[] parent = new int[size]; //điểm trước đó
        boolean[] visited = new boolean[size]; //đánh dấu điểm đó đã thăm hay chưa
        
        for(int i = 0; i < distance.length; i++) distance[i] = Integer.MAX_VALUE;
        
        //bđ từ vị trí 0
        distance[0] = 0;
        
        for(int i = 0; i < distance.length; i++)
        {
            //Chọn ví trị tiếp theo có khoảng cách nhỏ nhất mà chưa thăm
            int next = minDistance(distance, visited);
            //Gán vị trí đó đã thăm
            visited[next] = true;
            
            for (int j = 0; j < size; j++) {
                if (j != next && !visited[j]) {
                    int d = distanceMap[next][j];
                    //Update khoảng cách và parent array
                    if (distance[j] > d) {
                        distance[j] = d;
                        parent[j] = next;
                    }
                }
            }
        }
        
        //Tính tổng giá trị các cạnh của cây khung nhỏ nhất
        int sum = 0;
        
        for (int i = 0; i < parent.length; i++) {
            sum += distanceMap[i][parent[i]];
        }

        return sum;
    }
    
    
    
    //Duyệt mảng distance để được node gần nhất chưa thăm
    private int minDistance(int[] distance, boolean [] b)
    {
        int maxInt = Integer.MAX_VALUE;
        int index = -1;
        
        for (int i = 0; i < distance.length; i++) {
            if (!b[i] && distance[i] < maxInt) {
                index = i;
                maxInt = distance[i];
            }
        }
        
        return index;
    }
    
    
    
}
