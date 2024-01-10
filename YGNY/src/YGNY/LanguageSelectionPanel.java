package YGNY;

import javax.swing.*;
import java.awt.*;

public class LanguageSelectionPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JButton btnEnglish, btnKorean;
    private KioskFrame parent;

    public LanguageSelectionPanel(KioskFrame parent) {
        this.parent = parent;
        setLayout(new BorderLayout());
        add(new JLabel("다회용기 사용을 독려하는 문구", SwingConstants.CENTER), BorderLayout.CENTER);

        JPanel languagePanel = new JPanel();
        btnEnglish = new JButton("English");
        btnKorean = new JButton("한국어");

        languagePanel.add(btnEnglish);
        languagePanel.add(btnKorean);

        add(languagePanel, BorderLayout.SOUTH);

        btnEnglish.addActionListener(e -> parent.switchToMainScreen());
        btnKorean.addActionListener(e -> parent.switchToMainScreen());
    }
}
