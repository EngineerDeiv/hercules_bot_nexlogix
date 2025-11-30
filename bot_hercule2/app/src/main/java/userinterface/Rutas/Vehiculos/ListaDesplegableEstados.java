package userinterface.Rutas.Vehiculos;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ListaDesplegableEstados {

    public static final Target SELECT_ESTADO = Target.the("Selector de estado")
            .located(By.name("estado"));

    public static Target OPCION_ESTADO(String valor) {
        return Target.the("Opción de estado: " + valor)
                .located(By.xpath("//select[@name='estado']/option[@value='" + valor + "']"));
    }

    public static final Target ESTADO_DISPONIBLE = OPCION_ESTADO("disponible");
    public static final Target ESTADO_ASIGNADO = OPCION_ESTADO("asignado");
    public static final Target ESTADO_EN_RUTA = OPCION_ESTADO("en_ruta");
    public static final Target ESTADO_MANTENIMIENTO = OPCION_ESTADO("mantenimiento");
    public static final Target ESTADO_FUERA_DE_SERVICIO = OPCION_ESTADO("fuera_de_servicio");
}
