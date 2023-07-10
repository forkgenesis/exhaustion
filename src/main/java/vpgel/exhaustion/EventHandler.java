// Обработчик событий мода Exhaustion
package vpgel.exhaustion;

import net.minecraft.client.Minecraft;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {
    Minecraft mc = Minecraft.getInstance();

    /**leftClickBlock - событие, вызываемое в процессе зажатия ЛКМ на блоке
     */
    @SubscribeEvent public void leftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        PlayerContainer handler = PlayerContainer.getPlayer(event.getPlayer());
        if (handler != null)
            handler.getStats().leftClickBlock(
                event.getItemStack(),
                event.getPlayer().getLevel().getBlockState(event.getPos()).getBlock()
            );
        else PlayerContainer.addPlayer(event.getPlayer());
    }

    /** leftClickEmpty - событие, вызываемое в процессе зажатия ЛКМ на воздухе
     */
    @SubscribeEvent public void leftClickEmpty(PlayerInteractEvent.LeftClickEmpty event) {
        PlayerContainer handler = PlayerContainer.getPlayer(event.getPlayer());
        if (handler != null)
            handler.getStats().leftClickEmpty(
                    event.getItemStack()
            );
        else PlayerContainer.addPlayer(event.getPlayer());
    }

    /** serverChat - событие, вызываемое сообщением в чат Minecraft
     */
    @SubscribeEvent public void serverChat(ServerChatEvent event) {
        PlayerContainer handler = PlayerContainer.getPlayer(event.getPlayer());
        if (handler != null) handler.getStats().chat(event.getMessage());
        else PlayerContainer.addPlayer(event.getPlayer());
    }

    /** playerTick - событие, вызываемое каждый тик игры Minecraft (каждые 0.05 секунды)
     */
    @SubscribeEvent public void playerTick(TickEvent.PlayerTickEvent event) {
        ;
    }
}
