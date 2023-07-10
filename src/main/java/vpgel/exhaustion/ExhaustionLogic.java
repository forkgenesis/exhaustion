// Логистика механики выносливости
package vpgel.exhaustion;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ToolActions;

import static java.lang.Integer.parseInt;

public class ExhaustionLogic {
    public float stamina;
    public Player player;

    public ExhaustionLogic(Player player) {
        this.stamina = 100F;
        this.player = player;

        CompoundTag playerNBT = player.serializeNBT();
        CompoundTag modNBT = playerNBT.getCompound("Exhaustion");
        if (modNBT.contains("level"))
            this.stamina = modNBT.getFloat("level");
    }

    // Функция, вызывающая каждый тик в проуессе ломания блока
    public void leftClickBlock(ItemStack item, Block block) {
        //Exhaustion.LOGGER.info(item.toString()+" "+block.getName());

        if (item.canPerformAction(ToolActions.PICKAXE_DIG)) {
            stamina = Math.max(0F, stamina - Constants.PICKAXE_BLOCK / 20F);
        } else if (item.canPerformAction(ToolActions.AXE_DIG)) {
            stamina = Math.max(0F, stamina - Constants.AXE_BLOCK / 20F);
        } else if (item.canPerformAction(ToolActions.SWORD_DIG)) {
            stamina = Math.max(0F, stamina - Constants.SWORD_BLOCK / 20F);
        } else if (item.canPerformAction(ToolActions.SHOVEL_DIG)) {
            stamina = Math.max(0F, stamina - Constants.SHOVEL_BLOCK / 20F);
        } else if (item.canPerformAction(ToolActions.HOE_DIG)) {
            stamina = Math.max(0F, stamina - Constants.PICKAXE_BLOCK / 20F);
        } else if (item.canPerformAction(ToolActions.SHEARS_DIG)) {
            stamina = Math.max(0F, stamina - Constants.SHEARS_BLOCK / 20F);
        }
        writeData(stamina);
    }

    // Функция, вызывающая каждый тик в проуессе ломания блока
    public void leftClickEmpty(ItemStack item) {
        if (item.canPerformAction(ToolActions.PICKAXE_DIG)) {
            stamina = Math.max(0F, stamina - Constants.PICKAXE_EMPTY / 20F);
        } else if (item.canPerformAction(ToolActions.AXE_DIG)) {
            stamina = Math.max(0F, stamina - Constants.AXE_EMPTY / 20F);
        } else if (item.canPerformAction(ToolActions.SWORD_DIG)) {
            stamina = Math.max(0F, stamina - Constants.SWORD_EMPTY / 20F);
        } else if (item.canPerformAction(ToolActions.SHOVEL_DIG)) {
            stamina = Math.max(0F, stamina - Constants.SHOVEL_EMPTY / 20F);
        } else if (item.canPerformAction(ToolActions.HOE_DIG)) {
            stamina = Math.max(0F, stamina - Constants.PICKAXE_EMPTY / 20F);
        } else if (item.canPerformAction(ToolActions.SHEARS_DIG)) {
            stamina = Math.max(0F, stamina - Constants.SHEARS_EMPTY / 20F);
        } else if (item.canPerformAction(ToolActions.SHIELD_BLOCK)) {
            stamina = Math.max(0F, stamina - Constants.SHIELD_BLOCK / 20F);
        }
        writeData(stamina);
    }

    // Функция, вызывающаяся при сообщении в чате.
    public void chat(String msg) {
        stamina = parseInt(msg);
        writeData(stamina);
    }

    public void writeData(float level) {
        CompoundTag playerNBT = player.serializeNBT();
        CompoundTag modNBT = playerNBT.getCompound("Exhaustion");
        if (!playerNBT.contains("Exhaustion"))
            playerNBT.put("Exhaustion", modNBT);

        modNBT.putFloat("level", level);
        Exhaustion.LOGGER.info("Player stamina level: "+level);
    }


}
