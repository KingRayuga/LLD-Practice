package Chess;

public class Move {
    private Piece piece;
    private Cell prevCell;
    private Cell currCell;

    public Move(Piece piece, Cell prevCell, Cell currCell) {
        this.piece = piece;
        this.prevCell = prevCell;
        this.currCell = currCell;
    }

    public Piece getPiece() {
        return piece;
    }

    public Cell getPrevCell() {
        return prevCell;
    }

    public Cell getCurrCell() {
        return currCell;
    }
}
