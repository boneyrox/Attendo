/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Surendra Singh
 */

import java.time.LocalDate;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import java.sql.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class qrcode extends javax.swing.JFrame {
    
    String s1;
    static String str;
    String ip;

    /**
     * Creates new form qrcode
     */
    public qrcode() {
       initComponents();
       
       InetAddress ip;
        try {

            ip = InetAddress.getLocalHost();
            str = ip.getHostAddress().toString();
           // System.out.println("Current IP address : " + ip.getHostAddress());
            //System.out.println(str);

        } catch (UnknownHostException e) {

            e.printStackTrace();

        }
       
       
         int d;
        //this.ip = ip;
        Random t = new Random();

        d = t.nextInt(100000);

        String s = Integer.toString(d);
        s = s + "#" +str;
        s1 = s;

        QRCode hello_world = QRCode.from(s1);
        hello_world.to(ImageType.PNG);
        ByteArrayOutputStream out = hello_world.stream();

        try {
            FileOutputStream fout = new FileOutputStream(new File(
                    "C:\\Users\\BONEYY\\Desktop\\devil\\QR_Code.PNG"));
            //System.out.println("qr genrated");

            fout.write(out.toByteArray());

            fout.flush();
            fout.close();

        } catch (FileNotFoundException e) {
            // Do Logging
            e.printStackTrace();
        } catch (IOException e) {
            // Do Logging
            e.printStackTrace();
        }

        
    }
    
      public static String ip_data()
    {
        InetAddress ip;
        try {

            ip = InetAddress.getLocalHost();
            str = ip.getHostAddress().toString();
           // System.out.println("Current IP address : " + ip.getHostAddress());
            //System.out.println(str);

        } catch (UnknownHostException e) {

            e.printStackTrace();

        }

      return str;
    }
      
      
       public static void  data_base(String e_no)
    {
        try{

            LocalDate currentTime = LocalDate.now();
            String date = currentTime.toString();
            String day = date.substring(date.length()-2,date.length());


            String d_ate = day+"th";
           // System.out.println("Current Date and Time is:"+d_ate);


            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3309/attendance","root","1234");
            //System.out.println("Connection succes");

            PreparedStatement pstmt = null;

                String query1 = "update dbms set devil = 'p' where eno = ? ";
                String qu = "update dbms set 28tth='p' where eno = ?";
                String query = query1.replace("devil",d_ate);//replaces all occurrences of is to was

                pstmt = con.prepareStatement(qu); // create a statement
               // pstmt.setString(1, d_ate); // set input parameter 1
                pstmt.setString(1, e_no); // set input parameter 2
                pstmt.executeUpdate(); // execute update statement


            con.close();
        }catch(Exception e){ System.out.println(e);}

    }
      
      
      

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        javax.swing.JLabel id1 = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Adobe Arabic", 0, 14)); // NOI18N

        jLabel1.setText("      Attendance System");

        jButton1.setText("Manually");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("    Qrgenration");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(449, 449, 449)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(393, 393, 393)
                        .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          String a = ip_data();
          //System.out.println("ip is :"+a);
          
            int x,y,w,h;
            x=230;
            y=80;
            w=140;
            h=40;
            int i=0;
            int j=1;
          
           qrcode obj = new qrcode();
          
          System.out.println("started");
          
          Frame f = new Frame("Student data");
          f.setSize(400,400);
          f.setLayout(null);
          f.setVisible(true);
          Label l1;
          Label l2;
          
          
        
        
        try
        {
            //System.out.println("Connection is ready");
            ServerSocket ss  = new ServerSocket(6868);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //BufferedReader bfsg = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //System.out.println("Enter the string");





            while(true)
            {
              
                
                Socket s = ss.accept();
                System.out.println("connection success");
                BufferedReader bfs = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter ou = new PrintWriter(s.getOutputStream(),true);
                ou.println(obj.s1);

                String st = bfs.readLine();
                System.out.println("Enroll is:"+st);
                obj.data_base(st);
                
                if(i==26)
                {
                 x = x + 200;
                 y = 80;
                 i=0;
                 
                }
                
                else
                {
                l1 = new Label(j+"-"+st);
                l1.setBounds(x,y,w,h);
                f.add(l1);
                y=y+30;
                i++;
                j++;
            
                }
                
                
                
                
                //int enroll = Integer.parseInt(st);
               //obj.data_base(st);

            }
            
             
        }
        catch(IOException e)
        {
            System.out.println("exception"+e);
        }

          
          
          

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        Frame f = new Frame("Manual attendance");
          f.setSize(400,400);
          f.setLayout(null);
          f.setVisible(true);
          Label l1 = new Label("Enter Enroll no:");
          TextField t1 = new TextField();
          Button button = new Button("Submit");
          l1.setBounds(230,80,140,40);
          t1.setBounds(230,160,140,40);
          button.setBounds(230,210,140,40);
          f.add(l1);
          f.add(t1);
          f.add(button);
          
           button.addActionListener(new ActionListener(){  
     public void actionPerformed(ActionEvent e){  
            String enroll = t1.getText().toString().trim();  
            data_base(enroll);
            t1.setText("");
            
        }  
    });  
          
          
          
          
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
       
        
        
        //System.out.println("ksjahdsajkhdsa");
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(qrcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(qrcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(qrcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(qrcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 
                new qrcode().setVisible(true);
            }
        });
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
