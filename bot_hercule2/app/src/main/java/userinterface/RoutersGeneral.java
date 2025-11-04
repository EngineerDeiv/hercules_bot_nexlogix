package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RoutersGeneral {
    public static final Target MODULE_GESTION_LOGISTICA = Target.the("Toggle Gestión Logística")
	    .located(By.cssSelector("a[href*='#VehiculosSubmenu']"));

    public static final Target SUBMENU_RUTAS = Target.the("Submenu Rutas")
	    .located(By.xpath("//a[contains(@href,'/manager/rutas') and normalize-space(.)='Rutas']"));

    public static final Target SUBMENU_VEHICULOS = Target.the("Submenu Vehículos")
	    .located(By.xpath("//a[contains(@href,'/manager/vehiculos')]"));

    public static final Target SUBMENU_CONDUCTORES = Target.the("Submenu Conductores")
	    .located(By.xpath("//a[contains(@href,'/manager/conductores')]"));

    public static final Target LISTA_RUTAS = Target.the("Lista de rutas")
	    .located(By.cssSelector(".submenu-container, .routes-list, #routes, table"));

}
