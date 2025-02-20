package Chess;

public interface MoveStrategy {
    boolean validateMove(Cell currCell, Cell futureCell, Board board);
}
