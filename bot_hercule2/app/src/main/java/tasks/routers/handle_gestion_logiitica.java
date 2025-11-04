package tasks.routers;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import tasks.OpenPage;
import userinterface.RoutersGeneral;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class handle_gestion_logiitica extends OpenPage implements Task {

    public static handle_gestion_logiitica toGestionLogistica() {
        return instrumented(handle_gestion_logiitica.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Reutiliza la implementación de OpenPage para abrir la URL base
        super.performAs(actor);
        // Navegar al módulo Gestión Logística y abrir la sección Rutas
        actor.attemptsTo(
                Click.on(RoutersGeneral.MODULE_GESTION_LOGISTICA),
                Click.on(RoutersGeneral.SELETC_SUBMENU_RUTAS)
        );
    }
}
