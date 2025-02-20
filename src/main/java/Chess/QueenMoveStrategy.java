package Chess;

public class QueenMoveStrategy implements MoveStrategy {
    @Override
    public boolean validateMove(Cell currCell, Cell futureCell, Board board) {
        int dx = Math.abs(currCell.getX() - futureCell.getX());
        int dy = Math.abs(currCell.getY() - futureCell.getY());
        return dx == dy || currCell.getX() == futureCell.getX() || currCell.getY() == futureCell.getY();
    }
}