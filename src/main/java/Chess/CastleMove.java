package Chess;

class CastleMove implements SpecialMove {
    @Override
    public boolean validateMove(Piece king, Piece rook, Cell currCell, Cell futureCell) {
        return true;
    }
}