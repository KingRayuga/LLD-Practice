package Chess;

public class PieceFactory {
    public static Piece createPiece(PieceType type, PieceColor color) {
        return switch (type) {
            case KING -> new King(color);
            case QUEEN -> new Queen(color);
            case ROOK -> new Rook(color);
            case BISHOP -> new Bishop(color);
            case KNIGHT -> new Knight(color);
            case PAWN -> new Pawn(color);
            default -> throw new IllegalArgumentException("Invalid piece type");
        };
    }
}
