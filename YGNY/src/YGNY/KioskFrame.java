package YGNY;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class KioskFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private Stack<String> screenStack;

    public KioskFrame() {
        setTitle("다회용기 대여 키오스크");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        screenStack = new Stack<>();

        LanguageSelectionPanel languageSelectionPanel = new LanguageSelectionPanel(this);
        MainScreenPanel mainScreenPanel = new MainScreenPanel(this::goBack, this::switchToLanguageSelection);

        cardPanel.add(languageSelectionPanel, "LanguageSelection");
        cardPanel.add(mainScreenPanel, "MainScreen");

        setContentPane(cardPanel);
        navigateTo("LanguageSelection");
    }

    public void navigateTo(String screenName) {
        cardLayout.show(cardPanel, screenName);
        screenStack.push(screenName);
    }

    public void goBack() {
        if (screenStack.size() > 1) {
            screenStack.pop(); 
            String previousScreen = screenStack.peek();
            cardLayout.show(cardPanel, previousScreen);
        }
    }

    public void switchToMainScreen() {
        navigateTo("MainScreen");
    }

    public void switchToLanguageSelection() {
        navigateTo("LanguageSelection");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KioskFrame frame = new KioskFrame();
            frame.setVisible(true);
        });
    }
}
