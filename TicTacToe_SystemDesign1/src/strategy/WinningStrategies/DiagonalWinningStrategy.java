package strategy.WinningStrategies;

import models.Game;
import models.Move;
import models.Symbol;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy{
    private HashMap<Symbol, Integer> LR_DiagHashMap = new HashMap<>();
    private HashMap<Symbol, Integer> RL_DiagHashMap = new HashMap<>();
    public boolean checkWinner(Game game) {
        int N = game.getBoard().getDimensions();

        // update the diagonals -> (L-R) and (R-L)
        // what all we need -> row, column, symbol
        Symbol symbol = game.getPlayers().getLast().getSymbol();
        int row = game.getMoves().getLast().getCell().getRow();
        int column = game.getMoves().getLast().getCell().getColumn();

        if(row == column) {
            LR_DiagHashMap.put(symbol, LR_DiagHashMap.getOrDefault(symbol, 0)+1);
        }
        if(row + column == N-1) {
            RL_DiagHashMap.put(symbol, RL_DiagHashMap.getOrDefault(symbol, 0)+1);
        }

        // check the winner
        if(LR_DiagHashMap.get(symbol) == N || RL_DiagHashMap.get(symbol) == N) {
            return true;
        }
        return false;
    }

    @Override
    public void undoMove(Move lastMove, int N) {
        /*
            what we need -
            1. row
            2. column
            3. symbol
            4. check -> row == column - update the L-R hashmap
                     -> row + column == N-1 - update the R-L hashmap
         */

        Symbol symbol = lastMove.getPlayer().getSymbol();
        int row = lastMove.getCell().getRow();
        int column = lastMove.getCell().getColumn();
        if(row == column) {
            LR_DiagHashMap.put(symbol, LR_DiagHashMap.get(symbol)-1);
        }
        if(row + column == N-1) {
            RL_DiagHashMap.put(symbol, RL_DiagHashMap.get(symbol)-1);
        }
        return;
    }
}
