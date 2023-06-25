
package View;

import Commit.mapCommit;
import Model.Map;
import Model.Robot;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GUIMap extends JPanel implements Runnable, mapCommit, MouseMotionListener, MouseListener{
    //Start
    //Size 1 ô vuông của ma trận
//    public int originalTileSize = 16; 
//    public int scale = 4;   
//    public int tileSize = originalTileSize * scale; // 1 ô vuông ma trận cỡ tileSize x tileSize
    
    //chiều dài và chiều rộng của 1 ô trong màn hình
    private int titleWidth, titleHeight;
    
    //Số hàng và số cột
    public int maxScreenCol;
    public int maxScreenRow;
    
    //Size màn hình
//    public int screenWidth = tileSize * maxScreenCol;
//    public int screenHeight = tileSize * maxScreenRow;
       
    //===
    BufferedImage up, down, left, right, clean1, clean2, clean3, img;
    
    Thread GUIThread;
    
    Robot o;
    Map m;
    
    public int speed;
    
    int x = 0, y = 0, soRac;
    int xObject, yObject, xRobot, yRobot;

    Tile[] tile;
    
    boolean chon = false;
    boolean dkrb;
    //===
    MainScreen ms;
    
    public GUIMap(MainScreen ms, Dimension d, int row, int col, int dust, int brr)
    {
        this.ms = ms;
        
        this.setPreferredSize(d);
        this.setBackground(new Color(204,204,255));
        this.setDoubleBuffered(true);
        
        this.maxScreenRow = row;
        this.maxScreenCol = col;
        titleWidth = Math.round(d.width / maxScreenCol);
        titleHeight = Math.round(d.height / maxScreenRow);
        
        tile = new Tile[6];
        
        m = Map.getInstance();
        m.createMap(row, col, dust, brr);
        
        o = Robot.getInstance();
        o.registry(GUIMap.this);
        
        speed = 6000000;
        
        soRac = m.getDust();
        ms.setLableSoRacConLai(String.valueOf(soRac));
        
        try {
            //Move
            up = ImageIO.read(getClass().getResourceAsStream("/Image/up.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/Image/down.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/Image/left.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/Image/right.png"));
            
            //Clean
            clean1 = ImageIO.read(getClass().getResourceAsStream("/Image/clean1.png"));
            clean2 = ImageIO.read(getClass().getResourceAsStream("/Image/clean2.png"));
            clean3 = ImageIO.read(getClass().getResourceAsStream("/Image/clean3.png"));

            //Đặt mặc định lúc vào là hướng phải
            img = right;
            
            //sàn nhà
            tile[0] = new Tile();
            tile[0].imgTile = ImageIO.read(getClass().getResourceAsStream("/Image/floor.jpg"));
            
            //rác
            tile[1] = new Tile();
            tile[1].imgTile = ImageIO.read(getClass().getResourceAsStream("/Image/dust.png"));
            
            
            //Vật cản
            tile[2] = new Tile();
            tile[2].imgTile = ImageIO.read(getClass().getResourceAsStream("/Image/brr1.png"));
            
            tile[3] = new Tile();
            tile[3].imgTile = ImageIO.read(getClass().getResourceAsStream("/Image/brr2.png"));
            
            tile[4] = new Tile();
            tile[4].imgTile = ImageIO.read(getClass().getResourceAsStream("/Image/brr3.png"));
            
            tile[5] = new Tile();
            tile[5].imgTile = ImageIO.read(getClass().getResourceAsStream("/Image/brr4.png"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        addMouseListener(GUIMap.this);
        addMouseMotionListener(GUIMap.this);
        
    }
    
    public void drawMap(Graphics2D g2)
    {
        int x = 0, y = 0;
        for(int i = 0; i < maxScreenRow; i++)
        {
            x = 0;
            for(int j = 0; j < maxScreenCol; j++)
            {
                int tileNumber = m.getM()[i][j];
                if(tileNumber >= 1) g2.drawImage(tile[0].imgTile, x, y, titleWidth, titleHeight, null);
                g2.drawImage(tile[tileNumber].imgTile, x, y, titleWidth, titleHeight, null);
                x += titleWidth;

            }
            y += titleHeight;
        }
    }
    
    
    
    public void startGUIThread()
    {
        GUIThread = new Thread(this);
        GUIThread.start();
    }
    
    @Override
    public void run() {
        o.setRobotToMap(m, 0, 0);
        o.start(dkrb);
    }
    
    public void update()
    {
        //
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        drawMap(g2);
        
        g2.drawImage(img, x, y, titleWidth, titleHeight, null);
        
        if(chon)
        {
            g2.drawImage(tile[1].imgTile, xRobot - titleWidth/2, yRobot - titleHeight/2, titleWidth, titleHeight, null);
        }
        
        g2.dispose();
    }

    public void sleep(int so)
    {
        double drawInterval = 1000000000/60;
        double nextDrawTime = System.nanoTime() + drawInterval;
        try {
            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime /= so; //Tăng tốc --> tăng so lên

            if (remainingTime < 0) {
                remainingTime = 0;
            }

            Thread.sleep((long) remainingTime);

            nextDrawTime += drawInterval;

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
        public void moveUP()
    {
        ms.setLabelDiChuyen("Di chuyển lên trên 1 ô");
        
        xObject = x;
        yObject = y - titleHeight;
        
        while(y != yObject)
        {
            img = up;
            y -= 1;
            repaint();
            sleep(speed);
        }
        
        ms.setLabelChiPhi();
        
    }
    
    public void moveDOWN()
    {
        ms.setLabelDiChuyen("Di chuyển xuống dưới 1 ô");
        
        xObject = x;
        yObject = y + titleHeight;
        
        while(y != yObject)
        {
            img = down;
            y += 1;
            repaint();
            sleep(speed);
        }
        
        ms.setLabelChiPhi();

    }
    
    public void moveRIGHT()
    {
        ms.setLabelDiChuyen("Di chuyển sang phải 1 ô");
        
        xObject = x + titleWidth;
        yObject = y;
        
        while (x != xObject) {
            img = right;
            x += 1;
            repaint();
            sleep(speed);
        }
        
        ms.setLabelChiPhi();
    }
    
    public void moveLEFT()
    {
        ms.setLabelDiChuyen("Di chuyển sang trái 1 ô");
        
        xObject = x - titleWidth;
        yObject = y;
        
        while (x != xObject) {
            img = left;
            x -= 1;
            repaint();
            sleep(speed);
        }
        
        ms.setLabelChiPhi();
    }
    
    public void startSuck()
    {
        ms.setLabelDiChuyen("Bắt đầu dọn dẹp");
        
        int soLan = 0;
        
        while(soLan != 2)
        {
            img = clean1;
            repaint();
            sleep(speed/30); // speed /
            img = clean2;
            repaint();
            sleep(speed/30);
            img = clean3;
            repaint();
            sleep(speed/30);
            soLan++;            
        }
        
        soLan = 0;
        
        soRac--;
        ms.setLableSoRacConLai(String.valueOf(soRac));
    }
    
    @Override
    public void updateMoveUp() {
        moveUP();
    }

    @Override
    public void updateMoveDown() {
        moveDOWN();
    }

    @Override
    public void updateMoveLeft() {
        moveLEFT();
    }

    @Override
    public void updateMoveRight() {
        moveRIGHT();
    }

    @Override
    public void updateDone() {
       JOptionPane.showMessageDialog(this, "Hoàn thành!");
       ms.setLabelDiChuyen("Đã dọn dẹp xong");
    }

    @Override
    public void updateSuck() {
        startSuck();
    }

    @Override
    public void updateError() {
        if(soRac == 0) return;
        JOptionPane.showMessageDialog(this, "Không có đường đi tới điểm tiếp theo");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(chon)
        {
            xRobot = e.getX();
            yRobot = e.getY();
            repaint();
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(chon == false) return;
        chon = false;
        if(m.getM()[yRobot/titleHeight][xRobot/titleWidth] == 2)
        {
            repaint();
            return;
        }
        m.setPosition(yRobot/titleHeight, xRobot/titleWidth);
        repaint();
        
        soRac++;
        ms.setLableSoRacConLai(String.valueOf(soRac));

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


    
    //========================
    class Tile
    {
        public BufferedImage imgTile;
    }
    
}