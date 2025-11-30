package userinterface.Rutas.Vehiculos;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ListaDesplegableLicencias {

    // Target para el elemento <select> principal
    public static final Target SELECT_TIPO_LICENCIA = Target.the("Selector de tipo de licencia")
            .located(By.name("tipo"));

    // Target para opciones específicas dentro del select
    public static Target OPCION_LICENCIA(String licencia) {
        return Target.the("Opción de licencia: " + licencia)
                .located(By.xpath("//select[@name='tipo']/option[@value='" + licencia + "']"));
    }

    public static final Target LICENCIA_A1 = OPCION_LICENCIA("A1");
    public static final Target LICENCIA_A2 = OPCION_LICENCIA("A2");
    public static final Target LICENCIA_B1 = OPCION_LICENCIA("B1");
    public static final Target LICENCIA_B2 = OPCION_LICENCIA("B2");
    public static final Target LICENCIA_B3 = OPCION_LICENCIA("B3");
    public static final Target LICENCIA_C1 = OPCION_LICENCIA("C1");
    public static final Target LICENCIA_C2 = OPCION_LICENCIA("C2");
    public static final Target LICENCIA_C3 = OPCION_LICENCIA("C3");
}