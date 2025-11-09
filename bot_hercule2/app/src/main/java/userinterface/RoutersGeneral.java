package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RoutersGeneral {
    public static final Target MODULE_GESTION_LOGISTICA = Target.the("Toggle Gestión Logística")
    	.located(By.xpath("//a[contains(normalize-space(.),'Gestión Logística') or contains(.,'Gestión Logística')]") );

    public static final Target SELETC_SUBMENU_RUTAS = Target.the("Submenu Rutas")
	    .located(By.xpath("//a[contains(@href,'/manager/rutas') and normalize-space(.)='Rutas']"));

    // Toggle principal del menú que expande el submenú Vehículos (ej. tiene aria-controls="VehiculosSubmenu")
    public static final Target SELETC_SUBMENU_VEHICULOS_TOGGLE = Target.the("Submenu Vehículos toggle")
	    .located(By.xpath("//a[contains(@href,'/manager/vehiculos') and (contains(@class,'dropdown-toggle') or @aria-controls) ]"));

    // Item interno del submenú que realmente navega a /manager/vehiculos
    public static final Target SELETC_SUBMENU_VEHICULOS_ITEM = Target.the("Submenu Vehículos item")
		.located(By.xpath("//a[contains(@class,'submenu-item') and contains(@href,'/manager/vehiculos')]") );
		
	public static final Target SELETC_SUBMENU_VEHICULOS_ITEM_RELATIVE = Target.the("Submenu Vehículos item (relative)")
		.located(By.xpath("//a[contains(@href,'#VehiculosSubmenu')]/following-sibling::div//a[contains(@class,'submenu-item') and contains(@href,'/manager/vehiculos')]") );

    public static final Target SELETC_SUBMENU_CONDUCTORES = Target.the("Submenu Conductores")
	    .located(By.xpath("//a[contains(@href,'/manager/conductores')]"));

	public static final Target SELETC_SUBMENU_CIUDADES = Target.the("Submenu Ciudades")
		// Usar un localizador más permisivo (solo por href) para evitar problemas con espacios/normalización
		.located(By.xpath("//a[contains(@href,'/manager/ciudades')]") );

    public static final Target SELETC_LISTA_RUTAS = Target.the("Lista de rutas")
	    .located(By.cssSelector(".submenu-container, .routes-list, #routes, table"));
}
