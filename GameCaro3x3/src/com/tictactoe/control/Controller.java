package com.tictactoe.control;

import com.tictactoe.model.TicTacToe;
import com.tictactoe.view.GUI;
import com.tictactoe.view.GameBoard;
import com.tictactoe.view.ScoreView;
import com.tictactoe.view.WinView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    public static final int XWIN = 1;
    public static final int OWIN = 2;
    private GameBoard gameBoard;
    private ScoreView scoreView;
    private TicTacToe ticTacToe;
    private WinView winView;

    public Controller(GUI gui, TicTacToe t, WinView w){
        gameBoard = gui.getGameBoard();
        scoreView = gui.getScoreView();
        ticTacToe = t;
        winView = w;

        addEventForGameBoard();
        addEventsForScoreView();
    }

    public void addEventForGameBoard(){
        JButton[][] bt_gameBoard = gameBoard.getBt_GameBoards();
        int[][] gameState = ticTacToe.getGameState();

        // Tạo action listener hiện kí hiệu X hoặc O tùy theo turn trên Button của gameboard
        ActionListener btGameBoardActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tham chiếu nút được bấm
                JButton temp =(JButton) e.getSource();
                // Set dấu X cho button theo getTurn(), x có turn là số lẻ và thêm vào TRẠNG THÁI BẰN CỜ DẠNG SỐ
                if(ticTacToe.getTurn() % 2 == 1 && temp.getText().equals("")){
                    temp.setText("x");
                    temp.setForeground(Color.RED);
                    for(int i = 0; i< bt_gameBoard.length; i++){
                        for(int j = 0; j<bt_gameBoard[i].length; j++){
                            if(e.getSource() == bt_gameBoard[i][j] && gameState[i][j] == 0){
                                gameState[i][j] = 1;
                                break;
                            }
                        }
                    }
                    // TĂNG TURN LÊN
                    ticTacToe.increasingTurn();
                    // KIỂM TRA GAME ĐÃ WIN CHƯA, THÔNG QUA BẢNG TRẠNG THÁI GAME DẠNG SỐ
                    if(ticTacToe.isWin() == Controller.XWIN){
                        winGame("X WIN");
                        setXPlayerScore();
                    }
                }
                // ĐÂY LÀ TƯƠNG TỰ NHƯ TRÊN, NHƯNG LÀ DÀNH CHO O , O có turn là số chẵn
                else if(ticTacToe.getTurn() % 2 == 0 && temp.getText().equals("")){
                    temp.setText("o");
                    temp.setForeground(Color.BLUE);
                    for(int i = 0; i< bt_gameBoard.length; i++){
                        for(int j = 0; j<bt_gameBoard[i].length; j++){
                            if(e.getSource() == bt_gameBoard[i][j] && gameState[i][j] == 0){
                                gameState[i][j] = 2;
                                break;
                            }
                        }
                    }
                    ticTacToe.increasingTurn();
                    if(ticTacToe.isWin() == Controller.OWIN){
                        winGame("O WIN");
                        setOPlayerScore();
                    }
                }
            }
        };
        // Thêm action listener vào các Button của game
        for(int i = 0; i<bt_gameBoard.length; i++){
            for(int j = 0; j<bt_gameBoard[i].length; j++){
                bt_gameBoard[i][j].addActionListener(btGameBoardActionListener);
            }
        }
    }

    public void addEventsForScoreView(){
        JButton tmp = scoreView.getBt_exit();
        ActionListener bt_exitActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(), "Bạn có muốn thoát không ?");
                if(choice == 0){
                    System.exit(0);
                }
            }
        };
        tmp.addActionListener(bt_exitActionListener);

        ActionListener bt_resetActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        };

        scoreView.getBt_reset().addActionListener(bt_resetActionListener);

        ActionListener bt_resetScoreActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ticTacToe.resetScore();
                scoreView.getOScoreTextField().setText(""+ticTacToe.getOscore());
                scoreView.getXScoreTextField().setText(""+ticTacToe.getXScore());
            }
        };
        JButton bt_resetScore = scoreView.getBt_resetScore();
        bt_resetScore.addActionListener(bt_resetScoreActionListener);
    }

    public void winGame(String winPlayerName){
        // Xử lí hành động khi có người thắng game
        JLabel lb_winPlayer = winView.getLb_winPlayer();
        lb_winPlayer.setText(winPlayerName);

        winView.setVisible(true);
        resetGame();
    }

    public void resetGame(){
        JButton[][] bt_gameBoard = gameBoard.getBt_GameBoards();
        for(int i = 0; i<bt_gameBoard.length; i++){
            for(int j = 0; j<bt_gameBoard[i].length; j++){
                bt_gameBoard[i][j].setText("");
            }
        }

        ticTacToe.resetGameState();
    }

    public void setXPlayerScore(){
        ticTacToe.increaseXScore();
        scoreView.getXScoreTextField().setText(""+ticTacToe.getXScore());
    }

    public void setOPlayerScore(){
        ticTacToe.increaseOScore();
        scoreView.getOScoreTextField().setText(""+ticTacToe.getOscore());
    }
}
