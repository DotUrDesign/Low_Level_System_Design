package strategy.WinningStrategy;

import model.Game;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{
    Map<Integer, Map<String, Integer>> diagonalMap = new HashMap<>();
    @Override
    public boolean checkWinner(Game game) {
        int row = game.getMoves().getLast().getCell().getRow();
        int col = game.getMoves().getLast().getCell().getCol();
        if(row == col) {
            String symbol = game.getMoves().getLast().getPlayer().getSymbol();
            Map<String, Integer> symbolMap = diagonalMap.getOrDefault(col, null);
            int count = symbolMap.getOrDefault(symbol, 0) + 1;
            symbolMap.putIfAbsent(symbol, count);
            if(count == game.getBoard().getDimensions()) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public void undoMove(Game game) {
        int row = game.getMoves().getLast().getCell().getRow();
        int col = game.getMoves().getLast().getCell().getCol();
        if(row == col) {
            String symbol = game.getMoves().getLast().getPlayer().getSymbol();
            Map<String, Integer> symbolMap = diagonalMap.getOrDefault(col, null);
            int count = symbolMap.getOrDefault(symbol, 0) - 1;
            symbolMap.putIfAbsent(symbol, count);
        }
    }
}
