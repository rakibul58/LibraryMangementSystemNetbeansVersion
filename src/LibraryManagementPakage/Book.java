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
public class Book extends javax.swing.JFrame {

    /**
     * Creates new form Book
     */
    public Book() {
        initComponents();
        connect();
       
        Book_Load();
        categoryLoad();
        authorLoad();
        publisherLoad();
        clearAll();
    }
    
    
    Connection con ;
    PreparedStatement pst , update , delete ;
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
        titleTxt.setText("");
        CatBox.setSelectedIndex(-1);
        AuthorBox.setSelectedIndex(-1);
        PubBox.setSelectedIndex(-1);
        SelectFor.setSelectedItem(-1);
        copiesTxt.setValue(0);
    }
    
    public void categoryLoad(){
        try {
            pst = (PreparedStatement) con.prepareStatement("SELECT Category FROM category");
            ResultSet rs = pst.executeQuery();
           // ResultSetMetaData rss = rs.getMetaData();
            //DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
           // df.setRowCount(0);
            while (rs.next()) {   
                
                String CatItem = rs.getString("Category");
                
                CatBox.addItem(CatItem);
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void authorLoad(){
        
            try {
            pst = (PreparedStatement) con.prepareStatement("SELECT name FROM author");
            ResultSet rs = pst.executeQuery();
           // ResultSetMetaData rss = rs.getMetaData();
            //DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
           // df.setRowCount(0);
            while (rs.next()) {   
                
                String AuthorItem = rs.getString("name");
                
                AuthorBox.addItem(AuthorItem);
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void publisherLoad(){
            try {
            pst = (PreparedStatement) con.prepareStatement("SELECT name FROM publisher");
            ResultSet rs = pst.executeQuery();
           // ResultSetMetaData rss = rs.getMetaData();
            //DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
           // df.setRowCount(0);
            while (rs.next()) {   
                
                String PubItem = rs.getString("name");
                
                PubBox.addItem(PubItem);
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jPanel1 = new javax.swing.JPanel();
        titleTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SelectFor = new javax.swing.JComboBox<>();
        AddBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        copiesTxt = new javax.swing.JSpinner();
        AuthorBox = new javax.swing.JComboBox<>();
        PubBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        CatBox = new javax.swing.JComboBox<>();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("C059", 1, 18)); // NOI18N
        jLabel1.setText("IIUC Library");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setText("Search");

        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
        });

        BookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Title", "Category", "Author", "Publisher", "Copies", "For"
            }
        ));
        BookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BookTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manage Books", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        titleTxt.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setText("Title");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setText("Author");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel5.setText("Publisher");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel6.setText("Copies");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel7.setText("For");

        SelectFor.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        SelectFor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teacher", "Student" }));
        SelectFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectForActionPerformed(evt);
            }
        });

        AddBtn.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        AddBtn.setText("Add");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        UpdateBtn.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel8.setText("Category");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(SelectFor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(copiesTxt)
                            .addComponent(PubBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AuthorBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CatBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titleTxt))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CatBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(AuthorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PubBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(copiesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(SelectFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtn)
                    .addComponent(DeleteBtn)
                    .addComponent(UpdateBtn))
                .addGap(26, 26, 26))
        );

        backBtn.setIcon(new javax.swing.ImageIcon("/home/rakibul/Documents/LibraryManagement/backIcon.png")); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(412, 412, 412)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SelectForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectForActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SelectForActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
        String title , author , publisher , selection , CatTxt;
        int copies ;
        
        title = titleTxt.getText();
        CatTxt = CatBox.getSelectedItem().toString();
        author = AuthorBox.getSelectedItem().toString();
        publisher = PubBox.getSelectedItem().toString();
        copies = (int)copiesTxt.getValue();
        selection = SelectFor.getSelectedItem().toString();
        
        try {
            pst = (PreparedStatement) con.prepareStatement("INSERT INTO StudentBooks(title, category, author, publisher, copies, rec) VALUES (?,?,?,?,?,?)");
            pst.setString(1, title);
            pst.setString(2, CatTxt);
            pst.setString(3, author);
            pst.setString(4, publisher);
            pst.setInt(5, copies);
            pst.setString(6, selection);
            
            int k = pst.executeUpdate();
            
            if(k == 1){
                JOptionPane.showMessageDialog(this, "Book Added");
                
                clearAll();
                Book_Load();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            clearAll();
        }
    }//GEN-LAST:event_AddBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        new MainUserInterface().setVisible(true);
        this.setVisible(false);
        clearAll();
    }//GEN-LAST:event_backBtnActionPerformed

    private void BookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookTableMouseClicked
        // TODO add your handling code here:
     int cpys;
     DefaultTableModel d=  (DefaultTableModel)BookTable.getModel();
     int selectedindex = BookTable.getSelectedRow();
     if(BookTable.getRowSorter()!= null){
         selectedindex = BookTable.getRowSorter().convertRowIndexToModel(selectedindex);
     }
     id = Integer.parseInt(d.getValueAt(selectedindex, 0).toString());
     titleTxt.setText(d.getValueAt(selectedindex, 1).toString());
     CatBox.setSelectedItem(d.getValueAt(selectedindex,2).toString());
     AuthorBox.setSelectedItem(d.getValueAt(selectedindex, 3).toString());
     PubBox.setSelectedItem(d.getValueAt(selectedindex, 4).toString());
     cpys = Integer.parseInt(d.getValueAt(selectedindex, 5).toString());
     copiesTxt.setValue(cpys);
     SelectFor.setSelectedItem(d.getValueAt(selectedindex, 6).toString());
    
     
     
    }//GEN-LAST:event_BookTableMouseClicked

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) BookTable.getModel();
        String search = searchTxt.getText();
        TableRowSorter<DefaultTableModel>tr = new TableRowSorter<DefaultTableModel>(table);
        BookTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchTxtKeyReleased

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
          try {
            // TODO add your handling code here:
            delete = (PreparedStatement) con.prepareStatement("delete from StudentBooks where id=?");
            delete.setInt(1, id);
            int d1 = delete.executeUpdate();
            if(d1==1){
                JOptionPane.showMessageDialog(this, "Data Deleted");
                clearAll();
                Book_Load();
            }else{
                JOptionPane.showMessageDialog(this, "Error !!!");
                clearAll();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        // TODO add your handling code here:
         try {
             
            String title , author , publisher , selection , catString;
            int copies ;
        
            title = titleTxt.getText();
            catString = CatBox.getSelectedItem().toString();
            author = AuthorBox.getSelectedItem().toString();
            publisher = PubBox.getSelectedItem().toString();
            copies = (int)copiesTxt.getValue();
            selection = SelectFor.getSelectedItem().toString();
            // TODO add your handling code here:
            update = (PreparedStatement) con.prepareStatement("UPDATE StudentBooks SET title=?,category=?,author=?,publisher=?,copies=?,rec=? where id=?");
            
            update.setString(1, title);
            update.setString(2, catString);
            update.setString(3, author);
            update.setString(4, publisher);
            update.setInt(5, copies);
            update.setString(6, selection);
            update.setInt(7, id);
            int t = update.executeUpdate();
            if(t==1)
            {
                JOptionPane.showMessageDialog(this, "Table Updated");
                clearAll();
                Book_Load();
            }else{
                JOptionPane.showMessageDialog(this, "Error !!!!");
                clearAll();
            }
                    } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    public void Book_Load(){
        
        try {
            pst = (PreparedStatement) con.prepareStatement("SELECT * FROM StudentBooks");
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
                String copies = String.valueOf(rs.getInt("copies"));
                String rec = rs.getString("rec");
                
                
                String tbData[] = {id,title,catString,author,publisher,copies,rec};
                df.addRow(tbData);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JComboBox<String> AuthorBox;
    private javax.swing.JTable BookTable;
    private javax.swing.JComboBox<String> CatBox;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JComboBox<String> PubBox;
    private javax.swing.JComboBox<String> SelectFor;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JSpinner copiesTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JTextField titleTxt;
    // End of variables declaration//GEN-END:variables
}
