package vpgel.exhaustion;

import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {
    @SubscribeEvent public void serverChat(ServerChatEvent event) {
        PlayerContainer handler = PlayerContainer.getPlayer(event.getPlayer());
        if (handler != null) handler.getStats().chat(event.getMessage());
        else PlayerContainer.addPlayer(event.getPlayer());
    }
}
