package chess.piece;

import chess.Board;
import chess.Color;
import chess.Movement;
import chess.Position;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Knight extends Piece {

    public Knight(Position position, Board board, Color color) {
        super(position, board, color);
    }

    @Override
    public Set<Position> getMovablePositions() {
        return Arrays.stream(Movement.values())
                .filter(Movement::isMoveThreeStep)
                .filter(movement -> canMove(movement, getPosition()))
                .map(getPosition()::move)
                .collect(Collectors.toSet());
    }

    private boolean canMove(Movement movement, Position currentPosition) {
        return currentPosition.canMove(movement) && !board.existSameTeam(currentPosition.move(movement), getColor());
    }

    @Override
    public String toString() {
        return "KN";
    }
}
