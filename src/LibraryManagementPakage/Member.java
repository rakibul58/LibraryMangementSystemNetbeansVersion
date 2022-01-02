/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagementPakage;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Member extends javax.swing.JFrame {

    /**
     * Creates new form StudentLoginRegister
     */
    public Member() {
        initComponents();
        cleanTxt();
        connect();
    }
    
    Connection con ;
    PreparedStatement pst , delete , update;
    String user , pass , id , stat;
    
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        AddMember = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        RegUserId = new javax.swing.JTextField();
        Id = new javax.swing.JTextField();
        department = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        regPass = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        selectFor = new javax.swing.JLabel();
        selecBox = new javax.swing.JComboBox<>();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        memTable = new javax.swing.JTable();
        teacTable = new javax.swing.JButton();
        stdTable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Edwardian Script ITC", 1, 36)); // NOI18N
        jLabel1.setText("IIUC Library");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Member", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Edwardian Script ITC", 1, 24))); // NOI18N

        AddMember.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        AddMember.setText("Add");
        AddMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMemberActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("User ID");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("ID");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("Department");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setText("E-mail");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setText("Password");

        RegUserId.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        Id.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        department.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        email.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        regPass.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        name.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        selectFor.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        selectFor.setText("You Are");

        selecBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teacher", "Student" }));

        updateBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(RegUserId)
                                    .addComponent(Id)
                                    .addComponent(department)
                                    .addComponent(email)
                                    .addComponent(regPass, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(name))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(selectFor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(selecBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(AddMember)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteBtn)
                        .addGap(18, 18, 18)
                        .addComponent(updateBtn)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(RegUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(regPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectFor)
                    .addComponent(selecBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddMember)
                    .addComponent(updateBtn)
                    .addComponent(deleteBtn))
                .addContainerGap())
        );

        backBtn.setIcon(new javax.swing.ImageIcon("/home/rakibul/Documents/LibraryManagement/backIcon.png")); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        memTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "User ID", "ID", "Department", "E-mail", "Password", "Status"
            }
        ));
        memTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(memTable);

        teacTable.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        teacTable.setText("Teachers");
        teacTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacTableActionPerformed(evt);
            }
        });

        stdTable.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        stdTable.setText("Students");
        stdTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(249, 249, 249)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(teacTable, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(stdTable, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(teacTable)
                            .addComponent(stdTable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        new MainUserInterface().setVisible(true);
        this.setVisible(false);
        cleanTxt();
    }//GEN-LAST:event_backBtnActionPerformed

    public void tableLoad(String s){
        try {
            
            if(s.equals("Teacher")){
            pst = (PreparedStatement) con.prepareStatement("SELECT * FROM teacher");}
            else{
             pst = (PreparedStatement) con.prepareStatement("SELECT * FROM student");   
            }
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            DefaultTableModel df = (DefaultTableModel) memTable.getModel();
            df.setRowCount(0);
            if(s.equals("Teacher")){
                while (rs.next()) {   
                
                String nameString = rs.getString("name");
                String userString = rs.getString("userID");
                String idString = rs.getString("teacherID");
                String DepString = rs.getString("department");
                String mailString = rs.getString("email");
                String PassString = rs.getString("password");
                String StatusString = "Teacher";
                
                String tbData[] = {nameString,userString,idString,DepString,mailString,PassString,StatusString};
                df.addRow(tbData);
                
            }
            }
            else{
                while (rs.next()) {   
                
                String nameString = rs.getString("name");
                String userString = rs.getString("userId");
                String idString = rs.getString("studentID");
                String DepString = rs.getString("department");
                String mailString = rs.getString("email");
                String PassString = rs.getString("password");
                String StatusString = "Student";
                
                String tbData[] = {nameString,userString,idString,DepString,mailString,PassString,StatusString};
                df.addRow(tbData);
                
            }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    private void AddMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMemberActionPerformed
        try {
            String nameTxt = name.getText();
            String regU = RegUserId.getText();
            String stId = Id.getText();
            String dep = department.getText();
            String mail = email.getText();
            String regpassw = regPass.getText();
            String StatsString = selecBox.getSelectedItem().toString();
            // TODO add your handling code here:
            if(StatsString.equals("Student")){
            pst = (PreparedStatement) con.prepareStatement("INSERT INTO student (name, userId, studentID, department, email, password) VALUES (?,?,?,?,?,?)");}
            else{
                pst = (PreparedStatement) con.prepareStatement("INSERT INTO teacher (name, userID, teacherID, department, email, password) VALUES (?,?,?,?,?,?)");
            }
            pst.setString(1,nameTxt);
            pst.setString(2,regU);
            pst.setString(3,stId);
            pst.setString(4,dep);
            pst.setString(5,mail);
            pst.setString(6,regpassw);
            
            int k = pst.executeUpdate();
            
            if(k == 1)
            {
                JOptionPane.showMessageDialog(this, "Member Added");
                
                cleanTxt();
                tableLoad(StatsString);
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Error !!!");
                cleanTxt();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "This UserID already exsts.");
            //.getLogger(StudentLoginRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_AddMemberActionPerformed

    private void teacTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacTableActionPerformed
        // TODO add your handling code here:
        tableLoad("Teacher");
    }//GEN-LAST:event_teacTableActionPerformed

    private void stdTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdTableActionPerformed
        // TODO add your handling code here:
        tableLoad("Student");
    }//GEN-LAST:event_stdTableActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            if(stat.equals("Teacher")){
            update = (PreparedStatement) con.prepareStatement("UPDATE teacher SET name=?, userID=?, email=? , password = ? ,department = ? where teacherID=?");
            update.setString(1, name.getText());
            update.setString(2, RegUserId.getText());
            update.setString(3, email.getText());
            update.setString(4, regPass.getText());
            update.setString(5, department.getText());
            update.setString(6, id);
            int t = update.executeUpdate();
            if(t==1)
            {
                JOptionPane.showMessageDialog(this, "Table Updated");
                cleanTxt();
                tableLoad(stat);
            }else{
                JOptionPane.showMessageDialog(this, "Error !!!!");
                cleanTxt();
            }
            }
            else{
            update = (PreparedStatement) con.prepareStatement("UPDATE student SET name=?, userId=?, email=? , password = ? where studentID=?");
            update.setString(1, name.getText());
            update.setString(2, RegUserId.getText());
            update.setString(3, email.getText());
            update.setString(4, regPass.getText());
            update.setString(5, id);
            int t = update.executeUpdate();
            if(t==1)
            {
                JOptionPane.showMessageDialog(this, "Table Updated");
                cleanTxt();
                tableLoad(stat);
            }else{
                JOptionPane.showMessageDialog(this, "Error !!!!");
                cleanTxt();
            }
            }
                    } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if(stat.equals("Teacher")){
            delete = (PreparedStatement) con.prepareStatement("delete from teacher where teacherID=?");}
            else{
            delete = (PreparedStatement) con.prepareStatement("delete from student where studentID=?");    
            }
            delete.setString(1, id);
            int d1 = delete.executeUpdate();
            if(d1==1){
                JOptionPane.showMessageDialog(this, "Member Deleted");
                cleanTxt();
                tableLoad(stat);
            }else{
                JOptionPane.showMessageDialog(this, "Error !!!");
                cleanTxt();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void memTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel d = (DefaultTableModel) memTable.getModel();
        int selectedIndex = memTable.getSelectedRow();
        name.setText(d.getValueAt(selectedIndex, 0).toString());
        RegUserId.setText(d.getValueAt(selectedIndex, 1).toString());
        id = d.getValueAt(selectedIndex, 2).toString();
        Id.setText(d.getValueAt(selectedIndex, 2).toString());
        department.setText(d.getValueAt(selectedIndex, 3).toString());
        email.setText(d.getValueAt(selectedIndex, 4).toString());
        regPass.setText(d.getValueAt(selectedIndex, 5).toString());
        stat = d.getValueAt(selectedIndex, 6).toString();
        selecBox.setSelectedItem(stat);
        
    }//GEN-LAST:event_memTableMouseClicked

    
     private void cleanTxt(){
        name.setText("");
        RegUserId.setText("");
        Id.setText("");
        department.setText("");
        email.setText("");
        regPass.setText("");
        selecBox.setSelectedIndex(-1);
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
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddMember;
    private javax.swing.JTextField Id;
    private javax.swing.JTextField RegUserId;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField department;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable memTable;
    private javax.swing.JTextField name;
    private javax.swing.JTextField regPass;
    private javax.swing.JComboBox<String> selecBox;
    private javax.swing.JLabel selectFor;
    private javax.swing.JButton stdTable;
    private javax.swing.JButton teacTable;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
