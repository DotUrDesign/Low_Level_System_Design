package strategy.WinningStrategies;

import models.Game;
import models.Move;
import models.Player;
import models.Symbol;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy{
    private HashMap<Integer, HashMap<Symbol, Integer>> rowHashMap = new HashMap<>();
    @Override
    public boolean checkWinner(Game game) {
        int N = game.getBoard().getDimensions();

        // put the symbol for the current player
        Symbol symbol = game.getPlayers().getLast().getSymbol();
        int row = game.getMoves().getLast().getCell().getRow();
        if(!rowHashMap.containsKey(row)) {
            rowHashMap.put(row, new HashMap<>());
        }
        HashMap<Symbol, Integer> mpp = rowHashMap.get(row);
        mpp.put(symbol, mpp.getOrDefault(symbol, 0) + 1);
        rowHashMap.put(row, mpp);

        // now check the count
        if(mpp.get(symbol) == N) {
            return true;
        }
        return false;
    }

    @Override
    public void undoMove(Move lastMove, int N) {
        // what i need -> row, symbol
        Symbol symbol = lastMove.getPlayer().getSymbol();
        int row = lastMove.getCell().getRow();
        HashMap<Symbol, Integer> mpp = rowHashMap.get(row);
        mpp.put(symbol, mpp.get(symbol)-1);
        rowHashMap.put(row, mpp);
    }
}
