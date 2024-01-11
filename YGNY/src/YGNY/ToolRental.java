package YGNY;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolRental {
    private JFrame frame;
    private JRadioButton radioPlastic, radioMetal;
    private JCheckBox checkBoxSpoon, checkBoxFork, checkBoxChopsticks;
    private JSpinner spinnerSpoon, spinnerFork, spinnerChopsticks;

    public ToolRental() {
        frame = new JFrame("수저 대여");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelMaterial = new JLabel("소재 선택:");
        ButtonGroup groupMaterial = new ButtonGroup();
        radioPlastic = new JRadioButton("스테인리스");
        radioMetal = new JRadioButton("나무");

        groupMaterial.add(radioPlastic);
        groupMaterial.add(radioMetal);

        JLabel labelUtensils = new JLabel("식기 선택:");

        checkBoxSpoon = new JCheckBox("숟가락");
        spinnerSpoon = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        JPanel spoonPanel = new JPanel();
        spoonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        spoonPanel.add(checkBoxSpoon);
        spoonPanel.add(new JLabel("수량:"));
        spoonPanel.add(spinnerSpoon);

        checkBoxFork = new JCheckBox("포크");
        spinnerFork = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        JPanel forkPanel = new JPanel();
        forkPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        forkPanel.add(checkBoxFork);
        forkPanel.add(new JLabel("수량:"));
        forkPanel.add(spinnerFork);

        checkBoxChopsticks = new JCheckBox("젓가락");
        spinnerChopsticks = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        JPanel chopsticksPanel = new JPanel();
        chopsticksPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        chopsticksPanel.add(checkBoxChopsticks);
        chopsticksPanel.add(new JLabel("수량:"));
        chopsticksPanel.add(spinnerChopsticks);

        JLabel labelQuantity = new JLabel("갯수:");

        JButton btnRent = new JButton("담기");

        btnRent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 대여 버튼을 클릭했을 때 선택된 옵션 및 식기 수량 출력
                StringBuilder rentDetails = new StringBuilder("대여 내역:\n");

                if (radioPlastic.isSelected()) {
                    rentDetails.append("소재: 스테인리스\n");
                } else if (radioMetal.isSelected()) {
                    rentDetails.append("소재: 나무\n");
                }

                rentDetails.append("식기 선택: ");
                if (checkBoxSpoon.isSelected()) {
                    rentDetails.append("숟가락(").append(spinnerSpoon.getValue()).append("), ");
                }
                if (checkBoxFork.isSelected()) {
                    rentDetails.append("포크(").append(spinnerFork.getValue()).append("), ");
                }
                if (checkBoxChopsticks.isSelected()) {
                    rentDetails.append("젓가락(").append(spinnerChopsticks.getValue()).append("), ");
                }

                JOptionPane.showMessageDialog(frame, rentDetails.toString().replaceAll(", $", ""));
            }
        });

        panel.add(labelMaterial);
        panel.add(radioPlastic);
        panel.add(radioMetal);
        panel.add(labelUtensils);
        panel.add(spoonPanel);
        panel.add(forkPanel);
        panel.add(chopsticksPanel);
        panel.add(labelQuantity);
        panel.add(btnRent);

        frame.getContentPane().add(panel);
        frame.setSize(300, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ToolRental();
        });
    }
}
