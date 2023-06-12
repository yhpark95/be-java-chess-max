package main.java;
import java.util.*;
class Queen implements Piece {
    private String symbol;
    private Color color;
    private Position position;

    public Queen(Color color, Position position) {
        this.color = color;
        this.position = position;
        this.symbol = (color == Color.BLACK) ? "♛" : "♕";
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

        // Check for possible moves in the vertical, horizontal, and diagonal directions
        Rook rook = new Rook(color, position);
        possiblePositions.addAll(rook.getPossiblePositions(board));

        Bishop bishop = new Bishop(color, position);
        possiblePositions.addAll(bishop.getPossiblePositions(board));

        return possiblePositions;
    }
}
