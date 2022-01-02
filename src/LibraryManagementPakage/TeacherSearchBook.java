/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagementPakage;

import com.mysql.jdbc.PreparedStatement;
//import com.sun.imageio.plugins.png.RowFilter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
//import java.util.regex.*;
import javax.swing.RowFilter;

/**
 *
 * @author rakibul
 */
public class TeacherSearchBook extends javax.swing.JFrame {

    /**
     * Creates new form Book
     */
    public TeacherSearchBook() {
        initComponents();
        connect();
        clearAll();
        
       
        CategoryLoad();
        Book_Load("");
    }
    
    
    Connection con ;
    PreparedStatement pst ,catStatement , findsStatement;
    int id;
    
    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/library","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LibrarianLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void clearAll(){
        searchTxt.setText("");
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        BookTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        catBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("C059", 1, 18)); // NOI18N
        jLabel1.setText("IIUC Library");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 132, 29));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setText("Category");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
        });
        getContentPane().add(searchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 70, 180, -1));

        BookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Title", "Category", "Author", "Publisher"
            }
        ));
        BookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BookTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 99, 550, 321));

        backBtn.setIcon(new javax.swing.ImageIcon("/home/rakibul/Documents/LibraryManagement/backIcon.png")); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 63, -1));

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel9.setText("Search");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, -1, -1));

        catBox.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        catBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                catBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(catBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 220, 20));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        new TeacherInterFace().setVisible(true);
        this.setVisible(false);
        clearAll();
    }//GEN-LAST:event_backBtnActionPerformed

    private void BookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookTableMouseClicked
        // TODO add your handling code here:
    
    
     
     
    }//GEN-LAST:event_BookTableMouseClicked

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) BookTable.getModel();
        String search = searchTxt.getText();
        TableRowSorter<DefaultTableModel>tr = new TableRowSorter<DefaultTableModel>(table);
        BookTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchTxtKeyReleased

    private void catBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_catBoxItemStateChanged
        // TODO add your handling code here:
        String catesString = catBox.getSelectedItem().toString();
        Book_Load(catesString);
       
    }//GEN-LAST:event_catBoxItemStateChanged

    public void Book_Load(String cateString){
        
        try {
            if(cateString.equals("") || cateString.equals("All")){
            pst = (PreparedStatement) con.prepareStatement("SELECT * FROM StudentBooks where rec=?");
            pst.setString(1, "Teacher");
            }
            else{
                pst = (PreparedStatement) con.prepareStatement("SELECT * FROM StudentBooks where rec=? and category=?");
                pst.setString(1, "Teacher");
                pst.setString(2, cateString);
                
            }
            
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            DefaultTableModel df = (DefaultTableModel) BookTable.getModel();
            df.setRowCount(0);
            while (rs.next()) {   
                
                String id = String.valueOf(rs.getInt("id"));
                String title = rs.getString("title");
                String catString = rs.getString("category");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                
                
                String tbData[] = {id,title,catString,author,publisher};
                df.addRow(tbData);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void CategoryLoad() {
        
        try {
            catStatement = (PreparedStatement) con.prepareStatement("Select * from category");
            ResultSet rst = catStatement.executeQuery();
       
                catBox.removeAllItems();
                catBox.addItem("All");
                while(rst.next())
                {
                    catBox.addItem(rst.getString("Category"));
                }
                
        } catch (SQLException ex) {
            Logger.getLogger(TeacherSearchBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TeacherSearchBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherSearchBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherSearchBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherSearchBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherSearchBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BookTable;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> catBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchTxt;
    // End of variables declaration//GEN-END:variables
}
