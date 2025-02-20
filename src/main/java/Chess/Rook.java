package Chess;

public class Rook extends Piece {
    public Rook(PieceColor color) {
        super(PieceType.ROOK, color, new RookMoveStrategy());
    }
}