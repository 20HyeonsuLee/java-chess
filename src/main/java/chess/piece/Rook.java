package chess.piece;

import chess.Board;
import chess.Color;
import chess.Movement;
import chess.Position;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Rook extends Piece {

    public Rook(Position position, Board board, Color color) {
        super(position, board, color);
    }

    @Override
    protected Set<Position> getMovablePositions() {
        Set<Position> movablePositions = new HashSet<>();
        Deque<Movement> queue = new LinkedList();
        queue.add(Movement.LEFT);
        queue.add(Movement.RIGHT);
        queue.add(Movement.UP);
        queue.add(Movement.DOWN);
        while(!queue.isEmpty()) {
            Movement movement = queue.poll();
            Position currPosition = getPosition();
            while(currPosition.canMove(movement)) {
                currPosition = currPosition.move(movement);
                if (!board.existSameTeam(currPosition, getColor())) {
                    movablePositions.add(currPosition);
                }
                if (board.existPiece(currPosition)) {
                    break;
                }
            }
        }
        return movablePositions;
    }

    @Override
    public String toString() {
        return "RO";
    }
}
