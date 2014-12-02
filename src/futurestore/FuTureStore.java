/*
 * FuTureStore.java
 *
 * Created on September 9, 2010, 6:45 PM
 */

package futurestore;

import java.awt.Cursor;
import javax.swing.ActionMap;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author  Administrator
 */
public class FuTureStore extends javax.swing.JDialog {
    
    /** Creates new form FuTureStore */
    public FuTureStore(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getRootPane().setDefaultButton(BtnOK);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        BtnOK = new javax.swing.JButton();
        BtnReset = new javax.swing.JButton();
        BtnExit = new javax.swing.JButton();
        LblMinSupport = new javax.swing.JLabel();
        LblMinConfidence = new javax.swing.JLabel();
        lblDataFile = new javax.swing.JLabel();
        TxtDataFile = new javax.swing.JTextField();
        SpnMinSupport = new javax.swing.JSpinner();
        SpnMinConfidence = new javax.swing.JSpinner();
        BtnBrowse = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtACode = new javax.swing.JTextArea();

        FileChooser.setDialogTitle("Select a File");
        FileChooser.setFileFilter(new MyCustomFilter());
        FileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileChooserActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Future Store Super Market");
        setBackground(new java.awt.Color(204, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Future Store", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        BtnOK.setMnemonic('O');
        BtnOK.setText("OK");
        BtnOK.setMaximumSize(new java.awt.Dimension(61, 23));
        BtnOK.setMinimumSize(new java.awt.Dimension(61, 23));
        BtnOK.setNextFocusableComponent(BtnReset);
        BtnOK.setPreferredSize(new java.awt.Dimension(61, 23));
        BtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOKActionPerformed(evt);
            }
        });

