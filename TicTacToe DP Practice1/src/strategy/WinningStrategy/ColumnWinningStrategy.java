package strategy.WinningStrategy;

import model.Game;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{
    Map<Integer, Map<String, Integer>> colMap = new HashMap<>();
    @Override
    public boolean checkWinner(Game game) {
        int col = game.getMoves().getLast().getCell().getCol();
        String symbol = game.getMoves().getLast().getPlayer().getSymbol();
        Map<String, Integer> symbolMap = colMap.getOrDefault(col, null);
        int count = symbolMap.getOrDefault(symbol, 0) + 1;
        symbolMap.putIfAbsent(symbol, count);
        colMap.put(col, symbolMap);
        if(count == game.getBoard().getDimensions()) {
            return true;
        }
        return false;
    }

    @Override
    public void undoMove(Game game) {
        int col = game.getMoves().getLast().getCell().getCol();
        String symbol = game.getMoves().getLast().getPlayer().getSymbol();
        Map<String, Integer> symbolMap = colMap.getOrDefault(col, null);
        int count = symbolMap.getOrDefault(symbol, 0) - 1;
        symbolMap.putIfAbsent(symbol, count);
    }
}
