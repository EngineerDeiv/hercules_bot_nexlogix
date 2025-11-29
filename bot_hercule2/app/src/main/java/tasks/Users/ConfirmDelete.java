package tasks.Users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConfirmDelete implements Task {

    // HTML: <button type="button" class="btn btn-danger">Eliminar</button> dentro del modal
    public static final Target CONFIRM_BUTTON = Target.the("Botón Confirmar Eliminación")
            .located(By.xpath("//div[contains(@class, 'modal-footer')]//button[contains(@class, 'btn-danger') and contains(text(), 'Eliminar')]"));

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CONFIRM_BUTTON)
        );
    }

    public static ConfirmDelete click() {
        return instrumented(ConfirmDelete.class);
    }
}
