
package Model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestModel {
    public static void main(String[] args) {
        System.out.println("AAA");
//        Map m = Map.getInstance();
//        m.createMap(10, 10, 20, 30);
//        m.printMap();
//       
//        Robot rb = Robot.getInstance();
//        rb.setRobotToMap(m, 0, 0);
//        rb.start(true);
//        
//        System.out.println("Matrix final!");
//        m.printMap();
//
//        int i = 0;
//
//        Random rd = new Random();
//        //int random = rd.nextInt(4) + 2;
//        while(i != 20)
//        {
//            System.out.println(rd.nextInt(4) + 2);
//            i++;
//        }


//        int m[][] = {{0,0,0,0,0,0,1,1},{0,2,0,0,0,0,1,1},{0,0,2,0,0,0,1,1},{0,0,0,1,0,0,1,1},{0,1,0,0,0,0,1,1},
//                     {0,0,0,0,0,0,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,1,1}};
//        findingNeighbors(m, 3, 3);
//
//        System.out.println(Integer.MAX_VALUE);
        
        System.out.println("AAAA");
        
        List<Point> listP = new ArrayList<>();
        listP.add(new Point(0, 0));
        listP.add(new Point(1, 0));
        listP.add(new Point(2, 0));
        listP.add(new Point(3, 0));
        listP.add(new Point(4, 0));
        
        System.out.println(listP.size());
    }
    
    
    
    public static void findingNeighbors(int[][] myArray, int i, int j) {
        int rowLimit = myArray.length - 1;
        int columnLimit = myArray[0].length - 1;

        for (int x = Math.max(0, i - 3); x <= Math.min(i + 3, rowLimit); x++) {
            for (int y = Math.max(0, j - 3); y <= Math.min(j + 3, columnLimit); y++) {
                if (x != i || y != j) {
                    System.out.print(myArray[x][y] + " ");
                }
            }
            System.out.println("");
        }
    }
    
    
    
}
