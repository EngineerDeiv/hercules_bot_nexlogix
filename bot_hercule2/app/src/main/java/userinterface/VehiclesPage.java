package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VehiclesPage {

    public static final Target INPUT_SEARCH = Target.the("Input buscar vehiculo")
            .located(By.xpath("//input[contains(translate(@placeholder,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'buscar')"
                    + " or contains(translate(@aria-label,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'buscar')"
                    + " or contains(@name,'search') or contains(@type,'search')"
                    + " or contains(@class,'form-control')]") );

    public static final Target BTN_BUSCAR_ID = Target.the("Botón Buscar por ID")
            .located(By.xpath("//button[contains(@class,'btn-primary') and contains(normalize-space(.),'Buscar')]") );

    public static final Target TABLE_RESULTS = Target.the("Tabla de resultados de vehículos")
            .located(By.cssSelector(".custom-table-wrapper, table"));

    // Botón para mostrar todos los vehículos (según el HTML mostrado en la imagen)
    public static final Target BTN_MOSTRAR_TODOS = Target.the("Botón Mostrar todos")
            .located(By.xpath("//button[contains(@class,'btn-success') and contains(normalize-space(.),'Mostrar')]") );

    // Botón para crear vehículo
    public static final Target BTN_CREAR_VEHICULO = Target.the("Botón Crear vehículo")
            .located(By.xpath("//button[contains(@class,'btn-warning') and contains(normalize-space(.),'Crear')]") );

}
