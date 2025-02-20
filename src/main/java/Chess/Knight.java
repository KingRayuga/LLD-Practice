package Chess;

public class Knight extends Piece {
    public Knight(PieceColor color) {
        super(PieceType.KNIGHT, color, new KnightMoveStrategy());
    }
}