package models;

import java.util.List;

public class Board {
    private int dimensions;
    private List<List<Cell>> board;
    public Board(int dimensions) {
        this.dimensions = dimensions;
    }

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void printBoard() {
        for(List<Cell> cells : board) {
            for(Cell cell : cells) {
                if(cell.getCellState().equals("EMPTY")) {
                    System.out.print("|   |");
                } else {
                    System.out.println("| " + cell.getPlayer().getSymbol().getSymbolChar() + " |");
                }
            }
            System.out.println();
        }
    }

}
