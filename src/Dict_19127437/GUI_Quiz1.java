package Dict_19127437;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GUI_Quiz1 extends javax.swing.JFrame {

    ButtonGroup btgroup;
    static String trl;

    public GUI_Quiz1() {

        initComponents();
        start();

    }

    private void initComponents() {

        btgroup = new ButtonGroup();
        btgroup.add(jRadioButton1);
        btgroup.add(jRadioButton2);
        btgroup.add(jRadioButton3);
        btgroup.add(jRadioButton4);


        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GUI_Quiz_find_definition_19127437");
        setLocationRelativeTo(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 13));
        jLabel1.setText("jLabel1");

        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(215, 215, 215))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(30, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jRadioButton1)
                                                        .addComponent(jRadioButton3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jRadioButton2)
                                                        .addComponent(jRadioButton4))
                                                .addGap(112, 112, 112))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18 , 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jRadioButton1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton3)
                                        .addComponent(jRadioButton4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(43, 43, 43))
        );

        pack();
    }
    public void start(){
        slangmanager.Load_Data_Slangword();
        String random=slangmanager.getrandom();
        Random r = new Random();
        List<String> Ans= slangmanager.list.get(random);

        int index = r.nextInt(Ans.size());
        String Answer = Ans.get(index);
        trl = Answer;
        List<String> list_question=new ArrayList<>();
        int check=0;
        while(check<3){
            String slangnew = slangmanager.getrandom();
            if(!slangnew.equals(random)) {
                List<String> new_Ans = slangmanager.list.get(slangnew);
                String Answer_1 = new_Ans.get(r.nextInt(new_Ans.size()));
                check=check+1;
                list_question.add(Answer_1);
            }
            if(check==3)
                break;
        }
        list_question.add(Answer);
        Collections.shuffle(list_question);
        jLabel1.setText("-Đâu là nghĩa của từ " + random +" mời bạn chọn 1 trong 4 đáp án");
        jRadioButton1.setLabel(list_question.get(0));
        jRadioButton1.setActionCommand(list_question.get(0));

        btgroup.add(jRadioButton1);
        jRadioButton1.setSelected(true);

        jRadioButton2.setLabel(list_question.get(1));
        jRadioButton2.setActionCommand(list_question.get(1));

        btgroup.add(jRadioButton2);
        jRadioButton2.setSelected(true);

        jRadioButton3.setLabel(list_question.get(2));
        jRadioButton3.setActionCommand(list_question.get(2));

        btgroup.add(jRadioButton3);
        jRadioButton3.setSelected(true);

        jRadioButton4.setLabel(list_question.get(3));
        jRadioButton4.setActionCommand(list_question.get(3));
        btgroup.add(jRadioButton4);
        jRadioButton4.setSelected(true);

        btgroup.clearSelection();
    }


    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        repaint();
        jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        jRadioButton3.setEnabled(true);
        jRadioButton4.setEnabled(true);
        if(btgroup.getSelection() == null){
            String checkq  = "";
            System.out.print(checkq);
        }else {
            String check =  btgroup.getSelection().getActionCommand();
            if(check.equals(trl)){
                JOptionPane.showMessageDialog(this, " Chúc mừng bạn đẽ trả lời đúng");

                int option = JOptionPane.showConfirmDialog(this, "Bạn muốn tiếp tục câu khác không ?"  );
                if (option == 0){
                    start();
                }
            }
            else{
                JOptionPane.showMessageDialog(this, " Ohhhno bạn trả lời sai rồi ");

                int option = JOptionPane.showConfirmDialog(this, "Bạn muốn tiếp tục câu khác không ?"  );
                if (option == 0){
                    start();
                }
            }
        }

    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;


}

