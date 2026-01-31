package strategy.WinningStrategies;

import models.Game;
import models.Move;
import models.Symbol;

import java.util.HashMap;

public class ColumnWinningStrategy implements WinningStrategy{
    private HashMap<Integer, HashMap<Symbol, Integer>> colHashMap = new HashMap<>();
    @Override
    public boolean checkWinner(Game game) {
        int N = game.getBoard().getDimensions();

        // update the value in the hashmap for that particular column
        int column = game.getMoves().getLast().getCell().getColumn();
        Symbol symbol = game.getPlayers().getLast().getSymbol();
        if(!colHashMap.containsKey(column)) {
            colHashMap.put(column, new HashMap<>());
        }
        HashMap<Symbol, Integer> mpp = colHashMap.get(column);
        mpp.put(symbol, mpp.getOrDefault(symbol, 0)+1);
        colHashMap.put(column, mpp);

        // check the count
        if(mpp.get(symbol) == N) {
            return true;
        }
        return false;
    }

    @Override
    public void undoMove(Move move, int N) {
        // what i need -> symbol, column
        Symbol symbol = move.getPlayer().getSymbol();
        int column = move.getCell().getColumn();
        HashMap<Symbol, Integer> mpp = colHashMap.get(symbol);
        mpp.put(symbol, mpp.get(symbol)-1);
        colHashMap.put(column, mpp);
    }
}
