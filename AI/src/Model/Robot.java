
package Model;

import Algorithm.AStarPathFinding;
import Algorithm.AStarSchedule;
import Commit.emptyCommit;
import Commit.mapCommit;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import Commit.robotCommit;
import javax.swing.JOptionPane;

public class Robot implements robotCommit{
    private mapCommit mc;
    private static Robot obj;
    private Map m;

    private AStarPathFinding AStar;
    
    private int i,j;
    public int count;
    
    List<Dust> listDust;
    
    public static Robot getInstance()
    {
        if(obj == null) obj = new Robot();
        return obj;
    }
    
    public void setRobotToMap(Map newMap, int newI, int newJ)
    {
        m = newMap;
        i = newI;
        j = newJ;
    }
    
    public void start(boolean dk)
    {
        if(mc == null) mc = new emptyCommit();
        
        AStar = new AStarPathFinding();
        
        listDust = new ArrayList<>();
        getListDust();        
        
        
//        if(dk == true) // có ràng buộc
//        {
//            JOptionPane.showMessageDialog(null, "Comming soon!");
//            return;
//        }
//        else //Không ràng buộc
//        {
            //---
            System.out.println("Vị trí bắt đầu: [" + i + ", " + j + "]");
            count = m.getDust(); // đếm số rác
            System.out.println("Số điểm cần đi qua: " + count);
            System.out.println("");

            //point: lưu tọa độ x,y trong ma trận
            //Point point = null;
            
            // quá trình tìm kiếm xung quanh và đi đến điểm đó
//            while (count != 0) {
//                point = searchShortestPoint(); // tìm ra điểm gần nhất với vị trí hiện tại
//                
//                if(point == null)
//                {
//                    updateError();
//                    go(0, 0);
//                    updateDone();
//                    return;
//                }
//                
//                System.out.println("Đi tới điểm [" + point.x + "," + point.y + "]");
//                go(point.x, point.y);
//                count--;
//                suck(); //tại điểm đó
//                System.out.println("Số điểm còn lại: " + count);
//            }

            AStarSchedule ass = new AStarSchedule(listDust);
            
            List<Point> listP = ass.getSchedule();
            
            listP.remove(0); // Xóa phần tử 0,0 <=> điểm đang đứng
            for(Point p : listP)
            {
                System.out.println("Đi tới điểm [" + p.x + "," + p.y + "]");
                go(p.x, p.y);
                count--;
                suck();
                System.out.println("Số điểm còn lại: " + count);
            }

            if(count == 0)
            {
                updateDone();
                go(0, 0);
            }
            else
            {
                updateError();
                updateDone();
                go(0, 0);
            }
        //}
    }
    
    // phương thức tìm điểm gần nhất so với vị trí hiện tại
//    private Point searchShortestPoint() {
//       
//        Point pMin = null;
//        int min = Integer.MAX_VALUE;
//        
//        for(Point p : listDust)
//        {
//            int numSteps = AStarPathFinding.getShortestPath(m.getM(), new Point(i, j), new Point(p.x, p.y)).size();
//            
//            if(numSteps == 0)
//            {
//                continue;
//            }
//            
//            if(numSteps < min)
//            {
//                min = numSteps;
//                pMin = p;
//            }
//        }
//
//        listDust.remove(pMin);
//        
//        return pMin;
//    }

    
    private void getListDust()
    {        
        listDust.add(new Dust(new Point(0, 0)));
        for(int h = 0; h < m.getRow(); h++)
        {
            for(int k = 0; k < m.getCol(); k++)
            {
                if(m.getM()[h][k] == 1 && AStar.getShortestPath(m.getM(), new Point(0,0), new Point(h,k)).size() != 0) 
                    listDust.add(new Dust(new Point(h,k)));
            }
        }
    }
    
    // phương thức cho Robot đi từ vị trí hiện tại đến vị trí [row, col]
    private void go(int row, int col)
    {      
        List<Point> lp = AStar.getShortestPath(m.getM(), new Point(i, j), new Point(row, col));

        for (Point p : lp) {
            goStepByStep(p.x, p.y);
        }        
    }
    
    // Thực hiện di chuyển từng bước đến điểm [row, col]
    private void goStepByStep(int row, int column) {
        int subRow = row - i;
        int subCol = column - j;
        
        if(subRow == 0)
        {
            if(subCol == 1)
            {
                right();
            }
            else left();
        }
        else if(subRow == 1) down();
        else up();
        
    }
    
    //Đi lên 1 ô
    private void up() {
        i = i - 1;
        System.out.println("Di chuyển lên đến: [" + i + ", "+ j + "]");
        updateMoveUp();
        return;
    }

    //Đi xuống 1 ô
    private void down() {   
        i = i + 1;
        System.out.println("Di chuyển xuống đến: [" + i + ", "+ j + "]");
        updateMoveDown();
        return;
    }

    //Sang trái 1 ô
    private void left() {
        j = j - 1;
        System.out.println("Di chuyển qua trái đến: [" + i + ", "+ j + "]");
        updateMoveLeft();
        return;
    }

    //Sang phải 1 ô
    private void right() {
        j = j + 1;
        System.out.println("Di chuyển qua phải đến: [" + i + ", "+ j + "]");
        updateMoveRight();
        return;
    }

    //Dọn rác
    private void suck() {
        m.getM()[i][j] = 0;        
        System.out.println("Đang ở vị trí: [" + i + ", " + j + "]");
        System.out.println("Trạng thái ma trận:");
        m.printMap();
        System.out.println("");
        updateSuck();
        //m.removeFromListDust(i, j);
        return;
    }
    
    @Override
    public void registry(mapCommit mc) {
        this.mc = mc;
    }

    @Override
    public void updateMoveUp() {
        mc.updateMoveUp();
    }

    @Override
    public void updateMoveDown() {
        mc.updateMoveDown();
    }

    @Override
    public void updateMoveLeft() {
        mc.updateMoveLeft();
    }

    @Override
    public void updateMoveRight() {
        mc.updateMoveRight();
    }

    @Override
    public void updateDone() {
        mc.updateDone();
    }

    @Override
    public void updateSuck() {
        mc.updateSuck();
    }

    @Override
    public void updateError() {
        mc.updateError();
    }

    
}
