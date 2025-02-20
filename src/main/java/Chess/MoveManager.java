package Chess;

import java.util.Stack;

public class MoveManager {
    private Stack<Move> moveHistory;
    private Stack<Move> redoStack;

    private MoveManager() {
        this.moveHistory = new Stack<>();
        this.redoStack = new Stack<>();
    }

    // Bill Pugh Singleton Implementation
    private static class MoveManagerHolder {
        private static final MoveManager INSTANCE = new MoveManager();
    }

    public static MoveManager getInstance() {
        return MoveManagerHolder.INSTANCE;
    }

    public void recordMove(Move move) {
        moveHistory.push(move);
        redoStack.clear(); // Once a new move is made, redo history is invalid
    }

    public Move undo() {
        if (!moveHistory.isEmpty()) {
            Move lastMove = moveHistory.pop();
            redoStack.push(lastMove);
            return lastMove;
        }
        return null;
    }

    public Move redo() {
        if (!redoStack.isEmpty()) {
            Move move = redoStack.pop();
            moveHistory.push(move);
            return move;
        }
        return null;
    }
}
