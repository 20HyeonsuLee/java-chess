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

public class Knight extends Piece {

    public Knight(Position position, Board board, Color color) {
        super(position, board, color);
    }

    @Override
    public Set<Position> getMovablePositions() {
        return getKnightMoveablePositions().stream()
                .filter(position -> !board.existSameTeam(position, getColor()))
                .collect(Collectors.toSet());
    }

    private Set<Position> getKnightMoveablePositions() {
        Deque<Movement> queue = new LinkedList<>();
        queue.add(Movement.UP_UP_LEFT);
        queue.add(Movement.UP_UP_RIGHT);
        queue.add(Movement.DOWN_DOWN_LEFT);
        queue.add(Movement.DOWN_DOWN_RIGHT);
        queue.add(Movement.LEFT_LEFT_DOWN);
        queue.add(Movement.LEFT_LEFT_UP);
        queue.add(Movement.RIGHT_RIGHT_DOWN);
        queue.add(Movement.RIGHT_RIGHT_UP);
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
        return "KN";
    }
}
