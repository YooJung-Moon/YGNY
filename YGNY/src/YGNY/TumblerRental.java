package YGNY;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TumblerRental {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("텀블러 대여");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelMaterial = new JLabel("소재 선택:");
        ButtonGroup groupMaterial = new ButtonGroup();
        JRadioButton radioPlastic = new JRadioButton("플라스틱");
        JRadioButton radioMetal = new JRadioButton("스테인리스");

        groupMaterial.add(radioPlastic);
        groupMaterial.add(radioMetal);

        JLabel labelCapacity = new JLabel("용량 선택:");
        JComboBox<String> comboBoxCapacity = new JComboBox<>(new String[]{"350ml", "500ml", "700ml", "1000ml"});

        JLabel labelStraw = new JLabel("빨대 유무:");
        JCheckBox checkBoxStraw = new JCheckBox("빨대 포함");

        JButton btnOrder = new JButton("담기");

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 주문 버튼을 클릭했을 때 선택된 옵션 출력
                StringBuilder orderDetails = new StringBuilder("주문 내역:\n");

                if (radioPlastic.isSelected()) {
                    orderDetails.append("소재: 플라스틱\n");
                } else if (radioMetal.isSelected()) {
                    orderDetails.append("소재: 스테인리스\n");
                }

                orderDetails.append("용량: ").append(comboBoxCapacity.getSelectedItem()).append("\n");

                if (checkBoxStraw.isSelected()) {
                    orderDetails.append("빨대 포함: 예\n");
                } else {
                    orderDetails.append("빨대 포함: 아니오\n");
                }

                JOptionPane.showMessageDialog(frame, orderDetails.toString());
            }
        });

        panel.add(labelMaterial);
        panel.add(radioPlastic);
        panel.add(radioMetal);
        panel.add(labelCapacity);
        panel.add(comboBoxCapacity);
        panel.add(labelStraw);
        panel.add(checkBoxStraw);
        panel.add(btnOrder);

        frame.getContentPane().add(panel);
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}