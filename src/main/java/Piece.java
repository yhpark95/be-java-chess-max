package main.java;

import java.util.List;

public interface Piece {
    String getSymbol();

    Color getColor();

    List<Position> getPossiblePositions(ChessBoard board);

    void setPosition(Position toPosition);
}
