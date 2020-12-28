package com.tictactoe.view;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class ScoreView extends JPanel {
    private JLabel gameTitle;
    private JButton bt_reset, bt_exit, bt_resetScore;
    private JPanel pn_xscore, pn_oscore;
    private JTextField xscore, oscore;
    private JLabel turn;

    public ScoreView(){
        setBounds(300, 0, 200, 300);
        setLayout(new GridLayout(7, 1));
        setBackground(new Color(142, 68, 173));
        initComps();
    }

    public void initComps(){
        // Thêm JPanel gameTitle
        gameTitle = new JLabel("TIC TAC TOE");
        gameTitle.setForeground(new Color(44, 62, 80));
        gameTitle.setFont(new Font("Algerian", Font.BOLD, 20));
        gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(gameTitle);
// Thêm panel biểu diễn điểm
        // Tạo panel biểu diễn điểm của bên X
        pn_xscore = new JPanel();
        pn_xscore.setLayout(new GridLayout(1, 2));

        // Thêm kí hiệu X
        JLabel X = new JLabel("X:");
        X.setForeground(Color.RED);
        X.setFont(new Font("Cambria", Font.BOLD, 30));
        pn_xscore.add(X);

        // Thêm textfield hiện thị điểm
        xscore = new JTextField();
        xscore.setEditable(false);
        xscore.setFont(new Font("Cambria", Font.BOLD, 30));
        xscore.setText("0");
        pn_xscore.add(xscore);

        add(pn_xscore);
// Thêm panel biểu diễn điểm
        // Tạo panel biểu diễn điểm của bên o
        pn_oscore = new JPanel();
        pn_oscore.setLayout(new GridLayout(1, 2));

        // Thêm kí hiệu o
        JLabel o = new JLabel("O:");
        o.setForeground(Color.BLUE);
        o.setFont(new Font("Cambria", Font.BOLD, 30));
        pn_oscore.add(o);

        // Thêm textfield hiện thị điểm
        oscore = new JTextField();
        oscore.setEditable(false);
        oscore.setFont(new Font("Cambria", Font.BOLD, 30));
        oscore.setText("0");
        pn_oscore.add(oscore);

        add(pn_oscore);

        // Thêm JLabel thông báo lượt chơi
        turn = new JLabel("X TURN");
        turn.setFont(new Font("Cambria", Font.BOLD, 20));
        turn.setForeground(Color.RED);
        turn.setBackground(Color.BLACK);
        turn.setHorizontalAlignment(SwingConstants.CENTER);
        add(turn);

        // Thêm nút RESET
        bt_reset = new JButton("RESET");
        add(bt_reset);

        // Thêm nút reset điểm
        bt_resetScore = new JButton("RESET SCORE");
        add(bt_resetScore);

        // Thêm nút EXIT
        bt_exit = new JButton("EXIT");
        add(bt_exit);


    }

    public JButton getBt_exit(){
        return bt_exit;
    }

    public JButton getBt_reset(){
        return bt_reset;
    }

    public JTextField getXScoreTextField(){
        return xscore;
    }

    public JTextField getOScoreTextField(){
        return oscore;
    }

    public JButton getBt_resetScore(){
        return bt_resetScore;
    }
}
