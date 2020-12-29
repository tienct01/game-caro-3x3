package com.tictactoe.model;


import java.util.Arrays;

public class TicTacToe {
    private int turn;
    private int[][] gameState;
    private int xscore;
    private int oscore;

    public TicTacToe(){
        this.turn = 1;
        gameState = new int[3][3];
        for(int i = 0; i<3; i++){
            Arrays.fill(gameState[i], 0);
        }
        xscore = 0;
        oscore = 0;
    }

    public void setGameState(int[][] gameState){
        this.gameState = gameState;
    }

    public int[][] getGameState() {
        return gameState;
    }

    public int getTurn(){
        return turn;
    }

    public void increasingTurn(){
        turn ++;
    }

    public void setTurn(int turn){
        this.turn = turn;
    }

    public void resetGameState(){
        for(int i = 0; i<3; i++){
            Arrays.fill(gameState[i], 0);
        }
    }

    public int isWin(){
        for(int j = 0; j<3; j++){
            if(gameState[0][j] != 0) {
                if (gameState[0][j] == gameState[1][j] && gameState[0][j] == gameState[2][j]) {
                    return gameState[0][j];
                }
            }
        }
        for(int i = 0; i<3; i++){
            if( gameState[i][0] != 0) {
                if (gameState[i][0] == gameState[i][1] && gameState[i][0] == gameState[i][2]) {
                    return gameState[i][0];
                }
            }
        }

        if(gameState[0][0] == gameState[1][1] && gameState[0][0] == gameState[2][2] && gameState[0][0] != 0){
            return gameState[0][0];
        }
        if(gameState[0][2] == gameState[1][1] && gameState[0][2] == gameState[2][0] && gameState[0][2] != 0){
            return gameState[0][2];
        }
        return 0;
    }
    public void increaseXScore(){
        xscore++;
    }
    public void increaseOScore(){
        oscore++;
    }
    public int getXScore(){
        return xscore;
    }

    public int getOscore() {
        return oscore;
    }

    public void resetScore(){
        xscore = 0;
        oscore = 0;
    }
}
