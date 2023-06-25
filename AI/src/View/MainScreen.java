
package View;


import Model.Map;
import java.awt.BorderLayout;
import java.util.Random;
import javax.swing.JOptionPane;

public class MainScreen extends javax.swing.JFrame{
    GUIMap gm;
    int soBuoc = 0;
    
    boolean daTaoMap = false;
    boolean hide1 = false, hide2 = false, hide3 = false;
    
    public MainScreen() {
        initComponents();
        setLocationRelativeTo(null);
        this.pack();
        
        soBuoc = 0;

    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jplmain = new javax.swing.JPanel();
        jplTT = new javax.swing.JPanel();
        jplkrb = new javax.swing.JPanel();
        jbtnBDkrb = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jbtn1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jbtn3 = new javax.swing.JButton();
        jpldvp = new javax.swing.JPanel();
        jbtnDatRac = new javax.swing.JButton();
        jsldSpeed = new javax.swing.JSlider();
        jplCreate = new javax.swing.JPanel();
        jbtnTaoMap = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtRow = new javax.swing.JTextField();
        txtCol = new javax.swing.JTextField();
        txtDust = new javax.swing.JTextField();
        txtBrr = new javax.swing.JTextField();
        jbtnTaoNgauNhien = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jlbChiPhi = new javax.swing.JLabel();
        jlbDiChuyen = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlbSoRacConLai = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ROBOT DỌN  DẸP");
        setBackground(new java.awt.Color(204, 204, 255));

        jplmain.setBackground(new java.awt.Color(204, 204, 255));
        jplmain.setForeground(new java.awt.Color(204, 204, 255));
        jplmain.setPreferredSize(new java.awt.Dimension(1033, 720));

        javax.swing.GroupLayout jplmainLayout = new javax.swing.GroupLayout(jplmain);
        jplmain.setLayout(jplmainLayout);
        jplmainLayout.setHorizontalGroup(
            jplmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
        );
        jplmainLayout.setVerticalGroup(
            jplmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );

        jplTT.setBackground(new java.awt.Color(204, 204, 255));

        jplkrb.setBackground(new java.awt.Color(204, 204, 255));

        jbtnBDkrb.setForeground(new java.awt.Color(0, 0, 0));
        jbtnBDkrb.setText("Bắt đầu");
        jbtnBDkrb.setContentAreaFilled(false);
        jbtnBDkrb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBDkrbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jplkrbLayout = new javax.swing.GroupLayout(jplkrb);
        jplkrb.setLayout(jplkrbLayout);
        jplkrbLayout.setHorizontalGroup(
            jplkrbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplkrbLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jbtnBDkrb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        jplkrbLayout.setVerticalGroup(
            jplkrbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplkrbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnBDkrb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(189, 188, 188));
        jPanel2.setForeground(new java.awt.Color(0, 51, 255));

        jLabel2.setFont(new java.awt.Font("Source Sans Pro", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText(" Dọn dẹp");

        jbtn1.setForeground(new java.awt.Color(0, 51, 255));
        jbtn1.setText("△");
        jbtn1.setBorderPainted(false);
        jbtn1.setContentAreaFilled(false);
        jbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addComponent(jbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(189, 188, 188));

        jLabel4.setFont(new java.awt.Font("Source Sans Pro", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setText(" Đặt vị trí");

        jbtn3.setForeground(new java.awt.Color(0, 51, 255));
        jbtn3.setText("△");
        jbtn3.setBorderPainted(false);
        jbtn3.setContentAreaFilled(false);
        jbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpldvp.setBackground(new java.awt.Color(204, 204, 255));

        jbtnDatRac.setForeground(new java.awt.Color(0, 0, 0));
        jbtnDatRac.setText("Điểm dọn");
        jbtnDatRac.setContentAreaFilled(false);
        jbtnDatRac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDatRacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpldvpLayout = new javax.swing.GroupLayout(jpldvp);
        jpldvp.setLayout(jpldvpLayout);
        jpldvpLayout.setHorizontalGroup(
            jpldvpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpldvpLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jbtnDatRac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        jpldvpLayout.setVerticalGroup(
            jpldvpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpldvpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnDatRac, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jsldSpeed.setBackground(new java.awt.Color(204, 204, 255));
        jsldSpeed.setForeground(new java.awt.Color(0, 0, 255));
        jsldSpeed.setMaximum(15000000);
        jsldSpeed.setMinimum(3000000);
        jsldSpeed.setToolTipText("");
        jsldSpeed.setValue(6000000);
        jsldSpeed.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "TỐC ĐỘ ROBOT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Source Sans Pro", 1, 13), new java.awt.Color(255, 0, 0))); // NOI18N
        jsldSpeed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsldSpeedStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jplTTLayout = new javax.swing.GroupLayout(jplTT);
        jplTT.setLayout(jplTTLayout);
        jplTTLayout.setHorizontalGroup(
            jplTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jplTTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jplkrb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jsldSpeed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jpldvp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jplTTLayout.setVerticalGroup(
            jplTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplTTLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jplkrb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpldvp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jsldSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jplCreate.setBackground(new java.awt.Color(204, 204, 255));

        jbtnTaoMap.setForeground(new java.awt.Color(0, 0, 0));
        jbtnTaoMap.setText("Tạo map");
        jbtnTaoMap.setContentAreaFilled(false);
        jbtnTaoMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTaoMapActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(189, 188, 188));
        jLabel1.setFont(new java.awt.Font("Source Sans Pro", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN MAP");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtRow.setBackground(new java.awt.Color(204, 204, 255));
        txtRow.setForeground(new java.awt.Color(0, 0, 0));
        txtRow.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRow.setText("11");
        txtRow.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true), "Số hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Source Sans Pro", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        txtRow.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtRow.setName(""); // NOI18N

        txtCol.setBackground(new java.awt.Color(204, 204, 255));
        txtCol.setForeground(new java.awt.Color(0, 0, 0));
        txtCol.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCol.setText("14");
        txtCol.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true), "Số cột", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Source Sans Pro", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        txtDust.setBackground(new java.awt.Color(204, 204, 255));
        txtDust.setForeground(new java.awt.Color(0, 0, 0));
        txtDust.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDust.setText("10");
        txtDust.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true), "Số vị trí", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Source Sans Pro", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        txtBrr.setBackground(new java.awt.Color(204, 204, 255));
        txtBrr.setForeground(new java.awt.Color(0, 0, 0));
        txtBrr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBrr.setText("10");
        txtBrr.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true), "Số vật cản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Source Sans Pro", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        txtBrr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrrActionPerformed(evt);
            }
        });

        jbtnTaoNgauNhien.setForeground(new java.awt.Color(0, 0, 0));
        jbtnTaoNgauNhien.setText("Tạo ngẫu nhiên");
        jbtnTaoNgauNhien.setContentAreaFilled(false);
        jbtnTaoNgauNhien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTaoNgauNhienActionPerformed(evt);
            }
        });

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jplCreateLayout = new javax.swing.GroupLayout(jplCreate);
        jplCreate.setLayout(jplCreateLayout);
        jplCreateLayout.setHorizontalGroup(
            jplCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplCreateLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtRow, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtCol, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(txtDust, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtBrr, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnTaoMap, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnTaoNgauNhien, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jplCreateLayout.setVerticalGroup(
            jplCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jplCreateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnTaoMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRow)
                    .addComponent(jbtnTaoNgauNhien, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCol)
                    .addComponent(txtDust)
                    .addComponent(txtBrr))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jlbChiPhi.setFont(new java.awt.Font("Source Sans Pro", 1, 13)); // NOI18N
        jlbChiPhi.setForeground(new java.awt.Color(255, 0, 0));
        jlbChiPhi.setText("0");

        jlbDiChuyen.setFont(new java.awt.Font("Source Sans Pro", 1, 13)); // NOI18N
        jlbDiChuyen.setForeground(new java.awt.Color(255, 0, 0));
        jlbDiChuyen.setText("Chưa tạo bản đồ");

        jLabel5.setFont(new java.awt.Font("Source Sans Pro", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Hướng đi :");

        jlbSoRacConLai.setFont(new java.awt.Font("Source Sans Pro", 1, 13)); // NOI18N
        jlbSoRacConLai.setForeground(new java.awt.Color(255, 0, 0));
        jlbSoRacConLai.setText("0");

        jLabel6.setFont(new java.awt.Font("Source Sans Pro", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Số điểm còn lại :");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel7.setFont(new java.awt.Font("Source Sans Pro", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Số bước di chuyển :");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jlbDiChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbSoRacConLai, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbChiPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
            .addComponent(jlbChiPhi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlbSoRacConLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlbDiChuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jplmain, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jplTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jplCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jplCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jplmain, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                    .addComponent(jplTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnTaoMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTaoMapActionPerformed
       
        int row = 0, col = 0, dust = 0, brr = 0;
        
        if(txtRow.getText().equals("") && txtCol.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Số hàng và số cột trống");
            return;
        }
        
        soBuoc = 0;
        setLabelChiPhi();
        
        row = Integer.parseInt(txtRow.getText().trim());
        col = Integer.parseInt(txtCol.getText().trim());
        dust = Integer.parseInt(txtDust.getText().trim());
        brr = Integer.parseInt(txtBrr.getText().trim());
        
        gm = new GUIMap(this, jplmain.getSize(), row, col, dust, brr);
        jplmain.removeAll();
        jplmain.setLayout(new BorderLayout());
        jplmain.add(gm);
        jplmain.validate();
        
        daTaoMap = true;
        setLabelDiChuyen("Đang ở vị trí ban đầu");
        
    }//GEN-LAST:event_jbtnTaoMapActionPerformed

    private void txtBrrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBrrActionPerformed

    private void jbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn1ActionPerformed
        if(hide1 == false)
        {
            jplkrb.setVisible(false);
            jbtn1.setText("▽");
            hide1 = true;
        }
        else
        {
            jplkrb.setVisible(true);
            jbtn1.setText("△");
            hide1 = false;
        }
    }//GEN-LAST:event_jbtn1ActionPerformed

    private void jbtnBDkrbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBDkrbActionPerformed
        if(!daTaoMap)
        {
            JOptionPane.showMessageDialog(this, "Chưa tạo map!");
            return;
        }
        
        jsldSpeed.setValue(6000000);
        
        gm.dkrb = false;
        gm.startGUIThread();
    }//GEN-LAST:event_jbtnBDkrbActionPerformed

    private void jbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn3ActionPerformed
        if(hide3 == false)
        {
            jpldvp.setVisible(false);
            jbtn3.setText("▽");
            hide3 = true;
        }
        else
        {
            jpldvp.setVisible(true);
            jbtn3.setText("△");
            hide3 = false;
        }
    }//GEN-LAST:event_jbtn3ActionPerformed

    private void jbtnDatRacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDatRacActionPerformed
        if(!daTaoMap)
        {
            JOptionPane.showMessageDialog(this, "Chưa tạo map!");
            return;
        }
        
        gm.chon = true;
    }//GEN-LAST:event_jbtnDatRacActionPerformed

    private void jbtnTaoNgauNhienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTaoNgauNhienActionPerformed
     
        soBuoc = 0;
        setLabelChiPhi();
        
        int row, col, dust, brr;
        Random rd = new Random();
        
        row = rd.nextInt(16) + 5;
        col = rd.nextInt(row) + (4*row/5);
        dust = rd.nextInt(row) + row/2;
        brr = rd.nextInt(row) + row/2;
        
        txtRow.setText(String.valueOf(row));
        txtCol.setText(String.valueOf(col));
        txtDust.setText(String.valueOf(dust));
        txtBrr.setText(String.valueOf(brr));
        
        gm = new GUIMap(this, jplmain.getSize(), row, col, dust, brr);
        jplmain.removeAll();
        jplmain.setLayout(new BorderLayout());
        jplmain.add(gm);
        jplmain.validate();
        
        daTaoMap = true;
        setLabelDiChuyen("Đang ở vị trí ban đầu");
        
    }//GEN-LAST:event_jbtnTaoNgauNhienActionPerformed

    private void jsldSpeedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsldSpeedStateChanged
        if(gm == null) return;
        
        gm.speed = jsldSpeed.getValue();
    }//GEN-LAST:event_jsldSpeedStateChanged

    public void setLabelChiPhi()
    {
        jlbChiPhi.setText(String.valueOf(soBuoc));
        soBuoc++;
    }
    
    public void setLabelDiChuyen(String str)
    {
        jlbDiChuyen.setText(str);
    }
    
    public void setLableSoRacConLai(String srcl)
    {
        jlbSoRacConLai.setText(srcl);
    }
    
//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainScreen().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JButton jbtn1;
    private javax.swing.JButton jbtn3;
    private javax.swing.JButton jbtnBDkrb;
    private javax.swing.JButton jbtnDatRac;
    private javax.swing.JButton jbtnTaoMap;
    private javax.swing.JButton jbtnTaoNgauNhien;
    private javax.swing.JLabel jlbChiPhi;
    private javax.swing.JLabel jlbDiChuyen;
    private javax.swing.JLabel jlbSoRacConLai;
    private javax.swing.JPanel jplCreate;
    private javax.swing.JPanel jplTT;
    private javax.swing.JPanel jpldvp;
    private javax.swing.JPanel jplkrb;
    private javax.swing.JPanel jplmain;
    private javax.swing.JSlider jsldSpeed;
    private javax.swing.JTextField txtBrr;
    private javax.swing.JTextField txtCol;
    private javax.swing.JTextField txtDust;
    private javax.swing.JTextField txtRow;
    // End of variables declaration//GEN-END:variables
}
