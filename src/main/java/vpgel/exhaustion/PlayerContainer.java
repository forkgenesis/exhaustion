// Тип, используемый модом для хранения значения выносливости для каждого игрока
package vpgel.exhaustion;

import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerContainer {
    public static final Map<String, PlayerContainer> ALL_PLAYERS = new HashMap<>();

    public Player player;
    public ExhaustionLogic stats;

    public PlayerContainer(Player player, ExhaustionLogic stats) {
        this.player = player;
        this.stats = stats;
    }

    public static void addPlayer(Player player) {
        if (!ALL_PLAYERS.containsKey(player.getDisplayName().getString())) {
            PlayerContainer container = new PlayerContainer(player, new ExhaustionLogic(player));
            ALL_PLAYERS.put(player.getDisplayName().getString(), container);
        }
    }

    public static PlayerContainer getPlayer(Player player) {
        return ALL_PLAYERS.get(player.getDisplayName().getString());
    }

    public ExhaustionLogic getStats() {
        return stats;
    }
}
