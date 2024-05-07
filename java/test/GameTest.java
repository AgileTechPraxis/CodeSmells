import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
    private Game game;

    @BeforeEach
    public void InitializeGame() {
        game = new Game();
    }

    @Test
    public void NotAllowPlayerOToPlayFirst() {
        assertThrows(Exception.class, () -> game.play('O', 0, 0));
    }

    @Test
    public void NotAllowPlayerXToPlayTwiceInARow() {
        assertThrows(Exception.class, () -> {
            game.play('X', 0, 0);
            game.play('X', 1, 0);
        });
    }

    @Test
    public void NotAllowPlayerToPlayInLastPlayedPosition() {
        assertThrows(Exception.class, () -> {
            game.play('X', 0, 0);
            game.play('O', 0, 0);
        });
    }

    @Test
    public void NotAllowPlayerToPlayInAnyPlayedPosition() {
        assertThrows(Exception.class, () -> {
            game.play('X', 0, 0);
            game.play('O', 1, 0);
            game.play('X', 0, 0);
        });
    }

    @Test
    public void DeclareNoWinnerWithUnfinishedGrid() throws Exception {
        game.play('X', 0, 0);
        game.play('O', 1, 0);
        game.play('X', 0, 1);
        game.play('O', 1, 1);

        Optional<Character> winner = game.computeWinner();

        assertTrue(winner.isEmpty());
    }

    @Test
    public void DeclareNoWinnerWithTiedGrid() throws Exception {
        game.play('X', 1, 1);
        game.play('O', 0, 0);
        game.play('X', 0, 2);
        game.play('O', 2, 0);
        game.play('X', 1, 0);
        game.play('0', 1, 2);
        game.play('X', 2, 1);
        game.play('O', 0, 1);
        game.play('X', 2, 2);

        Optional<Character> winner = game.computeWinner();

        assertTrue(winner.isEmpty());
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception {
        game.play('X', 0, 0);
        game.play('O', 1, 0);
        game.play('X', 0, 1);
        game.play('O', 1, 1);
        game.play('X', 0, 2);

        Optional<Character> winner = game.computeWinner();

        assertTrue(winner.isPresent());
        assertEquals('X', winner.get());
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception {
        game.play('X', 2, 2);
        game.play('O', 0, 0);
        game.play('X', 1, 0);
        game.play('O', 0, 1);
        game.play('X', 1, 1);
        game.play('O', 0, 2);

        Optional<Character> winner = game.computeWinner();

        assertTrue(winner.isPresent());
        assertEquals('O', winner.get());
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception {
        game.play('X', 1, 0);
        game.play('O', 0, 0);
        game.play('X', 1, 1);
        game.play('O', 0, 1);
        game.play('X', 1, 2);

        Optional<Character> winner = game.computeWinner();

        assertTrue(winner.isPresent());
        assertEquals('X', winner.get());
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception {
        game.play('X', 0, 0);
        game.play('O', 1, 0);
        game.play('X', 2, 0);
        game.play('O', 1, 1);
        game.play('X', 2, 1);
        game.play('O', 1, 2);

        Optional<Character> winner = game.computeWinner();

        assertTrue(winner.isPresent());
        assertEquals('O', winner.get());
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception {
        game.play('X', 2, 0);
        game.play('O', 0, 0);
        game.play('X', 2, 1);
        game.play('O', 0, 1);
        game.play('X', 2, 2);

        Optional<Character> winner = game.computeWinner();

        assertTrue(winner.isPresent());
        assertEquals('X', winner.get());
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception {
        game.play('X', 0, 0);
        game.play('O', 2, 0);
        game.play('X', 1, 0);
        game.play('O', 2, 1);
        game.play('X', 1, 1);
        game.play('O', 2, 2);

        Optional<Character> winner = game.computeWinner();

        assertTrue(winner.isPresent());
        assertEquals('O', winner.get());
    }
}
