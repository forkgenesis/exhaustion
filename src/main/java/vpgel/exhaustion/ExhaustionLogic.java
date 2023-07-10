package vpgel.exhaustion;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

import static java.lang.Integer.parseInt;

public class ExhaustionLogic {
    public int stamina;
    public Player player;

    public ExhaustionLogic(Player player) {
        this.stamina = 100;
        this.player = player;

        CompoundTag playerNBT = player.serializeNBT();
        CompoundTag modNBT = playerNBT.getCompound("Exhaustion");
        if (modNBT.contains("level"))
            stamina = modNBT.getInt("level");
    }

    // Функция, вызывающаяся при сообщении в чате.
    public void chat(String msg) {
        stamina = parseInt(msg);
        writeData(stamina);
    }

    public void writeData(int level) {
        CompoundTag playerNBT = player.serializeNBT();
        CompoundTag modNBT = playerNBT.getCompound("Exhaustion");
        if (!playerNBT.contains("Exhaustion"))
            playerNBT.put("Exhaustion", modNBT);

        modNBT.putInt("level", level);
        Exhaustion.LOGGER.info("Player stamina level: "+level);
    }


}
