/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldengymclub;

/**
 *
 * @author Neoh
 */
import goldengymclub.database.Database;
import goldengymclub.util.Admin;
import goldengymclub.util.Member;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class SelectActionPage extends javax.swing.JFrame {

    /**
     * Creates new form SelectActionPage
     * 
     * 
     */
    
    public static ArrayList<Member> memberList = new ArrayList();
    public ArrayList<Member> filteredMemberList = new ArrayList();
    private DefaultListModel<String> listModel = new DefaultListModel();
    private static Admin admin = null;
    
    public SelectActionPage(Admin admin) {
        initComponents();
        
        this.admin = admin;
        
        txt_admin_username.setText(admin.getUsername());
        
        txt_search.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
              //filterMember(txt_search.getText().toString());
            }
            public void removeUpdate(DocumentEvent e) {
              filterMember(txt_search.getText().toString());
            }
            public void insertUpdate(DocumentEvent e) {
              filterMember(txt_search.getText().toString());
            }

           
          });
        
         loadMemberList();
         
         list_member.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent ev) {
              
                if(!ev.getValueIsAdjusting()){
                  int position = list_member.getSelectedIndex();
                  Member member = filteredMemberList.get(position);
                  //JOptionPane.showMessageDialog(null, "Hello");
                  
                  new MemberDetailsDialog(member).show();
                }
                
            }
        });
     
    }
    
    public void filterMember(String keyword) {
         
        list_member.removeAll();
        listModel.removeAllElements();
        filteredMemberList.clear();
        
        if(keyword.isEmpty()){
            loadMemberList();
            return;
        }
        
        for(int i = 0; i<memberList.size(); i++){
            
            Member member = memberList.get(i);
            
            if(member.getFirstname().contains(keyword) || member.getLastname().contains(keyword)){
                //list_member.add(processMemberDetailsToString(member), new JLabel());
                
                filteredMemberList.add(member);
                listModel.addElement(member.toString());
                
            }
        }
        
        list_member.setModel(listModel);
               
    }
    
    public void loadMemberList(){
        
        list_member.removeAll();
        listModel.removeAllElements();
        
        memberList = Database.getInstance().getAllMember();
        filteredMemberList = memberList;
        
        for(int i = 0; i<memberList.size(); i++){
            
            Member member = memberList.get(i);
            
            listModel.addElement(member.toString());
            //list_member.add(processMemberDetailsToString(member), new JLabel());
            
        }
        
        list_member.setModel(listModel);
        
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
        txt_admin_username = new javax.swing.JLabel();
        btn_register_member = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_member = new javax.swing.JList<>();
        btn_add_admin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Admin :");

        txt_admin_username.setText("Username");

        btn_register_member.setText("Register New Member");
        btn_register_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_register_memberActionPerformed(evt);
            }
        });

        jLabel2.setText("List of Golden Gym Club members :");

        btn_logout.setText("Log Out");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        jLabel3.setText("Search : ");

        list_member.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(list_member);

        btn_add_admin.setText("Add Admin");
        btn_add_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_adminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_admin_username)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_add_admin))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btn_register_member)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_logout))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txt_admin_username))
                    .addComponent(btn_add_admin))
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_register_member)
                    .addComponent(btn_logout))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_register_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_register_memberActionPerformed
        // TODO add your handling code here:
        
        new MemberRegistrationPage(this).show();
        
    }//GEN-LAST:event_btn_register_memberActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
        
        new AdminLoginPage().show();
        this.dispose();
        
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_add_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_adminActionPerformed
        // TODO add your handling code here:
        
        new NewAdminPage().show();
        
    }//GEN-LAST:event_btn_add_adminActionPerformed

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
            java.util.logging.Logger.getLogger(SelectActionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectActionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectActionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectActionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectActionPage(admin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_admin;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_register_member;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list_member;
    private javax.swing.JLabel txt_admin_username;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
