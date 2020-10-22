package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

import java.util.Arrays;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score = 0;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {

        for (int i = 0; i < SIDE; i++ ) {
            for (int j = 0; j < SIDE; j++) {
                gameField[i][j] = 0;
            }
        }
        createNewNumber();
        createNewNumber();
    }

    private void createNewNumber() {

        if (getMaxTileValue() == 2048) {
            win();
        }

        while (true) {
            int x = getRandomNumber(SIDE);
            int y = getRandomNumber(SIDE);

            if (gameField[y][x] == 0) {

                int cause = getRandomNumber(10);
                int num;
                if (cause == 9) {
                    num = 4;
                } else num = 2;
                if (gameField[y][x] == 0) {
                    gameField[y][x] = num;
                }
                break;
                }
        }

    }

    private void drawScene() {

        for (int i = 0; i < SIDE; i++ ) {
            for (int j = 0; j < SIDE; j++) {

                setCellColoredNumber(j, i, gameField[i][j]);
                //System.out.print(gameField[i][j] + " ");
            }
            //System.out.println();
        }
    }

    private void setCellColoredNumber(int y, int x, int value) {
        if (value == 0) {
        setCellValueEx(y, x, getColorByValue(value), "");
        }
        else  setCellValueEx(y, x, getColorByValue(value), value+"");

    }

    private Color getColorByValue(int value) {
        if (value == 2) {
            return Color.BLUE;
        } else if (value == 4) {
            return Color.RED;
        } else if (value == 8) {
            return Color.YELLOW;
        } else if (value == 16) {
            return Color.GREEN;
        } else if (value == 32) {
            return Color.ORANGE;
        } else if (value == 64) {
            return Color.LIGHTBLUE;
        } else if (value == 128) {
            return Color.VIOLET;
        } else if (value == 256) {
            return Color.AQUAMARINE;
        } else if (value == 512) {
            return Color.DARKCYAN;
        } else if (value == 1024) {
            return Color.FORESTGREEN;
        } else if (value == 2048) {
            return Color.INDIGO;
        } else return Color.LIGHTGRAY;
    }

    private boolean compressRow(int[] row) {
        boolean isMoved = false;
        for (int i=1; i < row.length; i++) {
            if ((row[i] != 0) && (row[i-1] == 0)) {
                    row[i-1] = row[i];
                    row[i] = 0;
                    isMoved = true;
                    compressRow(row);
                }
            }

        return isMoved;
    }

    private boolean mergeRow(int[] row) {
        boolean isMerged = false;
        for (int i=1; i < row.length; i++) {
            if (row[i] != 0&&row[i]==row[i-1]) {
                row[i-1] = row[i]*2;
                row[i] = 0;
                isMerged = true;
                score++;
                setScore(score);
           }
        }
        return isMerged;
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped) {
            if (key == Key.SPACE) {
                isGameStopped = false;
                score = 0;
                createGame();
                drawScene();
            }
        } else {
            if (!canUserMove()) {
                gameOver();
            } else if (key == Key.DOWN) {
                canUserMove();
                moveDown();
                drawScene();
                // выполнить движение вниз
            } else if (key == Key.LEFT) {
                canUserMove();
                moveLeft();
                drawScene();
                //Выполнить движение влево
            } else if (key == Key.RIGHT) {
                canUserMove();
                moveRight();
                drawScene();
                //Выполнить движение направо
            } else if (key == Key.UP) {
                canUserMove();
                moveUp();
                drawScene();
                //Выполнить движение вверх
            }
        }
    }

    private void moveLeft() {
        int o = 0;
        for (int i = 0; i < gameField.length; i++) {

            if (mergeRow(gameField[i]) || compressRow(gameField[i])) {
                if (o == 0) {
                    createNewNumber();
                    o++;
                }
            }
            compressRow(gameField[i]);

        }

    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }
    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }
    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise() {
        int[][] tempArray = new int[SIDE][SIDE];
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                tempArray[j][i] = gameField [SIDE - 1 - i][j];
            }
        }
        gameField = tempArray;

    }
    private int getMaxTileValue() {
        int max = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[j][i] > max) {
                    max = gameField[j][i];
                }
            }
        }
        return max;
    }

    private void win() {
        showMessageDialog(Color.GRAY, "You won the game 2048!", Color.BLACK, 50);
        isGameStopped = true;
    }

    private boolean canUserMove() {
        int zero = 0;
        boolean haveZero = haveZero();

        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {

                if (haveZero == false) {


                if ((j > 0) && (gameField[j - 1][i] == gameField[j][i])) {
                    //System.out.println("have neighborhood");
                    return true;
                    }
                if ((j < SIDE - 1) && (gameField[j + 1][i] == gameField[j][i])) {
                    //System.out.println("have neighborhood");
                    return true;
                    }
                if ((i > 0) && (gameField[j][i - 1] == gameField[j][i])) {
                    //System.out.println("have neighborhood");
                    return true;
                }
                if ((i < SIDE - 1) && (gameField[j][i + 1] == gameField[j][i])) {
                    //System.out.println("have neighborhood");
                    return true;
                    }
                    if ((j > 0) && (gameField[j - 1][i] != gameField[j][i])) {
                        //System.out.println("have no neighborhood");

                    }
                    if ((j < SIDE - 1) && (gameField[j + 1][i] != gameField[j][i])) {
                        //System.out.println("have no neighborhood");

                    }
                    if ((i > 0) && (gameField[j][i - 1] != gameField[j][i])) {
                        //System.out.println("have no neighborhood");

                    }
                    if ((i < SIDE - 1) && (gameField[j][i + 1] != gameField[j][i])) {
                        //System.out.println("have no neighborhood");

                    }
                }

            }
        }


        return haveZero;
    }

    private boolean haveZero() {

        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[j][i] == 0) {
                    return true;
                }
            }
        }
    return false;
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.GRAY, "You lost the game 2048!", Color.WHITESMOKE, 50);
    }


}
