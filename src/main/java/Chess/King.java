package Chess;

public class King extends Piece {
    public King(PieceColor color) {
        super(PieceType.KING, color, new KingMoveStrategy());
    }
}