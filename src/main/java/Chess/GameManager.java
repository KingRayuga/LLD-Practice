package Chess;

import java.util.LinkedList;
import java.util.Queue;

public class GameManager {
    private Board board;
    private MoveManager moveManager;
    private Queue<Player> players;
    private boolean isGameOver;

    private GameManager() {
        this.board = new Board();
        this.moveManager = MoveManager.getInstance();
        this.players = new LinkedList<>();
        this.isGameOver = false;
    }

    private static class SingletonHelper {
        private static final GameManager INSTANCE = new GameManager();
    }

    public static GameManager getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void initializeGame(String player1Name, String player2Name, int totalTime) {
        Player player1 = new Player(player1Name, PieceColor.WHITE, totalTime);
        Player player2 = new Player(player2Name, PieceColor.BLACK, totalTime);
        players.offer(player1);
        players.offer(player2);
    }

    public boolean makeMove(Cell from, Cell to) {
        if (isGameOver) {
            System.out.println("Game is already over!");
            return false;
        }

        Player currentPlayer = players.peek();
        Piece piece = from.getPiece();

        if (piece == null || piece.getColor() != currentPlayer.getColor()) {
            System.out.println("Invalid move: Not your piece.");
            return false;
        }

        if (!validateMove(from, to)) {
            System.out.println("Invalid move for " + piece.getType());
            return false;
        }

        // Check if opponent's king is in check
        Player opponent = getOpponent();
        if (board.isKingInCheck(opponent.getColor())) {
            System.out.println(opponent.getName() + "'s king is in check!");
        }

        // Switch turns using queue
        switchTurn();
        return true;
    }

    private void switchTurn() {
        players.offer(players.poll());
    }

    private Player getOpponent() {
        Player[] playerArray = players.toArray(new Player[0]);
        return playerArray.length > 1 ? playerArray[1] : null;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void endGame() {
        this.isGameOver = true;
        System.out.println("Game Over! " + players.peek().getName() + " wins.");
    }

    public boolean validateMove(Cell from, Cell to){
        // various validation
        return false;
    }
}
