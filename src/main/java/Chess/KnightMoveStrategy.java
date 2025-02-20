package Chess;

public class KnightMoveStrategy implements MoveStrategy {
    @Override
    public boolean validateMove(Cell currCell, Cell futureCell, Board board) {
        int dx = Math.abs(currCell.getX() - futureCell.getX());
        int dy = Math.abs(currCell.getY() - futureCell.getY());
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}