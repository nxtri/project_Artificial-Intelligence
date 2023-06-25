
package Model;

import Algorithm.AStarPathFinding;
import java.util.Random;

public class Map {
    
    private static Map map;
    private Dust job;
    private AStarPathFinding aStar = new AStarPathFinding();

    //public List<Dust> llj;
    
    private int[][] m;
    private int row, col, dust, brr; //brr: vật cản
    Random rd;   
    
    /*
        - Đường có thể đi --> kí hiệu 0
        - Rác --> kí hiệu 1
        - Vật cản --> kí hiệu >= 2
    */

    public static Map getInstance()
    {
        if(map == null) map = new Map();
        return map;
    }
    
    public void createMap(int row, int col, int dust, int brr)
    {
        this.row = row;
        this.col = col;
        this.dust = dust;
        this.brr = brr;
              
        rd = new Random();
        
//        llj = new ArrayList<>();
//        llj.add(new Dust(new Point(0,0)));
        
        m = new int[row][col];
        
        for(int i = 0; i < row; i ++)
            for(int j = 0; j < col; j++)
                m[i][j] = 0;
        
        createBrr();
        createDust();

    }
    
//    private void addToListDust(Point p)
//    {
//        if(aStar.getShortestPath(m, new Point(0, 0), p).isEmpty())
//        {
//            System.out.println("None");
//            return;
//        }
//
//        //llj.add(new Dust(p));
//    }
//    
//    public void removeFromListDust(int i, int j)
//    {
//        Dust dust = null;
//        for(Dust d : llj)
//        {
//            if(d.getPxy().x == i && d.getPxy().y == j)
//            {
//                dust = d;
//                break;
//            }
//        }
//        //llj.remove(dust);
//    }
    
    public void setPosition(int row, int col)
    {
        m[row][col] = 1;
        dust++;

        //addToListDust(new Point(row, col));
 
    }
    
    private void createDust()
    {
        int count = 0;
        
        while(count < dust)
        {
            int i = rd.nextInt(row);
            int j = rd.nextInt(col);
            if(m[i][j] == 0 && i != 0 && j != 0)
            {
                count++;
                m[i][j] = 1;
                //addToListDust(new Point(i, j));
            }
        }
    }

    private void createBrr() {
        int count = 0;
        
        while(count < brr)
        {
            int i = rd.nextInt(row);
            int j = rd.nextInt(col);
            if(m[i][j] == 0 && i != 0 && j != 0)
            {
                count++;
                
                m[i][j] = rd.nextInt(4) + 2;
            }
        }
    }
    
    public void printMap()
    {
        for(int i = 0; i < row; i ++)
        {
            for(int j = 0; j < col; j++)
                System.out.print(m[i][j] + " ");
            System.out.println("");
        }
    }
    
    public int[][] getM() {
        return m;
    }

    public void setM(int[][] m) {
        this.m = m;
    }

    public int getRow() {
        return row;
    }


    public int getCol() {
        return col;
    }

    public int getDust() {
        return dust;
    }

    
}
