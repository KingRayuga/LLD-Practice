package Chess;

public class Queen extends Piece {
    public Queen(PieceColor color) {
        super(PieceType.QUEEN, color, new QueenMoveStrategy());
    }
}