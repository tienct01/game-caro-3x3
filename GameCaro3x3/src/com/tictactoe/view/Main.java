package com.tictactoe.view;

import com.tictactoe.control.Controller;
import com.tictactoe.model.TicTacToe;

public class Main {
    public static void main(String[] args){
        GUI gui = new GUI();
        WinView winView = new WinView(gui);
        TicTacToe ticTacToe = new TicTacToe();
        Controller controller = new Controller(gui, ticTacToe, winView);
        gui.setVisible(true);
    }
}
