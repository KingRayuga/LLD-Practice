package Chess;

public class PawnMoveStrategy implements MoveStrategy {
    @Override
    public boolean validateMove(Cell currCell, Cell futureCell, Board board) {
        int direction = currCell.getPiece().getColor() == PieceColor.WHITE ? 1 : -1;
        int dx = futureCell.getX() - currCell.getX();
        int dy = futureCell.getY() - currCell.getY();
        return (dx == direction && dy == 0) || (dx == direction && Math.abs(dy) == 1 && futureCell.getPiece() != null);
    }
}
