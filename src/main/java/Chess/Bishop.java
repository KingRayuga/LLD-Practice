package Chess;

public class Bishop extends Piece {
    public Bishop(PieceColor color) {
        super(PieceType.BISHOP, color, new BishopMoveStrategy());
    }
}