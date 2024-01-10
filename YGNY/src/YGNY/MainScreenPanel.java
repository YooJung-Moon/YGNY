package YGNY;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;

public class MainScreenPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public MainScreenPanel(Runnable onBackClicked, Runnable onHomeClicked) {
        setLayout(new BorderLayout());

        // 이미지 아이콘 생성
        ImageIcon backIcon = createImageIcon("back.png", 50, 50);
        ImageIcon homeIcon = createImageIcon("home.png", 50, 50);
        ImageIcon mapIcon = createImageIcon("seoul.png", 50, 50);

        JPanel topPanel = new JPanel(new BorderLayout());

        // 뒤로 가기 및 홈 버튼
        JButton btnBack = createButton(backIcon);
        JButton btnHome = createButton(homeIcon);

        btnBack.addActionListener(e -> onBackClicked.run());
        btnHome.addActionListener(e -> onHomeClicked.run());

        // 지도 버튼
        JButton btnMap = createButton(mapIcon);

        // 계정 관리 버튼
        JButton btnAccount = new JButton("계정 관리");

        // 버튼 및 패널 스타일
        btnMap.setBorderPainted(false);
        btnMap.setContentAreaFilled(false);
        btnAccount.setBorderPainted(false);
        btnAccount.setContentAreaFilled(false);

        // 버튼 아이콘을 클릭하면 액션 리스너 호출
        btnMap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 지도 버튼 클릭 시 동작 추가
            }
        });

        topPanel.add(btnBack, BorderLayout.WEST);
        topPanel.add(btnHome, BorderLayout.EAST);
        topPanel.add(btnMap, BorderLayout.CENTER);

        // 중앙 버튼: 대여 및 반납 (크기 및 위치 조절)
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10)); // 여백 추가

        // 대여와 반납 버튼
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));
        JButton btnRent = createButton("대여");
        JButton btnReturn = createButton("반납");

        bottomPanel.add(btnRent);
        bottomPanel.add(btnReturn);

        setLayout(new BorderLayout());

        // 화면 구성
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private ImageIcon createImageIcon(String filename, int width, int height) {
        try {
            ImageIcon icon = new ImageIcon(ImageIO.read(new File(filename)));
            Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private JButton createButton(ImageIcon icon) {
        JButton button = new JButton(icon);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        return button;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 75));
        return button;
    }
}
