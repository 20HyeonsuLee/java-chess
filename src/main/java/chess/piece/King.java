package chess.piece;

import chess.Board;
import chess.Color;
import chess.Movement;
import chess.Position;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

public class King extends Piece {

    public King(Position position, Board board, Color color) {
        super(position, board, color);
    }

    @Override
    public Set<Position> getMovablePositions() {
        return getKingMoveablePositions().stream()
                .filter(position -> !board.existSameTeam(position, getColor()))
                .collect(Collectors.toSet());
    }

    private Set<Position> getKingMoveablePositions() {
        Deque<Movement> queue = new LinkedList<>();
        queue.add(Movement.UP);
        queue.add(Movement.DOWN);
        queue.add(Movement.LEFT);
        queue.add(Movement.RIGHT);
        queue.add(Movement.LEFT_UP);
        queue.add(Movement.RIGHT_UP);
        queue.add(Movement.LEFT_DOWN);
        queue.add(Movement.RIGHT_DOWN);
        Set<Position> movablePositions = new HashSet<>();
        while(!queue.isEmpty()) {
            Movement movement = queue.poll();
            if (getPosition().canMove(movement)) {
                movablePositions.add(getPosition().move(movement));
            }
        }
        return movablePositions;
    }

    @Override
    public String toString() {
        return "KI";
    }
}
