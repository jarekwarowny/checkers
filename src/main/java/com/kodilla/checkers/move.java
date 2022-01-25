package com.kodilla.checkers;

class Move {

    int fromRow;
    int fromCol;
    int toRow;
    int toCol;

    Move(int r1, int c1, int r2, int c2) {
        fromRow = r1;
        fromCol = c1;
        toRow = r2;
        toCol = c2;
    }
    boolean isJump() {
        return (fromRow - toRow == 2 || fromRow - toRow == -2);
    }
}

