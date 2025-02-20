package Chess;

public class EnPassantMove implements SpecialMove {
    @Override
    public boolean validateMove(Piece pawn, Piece opponentPawn, Cell currCell, Cell futureCell) {
        return true;
    }
}