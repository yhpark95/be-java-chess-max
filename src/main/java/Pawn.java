package main.java;

import java.util.*;

class Pawn implements Piece {
    private String symbol;
    private Color color;
    private Position position;

    public Pawn(Color color, Position position) {
        this.color = color;
        this.symbol = (color == Color.BLACK) ? "♟" : "♙";
        this.position = position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public List<Position> getPossiblePositions(ChessBoard board) {
        List<Position> possiblePositions = new ArrayList<>();
        int x = position.getX();
        int y = position.getY();

        // Determine the direction based on the pawn's color
        int direction = (color == Color.BLACK) ? 1 : -1;

        // Check for possible move to the next row
        Position nextPosition = new Position(x + direction, y);
        if (utils.isValidPosition(nextPosition) && board.getPiece(nextPosition) == null) {
            possiblePositions.add(nextPosition);

            // Check for possible double move from the initial position
            if ((color == Color.BLACK && x == 1) || (color == Color.WHITE && x == 6)) {
                Position doubleMovePosition = new Position(x + 2 * direction, y);
                if (board.getPiece(doubleMovePosition) == null) {
                    possiblePositions.add(doubleMovePosition);
                }
            }
        }

        // Check for possible captures
        Position capturePosition1 = new Position(x + direction, y + 1);
        if (utils.isValidPosition(capturePosition1) && board.getPiece(capturePosition1) != null) {
            possiblePositions.add(capturePosition1);
        }

        Position capturePosition2 = new Position(x + direction, y - 1);
        if (utils.isValidPosition(capturePosition2) && board.getPiece(capturePosition2) != null) {
            possiblePositions.add(capturePosition2);
        }

        return possiblePositions;
    }
}
