package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DriversPage {

    public static final Target INPUT_SEARCH = Target.the("Input buscar conductor")
            .located(By.xpath("//input[contains(translate(@placeholder,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'buscar')"
                    + " or contains(translate(@aria-label,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'buscar')"
                    + " or contains(@name,'search') or contains(@type,'search')"
                    + " or contains(@class,'form-control')]") );

    public static final Target BTN_BUSCAR_ID = Target.the("Botón Buscar por ID")
            .located(By.xpath("//button[contains(@class,'btn-primary') and contains(normalize-space(.),'Buscar')]") );

    public static final Target TABLE_RESULTS = Target.the("Tabla de resultados de conductores")
            .located(By.cssSelector(".custom-table-wrapper, table"));

}
