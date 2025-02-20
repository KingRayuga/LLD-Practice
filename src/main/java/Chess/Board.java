package Chess;

import java.util.ArrayList;

public class Board {
    private final int SIZE = 8;
    private Cell[][] cells;
    private List<SpecialMove> specialMoves;

    public Board() {
        cells = new Cell[SIZE][SIZE];
        specialMoves = new ArrayList<>();
        initializeBoard();
        initializeSpecialMoves();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
        setupPieces(PieceColor.WHITE, 0, 1);
        setupPieces(PieceColor.BLACK, 7, 6);
    }

    private void initializeSpecialMoves() {
        specialMoves.add(new CastleMove());
        specialMoves.add(new EnPassantMove());
        specialMoves.add(new PromotionMove());
    }

    private void setupPieces(PieceColor color, int majorRow, int pawnRow) {
        cells[majorRow][0].setPiece(new Rook(color));
        cells[majorRow][1].setPiece(new Knight(color));
        cells[majorRow][2].setPiece(new Bishop(color));
        cells[majorRow][3].setPiece(new Queen(color));
        cells[majorRow][4].setPiece(new King(color));
        cells[majorRow][5].setPiece(new Bishop(color));
        cells[majorRow][6].setPiece(new Knight(color));
        cells[majorRow][7].setPiece(new Rook(color));

        for (int i = 0; i < SIZE; i++) {
            cells[pawnRow][i].setPiece(new Pawn(color));
        }
    }

    public SpecialMove getSpecialMove(Piece piece1, Piece piece2, Cell from, Cell to) {
        for (SpecialMove specialMove : specialMoves) {
            if (specialMove.validateMove(piece1, piece2, from, to)) {
                return specialMove;
            }
        }
        return null;
    }

    public boolean isKingInCheck(PieceColor kingColor) {
        Cell kingCell = findKing(kingColor);
        if (kingCell == null) return false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Piece piece = cells[i][j].getPiece();
                if (piece != null && piece.getColor() != kingColor) {
                    MoveStrategy strategy = piece.getMoveStrategy();
                    if (strategy.isValidMove(cells[i][j], kingCell, this)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Cell findKing(PieceColor kingColor) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Piece piece = cells[i][j].getPiece();
                if (piece != null && piece.getType() == PieceType.KING && piece.getColor() == kingColor) {
                    return cells[i][j];
                }
            }
        }
        return null;
    }

}
