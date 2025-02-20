package Chess;

public class Pawn extends Piece {
    public Pawn(PieceColor color) {
        super(PieceType.PAWN, color, new PawnMoveStrategy());
    }
}