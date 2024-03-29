package Dict_19127437;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GUI_Showhistory extends javax.swing.JFrame {
    DefaultTableModel tableModel;
    public GUI_Showhistory() {
        initComponents();
        tableModel = (DefaultTableModel) jTable1.getModel();
    }

    private void initComponents() {

        label1 = new java.awt.Label();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        JBreset = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GUI_Show_history_19127437");
        setLocationRelativeTo(null);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Tahoma", 0, 14));
        label1.setText("Input");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Definition");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Slangword");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        JBreset.setText("Delete history");
        JBreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBresetActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "History"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(jButton1)
                                                .addGap(45, 45, 45)
                                                .addComponent(jButton2)
                                                .addGap(40, 40, 40)
                                                .addComponent(JBreset))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField1)
                                        .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(JBreset))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
        );

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void JBresetActionPerformed(java.awt.event.ActionEvent evt) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(slangmanager.File_history)))) {
            bw.write("");
            bw.newLine();
        }catch (IOException e) {
            System.out.print("Update fail!!!");
            e.printStackTrace();
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        slangmanager.Load_Data_Slangword();
        tableModel.setRowCount(0);
        List<String> arr = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(new File(slangmanager.File_history)))) {
            String str=null;
            while (true) {
                str = br.readLine();
                if (str == null) {
                    break;
                }
                arr.add(str);

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(arr.isEmpty()){
            JOptionPane.showMessageDialog(this, "File history.txt rỗng");
        }
        else{
            String defi="Definition:";

            List<String> arr1 = new ArrayList<>();
            for(String k : arr){
                if( k.contains(defi)){
                    arr1.add(k);
                }
            }
            for(int i=0;i<arr1.size();i++){
                tableModel.addRow(new Object[]{ arr1.get(i)});
            }
        }

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        tableModel.setRowCount(0);
        List<String> arr = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(new File(slangmanager.File_history)))) {
            String str=null;
            while (true) {
                str = br.readLine();
                if (str == null) {
                    break;
                }
                arr.add(str);

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(arr.isEmpty()){
            JOptionPane.showMessageDialog(this, "File history.txt rỗng");
        }
        else{
            String defi="Slangword:";

            List<String> arr1 = new ArrayList<>();
            for(String k : arr){
                if( k.contains(defi)){
                    arr1.add(k);
                }
            }
            for(int i=0;i<arr1.size();i++){
                tableModel.addRow(new Object[]{ arr1.get(i)});
            }
        }
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton JBreset;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;

}