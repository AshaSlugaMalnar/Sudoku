
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import static java.io.FileDescriptor.in;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.in;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Sudoku extends javax.swing.JFrame {
  
    JButton botton = new JButton();

    JTextField[][] tabela = new JTextField[9][9];
    
    

  private String[][] table
            = {{"5", "3", "", "", "7", "", "", "", ""},
            {"6", "", "", "1", "9", "5", "", "", ""},
            {"", "9", "8", "", "", "", "", "6", ""},
            {"8", "", "", "", "6", "", "", "", "3"},
            {"4", "", "", "8", "", "3", "", "", "1"},
            {"7", "", "", "", "2", "", "", "", "6"},
            {"", "6", "", "", "", "", "2", "8", ""},
            {"", "", "", "4", "1", "9", "", "", "5"},
            {"", "", "", "", "8", "", "", "7", "9"}};

    String firstSudoku="74196......5.4...6....3...9.7..95.1.3.......8.1.28..6.8...7....4...2.9......54632";
    
    public Sudoku() throws FileNotFoundException {
       
        
        initComponents();
        JFrame frame = this;
        frame.setVisible(true);
        frame.setSize(500, 700);
        botton.setVisible(false);
        frame.add(botton);
        botton.setSize(40, 40);
        botton.setLocation(400, 600);
        botton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectionButtonPressed();
            }
        });

        table = Polje.Init(firstSudoku);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tabela[i][j] = new JTextField();
                tabela[i][j].setName(Integer.toString(i)+Integer.toString(j));
                tabela[i][j].addActionListener(new ActionListener(){
                
                  @Override
                    public void actionPerformed(ActionEvent e) {
                       String ii= ((JTextField)e.getSource()).getName().substring(0, 1);
                       String jj= ((JTextField)e.getSource()).getName().substring(1, 2);
                      
                    table[Integer.parseInt(ii)][Integer.parseInt(jj)]=tabela[Integer.parseInt(ii)][Integer.parseInt(jj)].getText();
                   table = Polje.Init(ReadFromUser());
                    }
      
        });
                tabela[i][j].setToolTipText(table[i][j]);
                if (tabela[i][j].getToolTipText().length() == 1) {
                    tabela[i][j].setText(tabela[i][j].getToolTipText());
                }
                frame.add(tabela[i][j]);
                tabela[i][j].setVisible(true);
                tabela[i][j].setSize(40, 40);
               

                tabela[i][j].setLocation((i + 1) * 41, (j + 4) * 41);
                if (i > 2) {
                    tabela[i][j].setLocation((tabela[i][j].location().x) + 5, (tabela[i][j].location().y));
                }
                if (i > 5) {
                    tabela[i][j].setLocation((tabela[i][j].location().x) + 5, (tabela[i][j].location().y));
                }
                if (j > 2) {
                    tabela[i][j].setLocation((tabela[i][j].location().x), (tabela[i][j].location().y) + 5);
                }
                if (j > 5) {
                    tabela[i][j].setLocation((tabela[i][j].location().x), (tabela[i][j].location().y) + 5);
                }
            }
        }
        
        setLayout(null);
UpdateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jFileChooser1 = new javax.swing.JFileChooser();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        ClearButoon = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jFileChooser2 = new javax.swing.JFileChooser();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setFont(new java.awt.Font("AR ESSENCE", 0, 11)); // NOI18N
        jButton2.setText("Solve :)");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("AR ESSENCE", 0, 11)); // NOI18N
        jButton3.setText("Load");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadButtonActionPerformed(evt);
            }
        });

        ClearButoon.setFont(new java.awt.Font("AR ESSENCE", 0, 11)); // NOI18N
        ClearButoon.setText("Clear");
        ClearButoon.setToolTipText("");
        ClearButoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButoonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(30, 28, 240));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        jFileChooser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("AR ESSENCE", 0, 11)); // NOI18N
        jButton1.setText("Uredi profil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Vizitka");

        jMenuItem2.setText("Sudoku Solver");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem4.setText("User");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem1.setText("Aša Sluga Malnar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem3.setText("asa.sluga.malnar@gmail.com");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addGap(59, 59, 59)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(ClearButoon)
                        .addGap(41, 41, 41)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 423, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(ClearButoon)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jButton2.getAccessibleContext().setAccessibleName("solvebutton1");
        jButton3.getAccessibleContext().setAccessibleName("LoadButton");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void UpdateTable()
    {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tabela[i][j].setToolTipText(table[i][j]);
                if (table[i][j].length() == 1) {
                    tabela[i][j].setText(table[i][j]);
                }
                else{
                tabela[i][j].setText("");
                }
                if(tabela[i][j].getToolTipText().length()==0)
                    tabela[i][j].setBackground(Color.red);
                else
                    tabela[i][j].setBackground(Color.white);
                
            
            }
        
        }
    }
    
    String ReadFromUser(){
        String celaVrsta="";
       for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String g=tabela[i][j].getText() ;
                if (g.equals("") ) {
                    celaVrsta=celaVrsta+".";
                }
                else{
                celaVrsta=celaVrsta+tabela[i][j].getText();
                }
                
                
            
            }
        
        }
return celaVrsta;

}
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jButton2.setText("Solve:)");
        table=Polje.Solve1();
        table=Polje.Solve2();
        UpdateTable();
        
    }//GEN-LAST:event_jButton2ActionPerformed
 BufferedReader in1=new BufferedReader(new FileReader("src/sudoku.txt"));
    private void LoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadButtonActionPerformed
       
       try{ 
            firstSudoku=in1.readLine();
            
           table=Polje.Init(firstSudoku);
       }
       catch(IOException e){
       }
       finally{ 
           UpdateTable();
           
       }
        
        
       
    }//GEN-LAST:event_LoadButtonActionPerformed

    private void ClearButoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButoonActionPerformed
        table=Polje.ClearTable();
        UpdateTable();
     
           
    }//GEN-LAST:event_ClearButoonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jFileChooser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFileChooser2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        //new NewJFrame3().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //new NewJFrame3().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
  String LoadFromLastFile() {
        String contents = "";
        //Path dir = Paths.get("C:\\Users\\Asa\\Downloads\\sudoku");  // specify your directory
        Path dir = FileSystems.getDefault().getPath("sudoku");  // specify your directory
        Path path = FileSystems.getDefault().getPath("", "filename.txt");

        Optional<Path> lastFilePath;
        try {
            lastFilePath = Files.list(dir) // here we get the stream with full directory listing
                    .filter(f -> Files.isDirectory(f) == false) // exclude subdirectories from listing
                    .max((f1, f2) -> (int) (f1.toFile().lastModified() - f2.toFile().lastModified())); // finally get the last file using simple comparator by lastModified field
            if (lastFilePath.isPresent()) // your folder may be empty
            {
                path = lastFilePath.get();
            }

        } catch (IOException ex) {
            Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
        }

        return contents;
    }
          
         
    private void selectionButtonPressed() {
        
    }

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Sudoku().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearButoon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
}
