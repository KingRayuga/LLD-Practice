package Chess;

public abstract class Piece {
    protected PieceType type;
    protected PieceColor color;
    protected MoveStrategy moveStrategy;

    public Piece(PieceType type, PieceColor color, MoveStrategy moveStrategy) {
        this.type = type;
        this.color = color;
        this.moveStrategy = moveStrategy;
    }

    public boolean validateMove(Cell currCell, Cell futureCell, Board board) {
        return moveStrategy.validateMove(currCell, futureCell, board);
    }

    public PieceType getType() {
        return type;
    }

    public PieceColor getColor() {
        return color;
    }
}