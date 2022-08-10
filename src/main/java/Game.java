import java.util.ArrayList;

public class Game {


    private ArrayList<Player> players = new ArrayList<>();
    Player pl = new Player();

    public void register(Player player) {
        players.add(player);
    }

    public ArrayList<Player> findAll() {
        return players;
    }

    public int round(String playerName1, String playerName2) {
        int playerStrength1 = 0;
        int playerStrength2 = 0;
        for (Player each:players){
            if (each.getName() == playerName1) {
                playerStrength1 = each.getStrength();
            }
            if (each.getName() == playerName2) {
                playerStrength2 = each.getStrength();
            }
        }
        if (playerStrength1 == 0) {
            throw new NotRegisteredException(
                    "Пользователь " + playerName2 + " не найден"
            );
        }
        if (playerStrength2 == 0) {
            throw new NotRegisteredException(
                    "Пользователь " + playerName1 + " не найден"
            );
        } else {
            if (playerStrength1 > playerStrength2) {
                return 1;
            }
            if (playerStrength1 < playerStrength2) {
                return -1;
            } else {
                return 0;
            }
        }
    }


}
