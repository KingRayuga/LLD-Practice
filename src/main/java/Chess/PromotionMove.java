package Chess;

class PromotionMove implements SpecialMove {
    @Override
    public boolean validateMove(Piece pawn, Piece ignored, Cell currCell, Cell futureCell) {
        return futureCell.getX() == 0 || futureCell.getX() == 7;
    }
}