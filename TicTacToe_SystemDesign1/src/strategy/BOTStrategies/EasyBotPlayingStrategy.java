package strategy.BOTStrategies;

import enums.CellState;
import models.Board;
import models.Cell;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Cell chooseCellToPlay(Board board) {
        List<List<Cell>> grid = board.getBoard();
        for(List<Cell> cells : grid) {
            for(Cell cell : cells) {
                if(cell.getCellState().equals(CellState.EMPTY)) {
                    return cell;
                }
            }
        }

        return null;
    }
}
