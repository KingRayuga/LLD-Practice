package Chess;

public class RookMoveStrategy implements MoveStrategy {
    @Override
    public boolean validateMove(Cell currCell, Cell futureCell, Board board) {
        return currCell.getX() == futureCell.getX() || currCell.getY() == futureCell.getY();
    }
}