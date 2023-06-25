
package Algorithm;

import Model.Dust;
import Model.Map;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestAlgorithm {
    public static void main(String[] args) {
        //int m[][] = {{0,0,0,0},{0,2,0,0},{0,0,2,0},{0,0,0,1},{0,1,0,0}};
        
//        for(int i = 0; i < 5; i++)
//        {
//            System.out.println("");
//            for(int j = 0; j < 5; j++)
//                System.out.print(m[i][j] + " ");
//        }
        
//        BFS spbcbfs = new BFS();
//        List<Point> listBFS = spbcbfs.getShortestPath(m.getM(), new Point(0, 0), new Point(9,9));
//        
//        for(Point p : listBFS) System.out.println(p.toString());
        
//        System.out.println("=======================");
//        
//        AStarPathFinding as = new AStarPathFinding();
//        List<Point> listAStar = as.getShortestPath(m.getM(), new Point(0, 0), new Point(9,9));
//        
//        for(Point p : listAStar) System.out.println(p.toString());

//        DustInfo di1 = new DustInfo(0, 0, 5);
//        DustInfo di2 = new DustInfo(0, 0, 3);
//        DustInfo di3 = new DustInfo(0, 0, 7);
//        DustInfo di4 = new DustInfo(0, 0, 1);
//        DustInfo di5 = new DustInfo(0, 0, 10);
//        
//        List<DustInfo> liDI = new ArrayList<>();
//        liDI.add(di1);
//        liDI.add(di2);
//        liDI.add(di3);
//        liDI.add(di4);
//        liDI.add(di5);
//        
//        Collections.sort(liDI, (a, b) -> a.numSteps - b.numSteps);
//        
//        for(DustInfo di : liDI)
//        {
//            System.out.println(di.numSteps);
//        }
        
//        int m[][] = {{0,0,0,0,2},{0,2,0,2,0},{0,0,2,0,0},{0,0,0,2,0},{0,2,0,0,0}};
//
//        AStarPathFinding as = new AStarPathFinding();
//        List<Point> listAStar = as.getShortestPath(m, new Point(3, 4), new Point(0,0));
//        for(Point p : listAStar) System.out.println(p.toString());
        
//        List<Point> listP = new ArrayList<>();
//        listP.add(new Point(0, 0));
//        listP.add(new Point(1, 0));
//        listP.add(new Point(2, 0));
//        listP.add(new Point(3, 0));
//        listP.add(new Point(4, 0));
//        
//        System.out.println(listP.size());


//        Map m = Map.getInstance();
//        m.createMap(10, 10, 10, 10);
//        m.printMap();
        
        System.out.println("======================================");
//        List<Point> listP = new ArrayList<>();
//        
//        for (int i = 0; i < m.getRow(); i++)
//            for (int j = 0; j < m.getCol(); j++)
//                if(m.getM()[i][j] == 1) listP.add(new Point(i, j));
        
//        List<Dust> listD = new ArrayList<>();
//        listD.add(new Dust(new Point(0,0)));
//        
//        for(int i = 0; i < m.getRow(); i++)
//        {
//            for(int j = 0; j < m.getCol(); j++)
//            {
//                if(m.getM()[i][j] == 1) listD.add(new Dust(new Point(i,j)));
//            }
//        }
//
//        AStarSchedule ass = new AStarSchedule(listD);
//        //ass.getSchedule();
//        
//        
//        List<Point> lp = ass.getSchedule();
//        System.out.println("============ LỊCH ==========================");
//        for(Point p : lp) System.out.println(p.toString());

//        int[][] map = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                       {0, 0, 0, 0, 0, 1, 1, 0, 2, 0},
//                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                       {0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
//                       {0, 4, 0, 0, 0, 0, 1, 2, 1, 0},
//                       {0, 1, 0, 0, 5, 0, 2, 0, 1, 0},
//                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//                       {0, 0, 0, 0, 5, 0, 0, 1, 1, 2},
//                       {0, 0, 0, 1, 0, 0, 4, 0, 0, 0},
//                       {0, 0, 0, 0, 0, 3, 0, 0, 0, 0}};
        
        List<Dust> dustList = new ArrayList<>();

        dustList.add(new Dust(new Point(0, 0)));
        dustList.add(new Dust(new Point(1, 7)));
        dustList.add(new Dust(new Point(4, 1)));
        dustList.add(new Dust(new Point(4, 6)));
        dustList.add(new Dust(new Point(4, 8)));
        dustList.add(new Dust(new Point(5, 7)));
        dustList.add(new Dust(new Point(7, 8)));
        dustList.add(new Dust(new Point(8, 3)));
        dustList.add(new Dust(new Point(8, 6)));
        dustList.add(new Dust(new Point(9, 2)));
        dustList.add(new Dust(new Point(9, 6)));
        
//        Map m = Map.getInstance();
//        m.createMap(10, 10, 10, 0);
//        //m.printMap();
//        
//        int index = 1;
//        for(int i = 0; i < m.getRow(); i++)
//        {
//            for(int j = 0; j < m.getCol(); j++)
//            {
//                if(m.getM()[i][j] == 1)
//                {
//                    System.out.println(index++ + " " + i + " " + j);
//                    dustList.add(new Dust(new Point(i, j)));
//                }
//            }
//        }
//        
//        
//
//        AStarSchedule aStarSchedule = new AStarSchedule(dustList);
//        BAB bab = new BAB(dustList);
//        
//        int[] path = bab.calculate();
//        
//        for(int i = 0; i < path.length; i++) {
//                    System.out.print(path[i] + " ");
//                                            
//                }System.out.print("0\n");
        
        int sum = MST(dustList);
        System.out.println("SUM = " + sum);

    }
    
    static int distanceMap[][] = { {0,8,5,10,12,12,15,11,14,11,15},
{8,0,9,4,4,4,7,11,8,13,9},
{5,9,0,5,7,7,10,6,9,6,10},
{10,4,5,0,2,2,5,7,4,9,5},
{12,4,7,2,0,2,3,9,6,11,7},
{12,4,7,2,2,0,3,7,4,9,5},
{15,7,10,5,3,3,0,6,3,8,4},
{11,11,6,7,9,7,6,0,3,2,4},
{14,8,9,4,6,4,3,3,0,5,1},
{11,13,6,9,11,9,8,2,5,0,4},
{15,9,10,5,7,5,4,4,1,4,0}
                            };
    
    static private int MST(List<Dust> list)
    {
        int size = list.size();
        
        //Khởi tạo
        int[] distance = new int[size];
        int[] pred = new int[size]; //điểm trước đó
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
            
            //Cập nhật khoảng cách từ next -> các vị trí còn lại
            //Cập nhật vị trí trước đó là next
            for (int j = 0; j < size; j++) {
                if (j != next && !visited[j]) {
                    int d = distanceMap[next][j];
                    //Update khoảng cách và pred array
                    if (distance[j] > d) {
                        distance[j] = d;
                        pred[j] = next;
                        
                    }
                }
            }
        }
        
        
        
        //Tính tổng giá trị các cạnh của cây khung nhỏ nhất
        int sum = 0;
        
        for (int i = 0; i < pred.length; i++) {
            System.out.println(pred[i] + " --> " + i);
            sum += distanceMap[i][pred[i]];
        }

        return sum;
    }
    
    
    
    //Duyệt mảng distance để được node gần nhất chưa thăm
    static private int minDistance(int[] distance, boolean [] b)
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
    
    //
//    static class DustInfo
//    {
//        int x, y;
//        int numSteps;
//
//        public DustInfo(int x, int y, int numSteps) {
//            this.x = x;
//            this.y = y;
//            this.numSteps = numSteps;
//        }
//        
//    }

