package models;

import enums.CellState;
import enums.GameState;
import exceptions.BotCountInvalidException;
import exceptions.PlayerCountInvalidException;
import exceptions.UniqueSymbolInvalidException;
import strategy.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private int nextPlayerMoveIdx;
    private List<WinningStrategy> winningStrategies;

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

    public int getNextPlayerMoveIdx() {
        return nextPlayerMoveIdx;
    }

    public void setNextPlayerMoveIdx(int nextPlayerMoveIdx) {
        this.nextPlayerMoveIdx = nextPlayerMoveIdx;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public void printBoard() {
        board.printBoard();
    }

    public boolean validate(int row, int column, Board board) {
        int N = board.getDimensions();
        if(row < 0 || row >= N || column < 0 || column >= N) {
            return false;
        }

        if(board.getBoard().get(row).get(column).getCellState().equals("FILLED")) {
            return false;
        }

        return true;
    }

    public boolean checkWinner(Game game) {
        for(WinningStrategy winningStrategy : game.winningStrategies) {
            if(winningStrategy.checkWinner(game)) {
                return true;
            }
        }
        return false;
    }

    public void makeMove(Game game) {
        // extract all the info from the game object.
        int idxOfPlayer = game.getNextPlayerMoveIdx();
        Board board = game.getBoard();
        List<Player> players = game.players;
        List<Move> moves = game.getMoves();

        // which player is playing
        Player player = players.get(idxOfPlayer);
        System.out.println("It's " + player.getName() + "'s turn.");

        // let the player choose a cell
        Cell dummyCell = player.chooseCellToPlay(player);
        int row = dummyCell.getRow();
        int column = dummyCell.getColumn();

        // validate the cell choosen by the player
        if(!validate(row, column, board)) {
            System.out.println("Please choose a valid cell");
            return;
        }

        // store the move into the list of moves of the game
        Move move = new Move(player, dummyCell);
        moves.add(move);

        // check whether the current player is winner or not
        if(checkWinner(game)) {
            game.setGameState(GameState.ENDED);
            game.winner = player;
            return;
        } else if(moves.size() == (board.getDimensions() * board.getDimensions())) {
            game.setGameState(GameState.DRAW);
        }
    }

    public void undoMove() {
        // Validation check - whether any moves have been done or not on the board
        if(moves.size() == 0) {
            System.out.println("Game just started, no move to undo");
            return;
        }

        // remove the move from the list
        Move lastMove = moves.getLast();
        moves.remove(lastMove);

        // update the cell state and player state
        lastMove.getCell().setCellState(CellState.EMPTY);
        lastMove.getCell().setPlayer(null);

        // pointer comes again to the current player
        nextPlayerMoveIdx = (nextPlayerMoveIdx - 1 + players.size()) % players.size();

        // update the hashmaps
        for(WinningStrategy winningStrategy : winningStrategies) {
            winningStrategy.undoMove(lastMove, board.getDimensions());
        }
        return;
    }

    public Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;
        this.nextPlayerMoveIdx = 0;
        this.winningStrategies = winningStrategies;
    }

    public static GameBuilder getBuilder() {
        return new GameBuilder();
    }

    public static class GameBuilder {
        private int dimensions;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
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
            int noOfPlayers = players.size();
            int N = this.dimensions;
            if(noOfPlayers > N-1) {
                throw new PlayerCountInvalidException("No of players are more than N-1, which is invalid");
            }
            return;
        }

        public void validateNoOfBots() throws BotCountInvalidException {
            int botCount = 0;
            int N = this.dimensions;
            for(Player player : players) {
                if(player.getPlayerType().equals("BOT")) {
                    botCount++;
                }
            }

            if(botCount > N-2) {
                throw new BotCountInvalidException("No of bots choosen are greater than N-2, which is invalid.");
            }
            return;
        }

        public void validateUniqueSymbols() throws UniqueSymbolInvalidException {
            HashSet<String> symbols = new HashSet<>();
            for(Player player : players) {
                if(symbols.contains(player.getSymbol())) {
                    throw new UniqueSymbolInvalidException("There is a repeated symbol choosen among the players.");
                }
            }
        }

        public void validate() throws PlayerCountInvalidException, BotCountInvalidException, UniqueSymbolInvalidException {
            validateNoOfPlayers();
            validateNoOfBots();
            validateUniqueSymbols();
        }

        public Game build() throws PlayerCountInvalidException, BotCountInvalidException, UniqueSymbolInvalidException {
            validate();
            return new Game(dimensions, players, winningStrategies);
        }
    }
}
