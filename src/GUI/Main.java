/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.table.DefaultTableModel;
import Assembler.Assembler;
import Assembler.Instruction;
import FileHandler.FileIO;
import com.sun.rowset.internal.Row;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import memory.SegmentDefragmenter;

/**
 *
 * @author Alirez
 */
public class Main extends javax.swing.JFrame {

    String filePath = null;
    int lineOfInstructions;
    Monitor monitor;
    Computer computer;
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        assembleButton.setVisible(false);
        runButton.setVisible(false);
        nextIns.setVisible(false);
        execAll.setVisible(false);
        computer = new Computer();

        computer.fix_memory_table(memoryTable);
        monitor = new Monitor(computer.aa.getMemory());
        
        for (int i = 0; i < mipsCode.getRowCount(); i++) {
            mipsCode.setValueAt(Integer.toHexString(i*4), i, 0);
        }
        setStyle(mipsCode);
        setStyle(program1);
        setStyle(program2);
        setStyle(program3);
        loadprograms();
}
    private void loadprograms(){
        HashMap<Integer, SegmentDefragmenter> programs= computer.aa.getPrograms();
        System.out.println(programs.toString());
        SegmentDefragmenter sd = programs.get(0);
        ArrayList<String> starr = sd.getCode_seg();
        int start_address =Integer.parseInt(sd.getCode_seg_start_address(), 16);
        for (int i = 0; i < starr.size(); i++) {
            DefaultTableModel model = (DefaultTableModel) program1.getModel();
            model.addRow(new Object[]{Integer.toHexString(start_address+i*4),"",starr.get(i),""});
        }
        sd = programs.get(1);
        starr = sd.getCode_seg();
        start_address =Integer.parseInt(sd.getCode_seg_start_address(), 16);
        for (int i = 0; i < starr.size(); i++) {
            DefaultTableModel model = (DefaultTableModel) program2.getModel();
            model.addRow(new Object[]{Integer.toHexString(start_address+i*4),"",starr.get(i),""});
        }
        sd = programs.get(2);
        starr = sd.getCode_seg();
        start_address =Integer.parseInt(sd.getCode_seg_start_address(), 16);
        for (int i = 0; i < starr.size(); i++) {
            DefaultTableModel model = (DefaultTableModel) program3.getModel();
            model.addRow(new Object[]{Integer.toHexString(start_address+i*4),"",starr.get(i),""});
        }
        
    }
    
    private void setStyle(JTable table){
        table.setEnabled(false);
        table.getColumn("Assembled").setMinWidth(180);
        table.getColumn("Code").setMaxWidth(150);
        table.getColumn("Code").setMinWidth(110);
        table.getColumn("Add.").setMaxWidth(90);
        table.getColumn("C").setMaxWidth(20);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        assemblyTab = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        mipsCode =  new JTable(new DefaultTableModel(new Object[]{"Column1", "Column2","Column1", "Column2"},3));
        jScrollPane8 = new javax.swing.JScrollPane();
        program1 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        program2 = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        program3 = new javax.swing.JTable();
        assembleButton = new javax.swing.JButton();
        monitors = new javax.swing.JTabbedPane();
        memoryTableContainer = new javax.swing.JScrollPane();
        memoryTable = new JTable(new DefaultTableModel(new Object[]{"Address", "Contain"},0));
        jScrollPane3 = new javax.swing.JScrollPane();
        Simonitor = new javax.swing.JTextArea();
        otherTable = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        regTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        cp0Table = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        cp1Table = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        dataCacheMon = new javax.swing.JTextArea();
        runButton = new javax.swing.JButton();
        nextIns = new javax.swing.JButton();
        execAll = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mipsCode.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Add.", "Code", "Assembled", "C"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        mipsCode.setToolTipText("");
        mipsCode.setAutoscrolls(false);
        mipsCode.setName(""); // NOI18N
        mipsCode.setVerifyInputWhenFocusTarget(false);
        jScrollPane6.setViewportView(mipsCode);

        assemblyTab.addTab("Code", jScrollPane6);

        program1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Add.", "Code", "Assembled", "C"
            }
        ));
        jScrollPane8.setViewportView(program1);

        assemblyTab.addTab("Program 1", jScrollPane8);

        program2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Add.", "Code", "Assembled", "C"
            }
        ));
        jScrollPane9.setViewportView(program2);

        assemblyTab.addTab("Program 2", jScrollPane9);

        program3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Add.", "Code", "Assembled", "C"
            }
        ));
        jScrollPane10.setViewportView(program3);

        assemblyTab.addTab("Program 3", jScrollPane10);

        assembleButton.setText("Assemble");
        assembleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assembleButtonActionPerformed(evt);
            }
        });

        memoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Address", "Content"
            }
        ));
        memoryTableContainer.setViewportView(memoryTable);

        monitors.addTab("Memory", memoryTableContainer);

        Simonitor.setEditable(false);
        Simonitor.setColumns(80);
        Simonitor.setRows(25);
        Simonitor.setWrapStyleWord(true);
        Simonitor.setFocusable(false);
        jScrollPane3.setViewportView(Simonitor);

        monitors.addTab("Monitor", jScrollPane3);

        regTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"0 zero", null, "8   t0", null, "16 s0", null, "24 t8", null},
                {"1*at", null, "9   t1", null, "17 s1", null, "25 t9", null},
                {"2 v0", null, "10 t2", null, "18 s2", null, "26*k0", null},
                {"3 v1", null, "11 t3", null, "19 s3", null, "27*k1", null},
                {"4 a0", null, "12 t4", null, "20 s4", null, "28 gp", null},
                {"5 a1", null, "13 t5", null, "21 s5", null, "29 sp", null},
                {"6 a2", null, "14 t6", null, "22 s6", null, "30 fp", null},
                {"7 a3", null, "15 t7", null, "23 s7", null, "31 ra", null}
            },
            new String [] {
                "Reg", "Value", "Reg", "Value", "Reg", "Value", "Reg", "Value"
            }
        ));
        regTable.setRequestFocusEnabled(false);
        regTable.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(regTable);

        otherTable.addTab("Registers", jScrollPane1);

        cp0Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"0 Context", null, "8   BadVAddr", null, "16 Config", null, "24 DEPC", null},
                {"1 Random", null, "9   Count", null, "17 LLAddr", null, "25 PerfCtl", null},
                {"2 EntryLo0", null, "10 EntryHi", null, "18 WatchLo", null, "26 ECC", null},
                {"3 EntryLo1", null, "11 Compare", null, "19 WatchHi", null, "27 CacheErr", null},
                {"4 Context", null, "12 SR", null, "20", null, "28 TagLo", null},
                {"5 PageMask", null, "13 Cause", null, "21 ", null, "29 TagHi", null},
                {"6 Wired", null, "14 EPC", null, "22 ", null, "30 ErrorEPC", null},
                {"7 HWREna", null, "15 PRId", null, "23 Debug", null, "31 DESAVE", null}
            },
            new String [] {
                "Reg", "Value", "Reg", "Value", "Reg", "Value", "Reg", "Value"
            }
        ));
        jScrollPane4.setViewportView(cp0Table);

        otherTable.addTab("CP0", jScrollPane4);

        cp1Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"0", null, "8   ", null, "16 ", null, "24 ", null},
                {"1", null, "9   ", null, "17 ", null, "25 ", null},
                {"2 ", null, "10 ", null, "18 ", null, "26", null},
                {"3 ", null, "11 ", null, "19 ", null, "27", null},
                {"4 ", null, "12 ", null, "20 ", null, "28 ", null},
                {"5 ", null, "13 ", null, "21 ", null, "29 ", null},
                {"6 ", null, "14 ", null, "22 ", null, "30 ", null},
                {"7 ", null, "15 ", null, "23 ", null, "31 ", null}
            },
            new String [] {
                "Reg", "Value", "Reg", "Value", "Reg", "Value", "Reg", "Value"
            }
        ));
        jScrollPane5.setViewportView(cp1Table);

        otherTable.addTab("CP1", jScrollPane5);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"PC", null, "", null, "", null, "", null},
                {"hi", null, "", null, "", null, "", null},
                {"lo", null, "", null, "", null, "", null},
                {"", null, "", null, "", null, "", null},
                {"", null, "", null, "", null, "", null},
                {"", null, "", null, "", null, "", null},
                {"", null, "", null, "", null, "", null},
                {"", null, "", null, "", null, "", null}
            },
            new String [] {
                "Reg", "Value", "Reg", "Value", "Reg", "Value", "Reg", "Value"
            }
        ));
        jScrollPane11.setViewportView(jTable3);

        otherTable.addTab("Other", jScrollPane11);

        dataCacheMon.setColumns(20);
        dataCacheMon.setRows(5);
        jScrollPane2.setViewportView(dataCacheMon);

        otherTable.addTab("Data Cache", jScrollPane2);

        runButton.setText("Run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        nextIns.setText("Next Step");
        nextIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextInsActionPerformed(evt);
            }
        });

        execAll.setText("Execute All");
        execAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                execAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(assembleButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(runButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextIns)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(execAll))
                    .addComponent(assemblyTab, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(otherTable)
                    .addComponent(monitors, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(assemblyTab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(runButton)
                    .addComponent(nextIns)
                    .addComponent(execAll)
                    .addComponent(assembleButton))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(monitors, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(otherTable, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Open File...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem3.setText("Document");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);
        jMenu2.add(jSeparator2);

        jMenuItem5.setText("Bug Report");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);
        jMenu2.add(jSeparator3);

        jMenuItem4.setText("About");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser input = new JFileChooser();
        int result = input.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            filePath = input.getSelectedFile().getAbsolutePath();
            System.out.println(filePath);
            String file = FileIO.Fread(filePath.replace("\\", "/"));
            String[] line = file.split("\n");
            for (int i = 0; i < line.length; i++) {
                DefaultTableModel model = (DefaultTableModel) mipsCode.getModel();
                model.addRow(new Object[]{Integer.toHexString(i*4),line[i],"",""});
            }
            assembleButton.setVisible(true);
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("Cancel was selected");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void execAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_execAllActionPerformed
        while (computer.currentLineOfInstructions < computer.lineOfInstructions) {
            computer.runSingleSigle();
        }
        computer.fix_memory_table(memoryTable);
        computer.Fix_regfile_table(regTable);
        dataCacheMon.setText(computer.get_cache_mem());
        execAll.setVisible(false);
        runButton.setVisible(true);
        nextIns.setVisible(false);
    }//GEN-LAST:event_execAllActionPerformed

    private void nextInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextInsActionPerformed
        if (computer.runSingleSigle()) {
            computer.fix_memory_table(memoryTable);
            Simonitor.setText(monitor.toString());
            int pc = (computer.getPC())*4; 
            mipsCode.clearSelection();
            program1.clearSelection();
            program2.clearSelection();
            program3.clearSelection();
            for(int i=0;i<mipsCode.getRowCount();i++){
                if(Integer.parseInt((String) mipsCode.getValueAt(i, 0),16) == pc)
                {
                    assemblyTab.setSelectedIndex(0);
                    mipsCode.setRowSelectionInterval(i, i);
                }
            }
            for(int i=0;i<program1.getRowCount();i++){
                if(Integer.parseInt((String) program1.getValueAt(i, 0),16) == pc)
                {
                    assemblyTab.setSelectedIndex(0);
                    program1.setRowSelectionInterval(i, i);
                }
            }
            for(int i=0;i<program2.getRowCount();i++){
                if(Integer.parseInt((String) program2.getValueAt(i, 0),16) == pc)
                {
                    assemblyTab.setSelectedIndex(0);
                    program2.setRowSelectionInterval(i, i);
                }
            }
            for(int i=0;i<program3.getRowCount();i++){
                if(Integer.parseInt((String) program3.getValueAt(i, 0),16) == pc)
                {
                    assemblyTab.setSelectedIndex(0);
                    program3.setRowSelectionInterval(i, i);
                }
            }
            computer.Fix_regfile_table(regTable);
            dataCacheMon.setText(computer.get_cache_mem());
        } else {
            nextIns.setVisible(false);
            runButton.setVisible(true);
        }
    }//GEN-LAST:event_nextInsActionPerformed

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        if (computer.isRunable()) {
            
            computer.run_init(filePath,lineOfInstructions);
            computer.Fix_regfile_table(regTable);
            runButton.setVisible(false);
            nextIns.setVisible(true);
            execAll.setVisible(true);
        }
    }//GEN-LAST:event_runButtonActionPerformed

    private void assembleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assembleButtonActionPerformed
        if (!filePath.isEmpty() && filePath != null) {
            Assembler assemble = new Assembler();
            HashMap<Integer, Instruction> assembled = new HashMap<Integer, Instruction>(assemble.assembleFile(filePath));            
            this.lineOfInstructions = assembled.size();
            for (int i = 0; i < assembled.size(); i++) {
                
                mipsCode.setValueAt(assembled.get(i).getAddress(), i, 0);
                mipsCode.setValueAt(assembled.get(i).getInstruction(), i, 2);
                
            }
            runButton.setVisible(true);
            nextIns.setVisible(false);
        }
    }//GEN-LAST:event_assembleButtonActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Simonitor;
    private javax.swing.JButton assembleButton;
    private javax.swing.JTabbedPane assemblyTab;
    private javax.swing.JTable cp0Table;
    private javax.swing.JTable cp1Table;
    private javax.swing.JTextArea dataCacheMon;
    private javax.swing.JButton execAll;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable memoryTable;
    private javax.swing.JScrollPane memoryTableContainer;
    private javax.swing.JTable mipsCode;
    private javax.swing.JTabbedPane monitors;
    private javax.swing.JButton nextIns;
    private javax.swing.JTabbedPane otherTable;
    private javax.swing.JTable program1;
    private javax.swing.JTable program2;
    private javax.swing.JTable program3;
    private javax.swing.JTable regTable;
    private javax.swing.JButton runButton;
    // End of variables declaration//GEN-END:variables
}
