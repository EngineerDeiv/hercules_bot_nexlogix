package tasks.vehiculos;

import models.CreateVehicule;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterface.Rutas.Vehiculos.FormCrearVehiculo;
import userinterface.Rutas.Vehiculos.ListaDesplegableEstados;
import userinterface.Rutas.Vehiculos.ListaDesplegableLicencias;
import userinterface.Rutas.Vehiculos.VehiclesNavPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;

public class FillCrearVehiculoForm implements Task {

    private final CreateVehicule vehiculo;

    public FillCrearVehiculoForm(CreateVehicule vehiculo) {
        this.vehiculo = vehiculo;
    }

    public static FillCrearVehiculoForm withData(CreateVehicule vehiculo) {
        return instrumented(FillCrearVehiculoForm.class, vehiculo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("[DEBUG] Filling vehicle form with: " + vehiculo);
        // Abrir modal de crear vehículo
        actor.attemptsTo(
                Click.on(VehiclesNavPage.BTN_CREAR_VEHICULO),
                WaitUntil.the(FormCrearVehiculo.MODAL_CREAR_VEHICULO, isVisible()).forNoMoreThan(10).seconds()
        );

        // Rellenar campos (no escribir directamente la fecha para evitar que el datepicker la reescriba)
        actor.attemptsTo(
            Enter.theValue(vehiculo.getPlaca()).into(FormCrearVehiculo.INPUT_PLACA),
            Enter.theValue(vehiculo.getMarca()).into(FormCrearVehiculo.INPUT_MARCA),
            // Seleccionar tipo (por value)
            SelectFromOptions.byValue(vehiculo.getTipo()).from(FormCrearVehiculo.SELECT_TIPO),
            Enter.theValue(vehiculo.getCapacidad()).into(FormCrearVehiculo.INPUT_CAPACIDAD),
            // Seleccionar estado (por value)
            SelectFromOptions.byValue(vehiculo.getEstado()).from(FormCrearVehiculo.SELECT_ESTADO)
        );

        // Forzar el valor del input de fecha mediante JS antes de guardar
        try {
            JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
            // limpiar y setear el valor directo, luego disparar eventos para que cualquier listener lo detecte
            js.executeScript("arguments[0].value = ''; arguments[0].dispatchEvent(new Event('input')); arguments[0].dispatchEvent(new Event('change'));", FormCrearVehiculo.INPUT_ULTIMO_MANTENIMIENTO.resolveFor(actor).getWrappedElement());
            js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input')); arguments[0].dispatchEvent(new Event('change'));", FormCrearVehiculo.INPUT_ULTIMO_MANTENIMIENTO.resolveFor(actor).getWrappedElement(), vehiculo.getUltimoMantenimiento());
        } catch (Exception e) {
            System.out.println("[WARN] No se pudo setear la fecha via JS: " + e.getMessage());
        }

        // Leer y loguear el valor actual del input de fecha justo antes de guardar
        try {
            String currentValue = FormCrearVehiculo.INPUT_ULTIMO_MANTENIMIENTO.resolveFor(actor).getAttribute("value");
            System.out.println("[DEBUG] After JS set, date input value = " + currentValue);
        } catch (Exception e) {
            System.out.println("[WARN] No se pudo leer el valor del input de fecha: " + e.getMessage());
        }

        // Guardar
        actor.attemptsTo(
            Click.on(FormCrearVehiculo.BTN_GUARDAR)
        );
    }
}
