package com.tictactoe.view;

import javax.swing.*;

public class GUI extends JFrame {
    private GameBoard gameBoard;
    private ScoreView scoreView;

    public GUI(){
        setTitle("Tic Tac Toe Game");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(515, 335);
        initComps();
    }

    public void initComps(){
        gameBoard = new GameBoard();
        add(gameBoard);
        scoreView = new ScoreView();
        add(scoreView);
    }

    public GameBoard getGameBoard(){
        return gameBoard;
    }

    public ScoreView getScoreView(){
        return scoreView;
    }
}
