package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class utils {

    public static boolean isValidPosition(Position position) {
        int row = position.getX();
        int col = position.getY();

        // 보드 범위에 있는 확인
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    public static String takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static Position parsePosition(String input) {
        char columnChar = Character.toUpperCase(input.charAt(0));
        int row = Character.getNumericValue(input.charAt(1)) - 1;

        if (columnChar < 'A' || columnChar > 'H' || row < 0 || row > 7) {
            System.out.println("체스보드 범위를 벗어났습니다 다시 선택해주세요");
            return null;
        }

        int column = columnChar - 'A';
        return new Position(row, column);
    }

    public static List<String> convertToString(List<Position> positions) {
        List<String> positionStrings = new ArrayList<>();
        for (Position position : positions) {
            int row = position.getX();
            int col = position.getY();

            // Convert the row and column indices to string representation
            String rowString = Integer.toString(row + 1);
            String colString = String.valueOf((char) ('A' + col));

            String positionString = colString + rowString;
            positionStrings.add(positionString);
        }
        return positionStrings;
    }

}
