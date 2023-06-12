package main.java;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        playGame();
    }

    private static void playGame() throws IOException {
        ChessBoard chessBoard = new ChessBoard();

        Color currentTurn = Color.BLACK;

        while (true) {
            System.out.println("현재 보드 현황");
            chessBoard.printBoard();

            System.out.println(currentTurn.name() + ": 움직일 말을 선택해주세요");
            String input = utils.takeInput();

            Position selectedPosition = utils.parsePosition(input);
            if(selectedPosition == null) continue;

            Piece selectedPiece = chessBoard.getPiece(selectedPosition);
            if (selectedPiece.getColor() != currentTurn) {
                System.out.println(currentTurn.name() + " 말을 선택하십시오");
                continue;
            }

            List<String> possiblePositions =  utils.convertToString(selectedPiece.getPossiblePositions(chessBoard));
            System.out.println(selectedPiece.getSymbol() + "이 움직일 수 있는 위치: " + possiblePositions);
            // Print the list of possible moves for the selected piece

            System.out.println(currentTurn.name() + ": 움직일 위치를 선택하거나 취소를 입력하십시오.");
            String moveInput = utils.takeInput();
            if (moveInput.equalsIgnoreCase("취소")) {
                System.out.println(currentTurn.name() + ": 선택이 취소되었습니다.");
                continue;
            }

            Position movePosition = utils.parsePosition(moveInput);

            chessBoard.movePiece(selectedPosition, movePosition);

            //턴 변경하기
            currentTurn = (currentTurn == Color.BLACK) ? Color.WHITE : Color.BLACK;
        }
    }
}
