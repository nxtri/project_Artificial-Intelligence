
package Algorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AStarPathFinding {
    
    //Tìm quãng đường từ start đến target trong ma trận 2d m
    public List<Point> getShortestPath(int[][] m, Point pStart, Point pTarget)
    {
        List<Point> path = new ArrayList<>();
        
        List<DustInfo> listDust = findPath(m, pStart, pTarget);
        
        if(listDust != null) 
        {
            for(DustInfo di : listDust)
            {
                path.add(new Point(di.x, di.y));
            }
        }
        
        return path;
    }
    
    //Lấy hàng xóm xung quanh của di (trên, dưới, trái, phải)
    public List<DustInfo> getNeighbours(DustInfo di, DustInfo[][] m) {
        List<DustInfo> neighbours = new ArrayList<>();

        //Trên
        if (di.x - 1 >= 0) {
            neighbours.add(m[di.x - 1][di.y]);
        }
        //Dưới
        if (di.x + 1 < m.length) {
            neighbours.add(m[di.x + 1][di.y]);
        }
        //Trái
        if (di.y - 1 >= 0) {
            neighbours.add(m[di.x][di.y - 1]);
        }
        //Phải
        if (di.y + 1 < m[0].length) {
            neighbours.add(m[di.x][di.y + 1]);
        }
        
        //Trường hợp đi chéo
//        if(allowDiagonals)
//        {
//            //
//            if (di.x - 1 >= 0 && di.y - 1 >= 0) {
//                neighbours.add(m[di.x - 1][di.y - 1]);
//            }
//            //
//            if (di.x + 1 < m.length && di.y + 1 < m[0].length) {
//                neighbours.add(m[di.x + 1][di.y + 1]);
//            }
//            //
//            if (di.x + 1 < m.length && di.y - 1 >= 0) {
//                neighbours.add(m[di.x + 1][di.y - 1]);
//            }
//            //
//            if (di.x - 1 >= 0 && di.y + 1 < m[0].length) {
//                neighbours.add(m[di.x - 1][di.y + 1]);
//            }
//        }
        
        return neighbours;
    }
    
    
    public List<DustInfo> findPath(int[][] matrix, Point start, Point target)
    {
        // ========== Gán thông tin của matrix vào ma trận 2 chiều với các phần tử là DustInfo tương ứng ==========
        
        int m = matrix.length; // <=> row
        int n = matrix[0].length; // <=> col
        
        DustInfo[][] dustMap = new DustInfo[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] < 2) dustMap[i][j] = new DustInfo(i, j, true);
                else dustMap[i][j] = new DustInfo(i, j, false);
            }
        }
   
        // ========== Bắt đầu A* Algorithm ==========
        
        //Gán điểm bắt đầu và điểm đích lên ma trận các phần tử dustInfo
        DustInfo diStart = dustMap[start.x][start.y];
        DustInfo diTarget = dustMap[target.x][target.y];
        
        //Khai báo List "open": lưu trữ các điểm xét tiếp theo (hàng xóm xung quanh của điểm hiện tại)
        List<DustInfo> open = new ArrayList<>();
        //Khai báo list "close": chứa các điểm đã được xét ==> không xét lại nhiều lần
        List<DustInfo> close = new ArrayList<>();
        
        //Thêm điểm bắt đầu vào openList
        open.add(diStart);
        
        while(open.size() > 0)
        {
            //Tìm điểm trong danh sách có FCost = min
            DustInfo diCurrent = open.get(0);
            
            for(DustInfo di : open)
            {
                if(di.getFCost() < diCurrent.getFCost() || di.getFCost() == diCurrent.getFCost() && di.hCost < diCurrent.hCost) 
                    diCurrent = di;
            }
            
            //Xóa điểm có fCost min khỏi danh sách các điểm cần xét
            open.remove(diCurrent);
            //Thêm điểm đó vào close
            close.add(diCurrent);
            
            //Nếu là điểm đích thì trả về đường đi từ start đến target
            if(diCurrent == diTarget) return path(diStart, diTarget);//----
            
            //Lấy các điểm hàng xóm của điểm hiện tại
            List<DustInfo> neighbours = getNeighbours(diCurrent, dustMap);
            
            //thêm các hàng xóm vào open nếu thỏa mãn
            for(DustInfo neighbour : neighbours)
            {
                //Kiểm tra điểm đó có là vật cản không? hoặc điểm đó đã được xem xét (có trong close)
                if(!neighbour.walkable || close.contains(neighbour)) continue;
                
                //Tính khoảng cách từ current tới neighbour
                double newDistanceToNeighbour = diCurrent.gCost + distance(diCurrent, neighbour);
                
                /*
                //Trường hợp neighbour đã có trong open
                if(open.contains(neighbour))
                {
                    //So sánh gCost
                    if(newDistanceToNeighbour < neighbour.gCost)
                    {
                        neighbour.gCost = newDistanceToNeighbour;
                        neighbour.hCost = distance(diCurrent, neighbour);
                        neighbour.parent = diCurrent;
                    }
                }
                else //Trường hợp neighbour không có trong open
                {
                    //Cập nhật gCost, hCost và parent của neighbour
                    neighbour.gCost = newDistanceToNeighbour;
                    neighbour.hCost = distance(diCurrent, neighbour);
                    neighbour.parent = diCurrent;
                    
                    //Thêm vào open
                    open.add(neighbour);
                }
                */
                
                //Ghép lại trường hợp trên: 
                //  Nếu có trong open --> cập nhật lại g,h,parent
                //  Nếu không có thì thêm vào open                                        
                if(newDistanceToNeighbour < neighbour.gCost || !open.contains(neighbour))
                {
                    neighbour.gCost = newDistanceToNeighbour;
                    neighbour.hCost = distance(diCurrent, neighbour);
                    neighbour.parent = diCurrent;
                    
                    if(!open.contains(neighbour)) open.add(neighbour);
                }
            }
        }

        //Open set is empty but goal was never reached
        return null;
    }
    
    
    // Hàm heuristic ==> tính khoảng cách giữa 2 điểm
    private double distance(DustInfo diStart, DustInfo diTarget)
    {
        //Khoảng cách euclid tối ưu hơn khi cho phép đường chéo
        //return Math.sqrt(Math.pow(diTarget.x - diStart.x, 2) + Math.pow(diTarget.y - diStart.y, 2));
        
        //Khoảng cách manhattan tối ưu hơn khi không cho phép đi chéo
        return Math.abs(diStart.x - diTarget.x) + Math.abs(diStart.y - diTarget.y);
    }
    
    
    //Quãng đường từ start tới target 
    private List<DustInfo> path(DustInfo diStart, DustInfo diTarget)
    {
        List<DustInfo> path = new ArrayList<>();
        
        //Duyệt từ target để lấy parent
        DustInfo diCurrent = diTarget;
        
        // Lấy parent lần lượt của các điểm <=> Quãng đường cần tìm bị đảo ngược
        // Start = [0,0], target = [4,4]    
        // [0,0] --> [1,1] --> [2,2] --> [3,3] --> [4,4]
        // Parent của start là null, Parent của [1,1] là [0,0] ...
        // Sau while path = {[4,4],[3,3],[2,2],[1,1],[0,0]}
        while (diCurrent != diStart) {
            path.add(diCurrent);
            diCurrent = diCurrent.parent;
        }
        
        //Đảo ngược lại list để được quãng đường
        Collections.reverse(path);
        
        return path;
    }
    
    
    
    //Class DustInfo chứa thông tin mỗi p` tử
    class DustInfo
    {
        boolean walkable;
        int x, y;
        double gCost, hCost;
        DustInfo parent;

        public DustInfo(int x, int y, boolean walkable) {
            this.walkable = walkable;
            this.x = x;
            this.y = y;
        }
        
        public double getFCost()
        {
            return gCost + hCost;
        }
           
    }
    
}
