package com.tictactoe.view;

import javax.swing.*;
import java.awt.*;

public class WinView extends JFrame {
    private JPanel pn_mainPanel;
    private JLabel lb_winPlayer;

    public WinView(GUI gui){
        setSize(300, 200);
        setLayout(new CardLayout());
        setLocationRelativeTo(gui);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComps();
    }

    public void initComps(){
        pn_mainPanel = new JPanel();
        pn_mainPanel.setLayout(new CardLayout());
        pn_mainPanel.setBackground(new Color(241, 196, 15));

        lb_winPlayer = new JLabel();
        lb_winPlayer.setFont(new Font("Goudy Stout", Font.BOLD, 40));
        lb_winPlayer.setHorizontalAlignment(SwingConstants.CENTER);
        lb_winPlayer.setForeground(new Color(22, 160, 133));
        pn_mainPanel.add(lb_winPlayer);

        add(pn_mainPanel);
    }

    public JLabel getLb_winPlayer(){
        return lb_winPlayer;
    }
}
