package vpgel.exhaustion;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.slf4j.Log4jLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;


@Mod("exhaustion")
public class Exhaustion {
    //public static final Logger LOGGER = LogManager.getLogger();
    public static final Logger LOGGER = LoggerFactory.getLogger("exhaustion");

    public Exhaustion() {
        LOGGER.info("Exhaustion запущен!");
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