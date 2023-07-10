// Главный файл мода Exhaustion
package vpgel.exhaustion;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod("exhaustion")
public class Exhaustion {
    /** LOGGER - утилита для отправки отладочных сообщений в консоль Minecraft
     */
    public static final Logger LOGGER = LoggerFactory.getLogger("Exhaustion");
    /** eventHandler - обработчик событий мода Exhaustion
     */
    public static EventHandler eventHandler = new EventHandler();

    /**Функция, инициализирующая мод Exhaustion
     */
    public Exhaustion() {
        MinecraftForge.EVENT_BUS.register(eventHandler);

        LOGGER.info("Exhaustion is initialized!");
    }
}

// Параметр выносливости
// можно будет выбрать между двумя опциями
// визуально над хотбаром показывать либо нет (по дефолту выключен)

// Три зоны уровня:
// 40-100% полон сил
// 20-40% смена цвета индикатора и звуковые эффекты одышки
// 0-20% блюр, негативные эффекты

// бежишь, махаешь инструментами и оружием - теряешь выносливость
// в разной броне тратишь больше выносливости
// стоишь ничего не делаешь - восполняется