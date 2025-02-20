package Chess;

public interface SpecialMove {
    boolean validateMove(Piece piece1, Piece piece2, Cell currCell, Cell futureCell);
}
