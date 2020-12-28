package com.tictactoe.view;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    private JButton[][] bt_GameBoards = new JButton[3][3];;

    public GameBoard(){
        setBounds(0, 0, 300, 300);
        setLayout(new GridLayout(3, 3));
        initComps();
    }

    public void initComps(){
        // Thêm button
        for (int i = 0; i<bt_GameBoards.length; i++){
            for(int j = 0; j<bt_GameBoards[i].length; j++){
                JButton tmp = new JButton();
                tmp.setFont(new Font("Cambria", Font.BOLD, 40));
                tmp.setHorizontalAlignment(SwingConstants.CENTER);
                add(tmp);
                bt_GameBoards[i][j] = tmp;
            }
        }
    }

    public JButton[][] getBt_GameBoards(){
        return bt_GameBoards;
    }
}
