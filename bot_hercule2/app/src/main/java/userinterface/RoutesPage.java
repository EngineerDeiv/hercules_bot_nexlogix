package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RoutesPage {
    
    // Input de búsqueda - exacto del HTML real: "Buscar por nombre, estado, etc..."
    public static final Target INPUT_SEARCH = Target.the("Campo de búsqueda de rutas")
        .located(By.xpath("//input[@class='form-control' and @placeholder='Buscar por nombre, estado, etc...']"));

    // ID de Ruta - input separado del HTML real
    public static final Target INPUT_ID_RUTA = Target.the("Campo ID de Ruta")
        .located(By.xpath("//input[@class='form-control' and @placeholder='ID de Ruta']"));

    // Botón Buscar - exacto del HTML que compartiste
    public static final Target BTN_BUSCAR = Target.the("Botón Buscar")
        .located(By.xpath("//button[@class='btn btn-primary']"));

    // Botón Nueva Ruta - del HTML real  
    public static final Target BTN_NUEVA_RUTA = Target.the("Botón Nueva Ruta")
        .located(By.xpath("//button[@class='btn btn-success ms-2' and normalize-space(text())='Nueva Ruta']"));

    // Tabla de resultados - estructura exacta del HTML real
    public static final Target TABLE_RESULTS = Target.the("Tabla de rutas")
        .located(By.cssSelector("div.table-responsive table.table.table-hover"));

    // Filas de la tabla para verificar resultados específicos
    public static final Target TABLE_ROWS = Target.the("Filas de la tabla de rutas")
        .located(By.xpath("//table//tbody//tr"));

}