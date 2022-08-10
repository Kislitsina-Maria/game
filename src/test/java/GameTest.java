import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameTest {

    @Test
    public void save() {
        Game game = new Game();

        Player player1 = new Player(1, "Masha", 5);
        Player player2 = new Player(2, "Misha", 2);
        game.register(player1);
        game.register(player2);

        List<Player> expected = Arrays.asList(player1, player2);
        ArrayList<Player> actual = game.findAll();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstIsBetter() {
        Game game = new Game();

        Player player1 = new Player(1, "Masha", 5);
        Player player2 = new Player(2, "Misha", 2);
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Masha", "Misha");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondIsBetter() {
        Game game = new Game();

        Player player1 = new Player(1, "Masha", 5);
        Player player2 = new Player(2, "Misha", 7);
        game.register(player1);
        game.register(player2);

        int expected = -1;
        int actual = game.round("Masha", "Misha");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sameStrength() {
        Game game = new Game();

        Player player1 = new Player(1, "Masha", 5);
        Player player2 = new Player(2, "Misha", 5);
        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Masha", "Misha");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notFindFirstName() {
        Game game = new Game();

        Player player1 = new Player(1, "Masha", 5);
        Player player2 = new Player(2, "Misha", 2);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Maa", "Misha");
        });
    }

    @Test
    public void notFindSecondName() {
        Game game = new Game();

        Player player1 = new Player(1, "Masha", 5);
        Player player2 = new Player(2, "Misha", 2);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Masha", "Mia");
        });
    }
}
