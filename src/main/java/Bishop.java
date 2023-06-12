package main.java;
import java.util.*;
class Bishop implements Piece {
    private String symbol;
    private Color color;
    private Position position;

    public Bishop(Color color, Position position) {
        this.color = color;
        this.position = position;
        this.symbol = (color == Color.BLACK) ? "♝" : "♗";

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

        // Check for possible moves in the diagonal directions
        int[] rowOffsets = {1, 1, -1, -1};
        int[] colOffsets = {1, -1, 1, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = x + rowOffsets[i];
            int newCol = y + colOffsets[i];

            while (utils.isValidPosition(new Position(newRow, newCol))) {
                Position newPosition = new Position(newRow, newCol);
                Piece piece = board.getPiece(newPosition);

                if (piece == null) {
                    possiblePositions.add(newPosition);
                } else {
                    if (piece.getColor() != color) {
                        possiblePositions.add(newPosition);
                    }
                    break;
                }

                newRow += rowOffsets[i];
                newCol += colOffsets[i];
            }
        }

        return possiblePositions;
    }
}
