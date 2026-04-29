package model;

import enums.CellState;
import enums.GameState;
import enums.PlayerType;
import exceptions.BotCountInvalidException;
import exceptions.PlayerCountInvalidException;
import exceptions.UniqueSymbolInvalidException;
import strategy.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    Board board;
    List<Player> players;
    List<Move> moves;
    GameState gameState;
    Player winner;
    int nextPlayerIndex;
    List<WinningStrategy> winningStrategies;

    public Game(int dimensions, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimensions);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;
        this.nextPlayerIndex = 0;
        this.winningStrategies = winningStrategies;
    }

    // Make move
    public boolean validate(int row, int col, Board board) {
        int N = board.getDimensions();
        if(col < 0 || col >= N || row < 0 || row >= N) {
            return false;
        }

        if(board.getBoard().get(row).get(col).getCellState().equals(CellState.FILLED)) {
            return false;
        }

        return true;
    }

    public void makeMove(Game game) {
        Board board = game.getBoard();
        Player player = game.getPlayers().get(nextPlayerIndex);

        Cell dummyCell = player.chooseCellToPlay(player);
        int row = dummyCell.getRow();
        int col = dummyCell.getCol();


        // valid move
        if(!validate(row, col, board)) {
            System.out.println("Please choose a valid cell");
            return;
        }

        Move move = new Move(player, dummyCell);
        moves.add(move);

        if(checkWinner(game)) {
            game.setGameState(GameState.ENDED);
            game.setWinner(player);
            return;
        } else if(moves.size() == board.getDimensions() * board.getDimensions()) {
            game.setGameState(GameState.DRAW);
        }
    }

    private boolean checkWinner(Game game) {
        for(WinningStrategy winningStrategy : game.getWinningStrategies()) {
            if(winningStrategy.checkWinner(game)) {
                return true;
            }
        }
        return false;
    }

    public void undoMove(Game game) {
        if(moves.size() == 0) {
            System.out.println("Game just started, no move to undo");
            return;
        }

        Move lastMove = moves.getLast();
        moves.remove(lastMove);

        lastMove.getCell().setCellState(CellState.EMPTY);
        lastMove.setPlayer(null);

        nextPlayerIndex = (nextPlayerIndex - 1 + game.getPlayers().size()) % game.getPlayers().size();

        for(WinningStrategy winningStrategy : game.getWinningStrategies()) {
            winningStrategy.undoMove(game);
        }
    }

    // Print board
    public void printBoard() {
        board.printBoard();
    }

    // Builder DP
    public static GameBuilder getBuilder() {
        return new GameBuilder();
    }

    public static class GameBuilder {
        int dimensions;
        List<Player> players;
        List<WinningStrategy> winningStrategies;

        public int getDimensions() {
            return dimensions;
        }

        public GameBuilder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public void validateNoOfPlayers() throws PlayerCountInvalidException {
            if(players.size() > dimensions-1) {
                throw new PlayerCountInvalidException("No of players are more than N-1, which is invalid");
            }
        }

        public void validateNoOfBots() throws BotCountInvalidException {
            int countBots = 0;
            for(Player player : players) {
                if(player.getPlayerType().equals(PlayerType.BOT)) {
                    countBots += 1;
                }
            }
            if(countBots > dimensions-2) {
                throw new BotCountInvalidException("No of bots choosen are greater than N-2, which is invalid.");
            }
        }

        public void validatePlayerSymbols() throws UniqueSymbolInvalidException {
            Map<String, Integer> symbolMap = new HashMap<>();
            for(Player player : players) {
                if(symbolMap.containsKey(player.getSymbol())) {
                    throw new UniqueSymbolInvalidException("There is a repeated symbol choosen among the players.");
                }
                symbolMap.put(player.getSymbol(), symbolMap.getOrDefault(player.getSymbol(), 0) + 1);
            }
        }

        public void validate() throws PlayerCountInvalidException, BotCountInvalidException, UniqueSymbolInvalidException {
            validateNoOfPlayers();
            validateNoOfBots();
            validatePlayerSymbols();
        }

        public Game build() throws BotCountInvalidException, PlayerCountInvalidException, UniqueSymbolInvalidException {
            validate();
            return new Game(dimensions, players, winningStrategies);
        }
    }


    // Getters and Setters

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }
}
