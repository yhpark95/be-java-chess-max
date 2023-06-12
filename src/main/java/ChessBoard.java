package main.java;

import java.util.*;

public class ChessBoard {
    private Piece[][] board;

    public ChessBoard() {
        board = new Piece[8][8];
        this.initialize();
    }

    private void initialize() {
        // Place the black pieces on the board
        board[0][0] = new Rook(Color.BLACK, new Position(0, 0));
        board[0][1] = new Knight(Color.BLACK, new Position(0, 1));
        board[0][2] = new Bishop(Color.BLACK, new Position(0, 2));
        board[0][3] = new Queen(Color.BLACK, new Position(0, 3));
        board[0][4] = new King(Color.BLACK, new Position(0, 4));
        board[0][5] = new Bishop(Color.BLACK, new Position(0, 5));
        board[0][6] = new Knight(Color.BLACK, new Position(0, 6));
        board[0][7] = new Rook(Color.BLACK, new Position(0, 7));

        for (int col = 0; col < 8; col++) {
            board[1][col] = new Pawn(Color.BLACK, new Position(1, col));
        }

        // Place the white pieces on the board
        board[7][0] = new Rook(Color.WHITE, new Position(7, 0));
        board[7][1] = new Knight(Color.WHITE, new Position(7, 1));
        board[7][2] = new Bishop(Color.WHITE, new Position(7, 2));
        board[7][3] = new Queen(Color.WHITE, new Position(7, 3));
        board[7][4] = new King(Color.WHITE, new Position(7, 4));
        board[7][5] = new Bishop(Color.WHITE, new Position(7, 5));
        board[7][6] = new Knight(Color.WHITE, new Position(7, 6));
        board[7][7] = new Rook(Color.WHITE, new Position(7, 7));

        for (int col = 0; col < 8; col++) {
            board[6][col] = new Pawn(Color.WHITE, new Position(6, col));
        }
    }


    public void printBoard() {
        StringBuilder sb = new StringBuilder();

        sb.append(" ㅡ");
        for (char c = 'A'; c <= 'H'; c++) {
            sb.append(c).append("ㅡ");
        }
        sb.append("\n");

        for (int row = 0; row < 8; row++) {
            sb.append(row + 1).append(" ");
            for (int col = 0; col < 8; col++) {
                if (board[row][col] == null) {
                    sb.append("ㅡ ");
                } else {
                    sb.append(board[row][col].getSymbol()).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    public Piece getPiece(Position selectedPosition) {
        return board[selectedPosition.getX()][selectedPosition.getY()];
    }

    public boolean movePiece(Position fromPosition, Position toPosition) {

        Piece piece = getPiece(fromPosition);

        // Move the piece
        setPiece(fromPosition, null);
        setPiece(toPosition, piece);
        piece.setPosition(toPosition);

        return true;

    }

    private void setPiece(Position position, Piece piece) {
        int row = position.getX();
        int col = position.getY();
        board[row][col] = piece;
    }



}
