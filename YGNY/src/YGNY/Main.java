package YGNY;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            KioskFrame frame = new KioskFrame();
            frame.setVisible(true);
        });
    }
}
