package YGNY;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContainerRental {
    private JFrame frame;
    private JRadioButton radioPlastic, radioMetal;
    private JComboBox<String> comboBoxCapacity;
    private JCheckBox checkBoxLid;

    public ContainerRental() {
        frame = new JFrame("다회용기 대여");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelMaterial = new JLabel("소재 선택:");
        ButtonGroup groupMaterial = new ButtonGroup();
        radioPlastic = new JRadioButton("스테인리스");
        radioMetal = new JRadioButton("유리");

        groupMaterial.add(radioPlastic);
        groupMaterial.add(radioMetal);

        JLabel labelCapacity = new JLabel("용량 선택:");
        comboBoxCapacity = new JComboBox<>(new String[]{"500ml", "870ml", "1000ml", "3000ml"});

        JLabel labelLid = new JLabel("뚜껑 여부:");
        checkBoxLid = new JCheckBox("뚜껑 포함");

        JButton btnRent = new JButton("담기");

        btnRent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 대여 버튼을 클릭했을 때 선택된 옵션 출력
                StringBuilder rentDetails = new StringBuilder("대여 내역:\n");

                if (radioPlastic.isSelected()) {
                    rentDetails.append("소재: 스테인리스\n");
                } else if (radioMetal.isSelected()) {
                    rentDetails.append("소재: 유리\n");
                }

                rentDetails.append("용량: ").append(comboBoxCapacity.getSelectedItem()).append("\n");

                if (checkBoxLid.isSelected()) {
                    rentDetails.append("뚜껑 포함: 예\n");
                } else {
                    rentDetails.append("뚜껑 포함: 아니오\n");
                }

                JOptionPane.showMessageDialog(frame, rentDetails.toString());
            }
        });

        panel.add(labelMaterial);
        panel.add(radioPlastic);
        panel.add(radioMetal);
        panel.add(labelCapacity);
        panel.add(comboBoxCapacity);
        panel.add(labelLid);
        panel.add(checkBoxLid);
        panel.add(btnRent);

        frame.getContentPane().add(panel);
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ContainerRental();
        });
    }
}
