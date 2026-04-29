package strategy.WinningStrategy;

import model.Game;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {
    Map<Integer, Map<String, Integer>> rowMap = new HashMap<>();
    @Override
    public boolean checkWinner(Game game) {
        int row = game.getMoves().getLast().getCell().getRow();
        String symbol = game.getMoves().getLast().getPlayer().getSymbol();
        Map<String, Integer> symbolMap = rowMap.getOrDefault(row, null);
        int count = symbolMap.getOrDefault(symbol, 0) + 1;
        symbolMap.putIfAbsent(symbol, count);
        rowMap.put(row, symbolMap);
        if(count == game.getBoard().getDimensions()) {
            return true;
        }
        return false;
    }

    @Override
    public void undoMove(Game game) {
        int row = game.getMoves().getLast().getCell().getRow();
        String symbol = game.getMoves().getLast().getPlayer().getSymbol();
        Map<String, Integer> symbolMap = rowMap.getOrDefault(row, null);
        int count = symbolMap.getOrDefault(symbol, 0) - 1;
        symbolMap.putIfAbsent(symbol, count);
        rowMap.put(row, symbolMap);
    }
}
