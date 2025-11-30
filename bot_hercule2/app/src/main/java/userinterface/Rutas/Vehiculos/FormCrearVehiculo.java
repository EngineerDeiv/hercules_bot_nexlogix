package userinterface.Rutas.Vehiculos;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FormCrearVehiculo {

    public static final Target MODAL_CREAR_VEHICULO = Target.the("Modal Crear Vehículo")
            .located(By.cssSelector(".crear-conductor-modal"));

    public static final Target TITLE_MODAL = Target.the("Título del modal Crear Vehículo")
            .located(By.cssSelector(".crear-conductor-modal .modal-title"));

    public static final Target INPUT_PLACA = Target.the("Input Placa")
            .located(By.name("placa"));

    public static final Target INPUT_MARCA = Target.the("Input Marca")
            .located(By.name("marca"));

    public static final Target SELECT_TIPO = Target.the("Select Tipo")
            .located(By.name("tipo"));

    public static final Target INPUT_CAPACIDAD = Target.the("Input Capacidad")
            .located(By.name("capacidad"));

    public static final Target SELECT_ESTADO = Target.the("Select Estado")
            .located(By.name("estado"));

    public static final Target INPUT_ULTIMO_MANTENIMIENTO = Target.the("Input Último mantenimiento")
            .located(By.name("ultimoMantenimiento"));

    public static final Target BTN_CANCELAR = Target.the("Botón Cancelar")
            .located(By.xpath("//div[contains(@class,'crear-conductor-modal')]//div[contains(@class,'modal-footer')]//button[contains(@class,'btn-secondary') and normalize-space(text())='Cancelar']"));

    public static final Target BTN_GUARDAR = Target.the("Botón Guardar")
            .located(By.xpath("//div[contains(@class,'crear-conductor-modal')]//div[contains(@class,'modal-footer')]//button[contains(@class,'btn-success') and normalize-space(text())='Guardar']"));

}