        BtnReset.setMnemonic('R');
        BtnReset.setText("Reset");
        BtnReset.setNextFocusableComponent(BtnExit);
        BtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetActionPerformed(evt);
            }
        });

        BtnExit.setMnemonic('x');
        BtnExit.setText("Exit");
        BtnExit.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        BtnExit.setMaximumSize(new java.awt.Dimension(61, 23));
        BtnExit.setMinimumSize(new java.awt.Dimension(61, 23));
        BtnExit.setPreferredSize(new java.awt.Dimension(61, 23));
        BtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExitActionPerformed(evt);
            }
        });

        LblMinSupport.setText("Minimum Support");

        LblMinConfidence.setText("Minimum Confidence");

        lblDataFile.setText("Transaction File");

        TxtDataFile.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        TxtDataFile.setMinimumSize(new java.awt.Dimension(7, 20));
        TxtDataFile.setNextFocusableComponent(BtnBrowse);
        TxtDataFile.setPreferredSize(new java.awt.Dimension(7, 20));

        SpnMinSupport.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        SpnMinSupport.setNextFocusableComponent(SpnMinConfidence);
        //SpnMinSupport.setModel(new SpinnerNumberModel(0, 0, 100, 1));

        SpnMinConfidence.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        SpnMinConfidence.setNextFocusableComponent(BtnOK);
        //SpnMinConfidence.setModel(new SpinnerNumberModel(0, 0, 100, 1));

        BtnBrowse.setMnemonic('B');
        BtnBrowse.setText("Browse");
        BtnBrowse.setNextFocusableComponent(SpnMinSupport);
        BtnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(BtnOK, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnReset, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblMinConfidence)
                            .addComponent(LblMinSupport)
                            .addComponent(lblDataFile, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtDataFile, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(SpnMinConfidence, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                    .addComponent(SpnMinSupport, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                                .addGap(228, 228, 228)))))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(BtnBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(BtnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDataFile, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(TxtDataFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblMinSupport)
                    .addComponent(SpnMinSupport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LblMinConfidence, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SpnMinConfidence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Various Combos that can be made"));

        TxtACode.setColumns(1);
        TxtACode.setEditable(false);
        TxtACode.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jScrollPane1.setViewportView(TxtACode);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("Future Store Super Market");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOKActionPerformed
        // TODO add your handling code here:
        String result[]=new String[100];
        BtnOK.setEnabled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        
        TransactionFile file=new TransactionFile(TxtDataFile.getText());
        if(TxtDataFile.getText().isEmpty())     //check the file is selected or not
        {
            result[0]="Please select the file";
            JOptionPane.showMessageDialog(this, result[0]);
            //JOptionPane.showConfirmDialog(this, result[0],"Future Store analysis",);
        } 
        else if(!file.check_file())     //check whether the file is in correct format or not
        {
            result[0]="Incorrect file format... Select the CSV(Comma Delimited) file";
            JOptionPane.showMessageDialog(this, result[0]);
            //JOptionPane.showConfirmDialog(this, result[0],"Future Store analysis",);
        }
        //to check whether minimum support and confidence values are set properly or not
        else if(Integer.parseInt(SpnMinSupport.getValue().toString())<=0 && Integer.parseInt(SpnMinConfidence.getValue().toString())<=0)
        {
            result[0]="Specify correct support and confidence value... i.e. greater than 1";
            //TxtACode.setText("Specify correct support and confidence value... i.e. greater than 1");
            JOptionPane.showMessageDialog(this, result[0]);
        }
        //to check whether minimum support is properly set or not
        else if(Integer.parseInt(SpnMinSupport.getValue().toString())<=0)
        {
            result[0]="Specify correct support value... i.e. greater than 1 ";
            //TxtACode.setText("Specify correct support value... i.e. greater than 1 ");
            JOptionPane.showMessageDialog(this, result[0]);
        }
        //to check whether confidence is properly set or not
        else if(Integer.parseInt(SpnMinConfidence.getValue().toString())<=0)
        {
            result[0]="Specify correct confidence value... i.e. greater than 1 ";
            //TxtACode.setText("Specify correct confidence value... i.e. greater than 1 ");
            JOptionPane.showMessageDialog(this, result[0]);
        }
        //if all the conditions are right then this will be executed to find the association rules
        else
        {
            PolicyGeneration Calculate= new PolicyGeneration(TxtDataFile.getText(), Integer.parseInt(SpnMinSupport.getValue().toString()), Integer.parseInt(SpnMinConfidence.getValue().toString()));
            try
            {
                result=Calculate.Set_Result();
                System.out.println("Final result displayed");
                System.out.println(result.length);
                TxtACode.setText("");
                TxtACode.setText(result[0]);
                for(int i=0;i<result.length;i++)
                System.out.println(result[i]);
        
                //add result to the text area to diplay the final result
                for(int result_count=1; result_count<result.length; result_count++)
                    TxtACode.append("\n" + result[result_count]);
        //JOptionPane.showConfirmDialog(this, result[0],"Future Store analysis",1);
        
            }
            catch(NullPointerException e)
            { 
                System.out.println("Value not present");
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Array");
            }
            JOptionPane.showMessageDialog(this, "Successfully Completed");
        }
        
        BtnOK.setEnabled(true);
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_BtnOKActionPerformed

    
    private void BtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetActionPerformed
        // TODO add your handling code here:
        TxtDataFile.setText("");
        SpnMinSupport.setValue(0);
        SpnMinConfidence.setValue(0);     
        TxtACode.setText("");
    }//GEN-LAST:event_BtnResetActionPerformed

    
    private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_BtnExitActionPerformed

    
    
    //to provide the facility to select the file
    private void BtnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBrowseActionPerformed
        // TODO add your handling code here:
        TxtDataFile.setText("");
        int returnVal = FileChooser.showOpenDialog(this);
    if (returnVal == FileChooser.APPROVE_OPTION) {
        File file = FileChooser.getSelectedFile();       
          TxtDataFile.setText(file.getAbsolutePath());
         }
     else {
        System.out.println("File access cancelled by user.");
    }

    }//GEN-LAST:event_BtnBrowseActionPerformed

    private void FileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileChooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FileChooserActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FuTureStore dialog = new FuTureStore(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setLocation(400, 180);
                dialog.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBrowse;
    private javax.swing.JButton BtnExit;
    private javax.swing.JButton BtnOK;
    private javax.swing.JButton BtnReset;
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JLabel LblMinConfidence;
    private javax.swing.JLabel LblMinSupport;
    private javax.swing.JSpinner SpnMinConfidence;
    private javax.swing.JSpinner SpnMinSupport;
    private javax.swing.JTextArea TxtACode;
    private javax.swing.JTextField TxtDataFile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDataFile;
    // End of variables declaration//GEN-END:variables
    
}


class MyCustomFilter extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(File file) {
            // Allow only directories, or files with ".txt" extension
            return file.isDirectory() || file.getAbsolutePath().endsWith(".csv");
        }
        @Override
        public String getDescription() {
            // This description will be displayed in the dialog,
            // hard-coded = ugly, should be done via I18N
            return "(*.csv) Comma Delimited";
        }
    }