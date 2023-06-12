package main.java;
import java.util.*;
class Knight implements Piece {
    private String symbol;
    private Color color;
    private Position position;

    public Knight(Color color, Position position) {
        this.color = color;
        this.position = position;
        this.symbol = (color == Color.BLACK) ? "♞" : "♘";
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

        // Define the knight's possible move offsets
        int[] rowOffsets = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] colOffsets = {-1, 1, -2, 2, -2, 2, -1, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = x + rowOffsets[i];
            int newCol = y + colOffsets[i];
            Position newPosition = new Position(newRow, newCol);
            if (utils.isValidPosition(newPosition) && (board.getPiece(newPosition) == null || board.getPiece(newPosition).getColor() != color)) {
                possiblePositions.add(newPosition);
            }
        }

        return possiblePositions;
    }
}
