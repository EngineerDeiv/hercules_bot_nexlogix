package tasks.Users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChangeStatus implements Task {

    private final String newStatus;

    public static final Target STATUS_DROPDOWN = Target.the("Lista desplegable de Estado")
            .located(By.cssSelector("select[name='idestado']"));

    public static final Target SAVE_BUTTON = Target.the("Botón Guardar")
            .located(By.xpath("//button[normalize-space()='Guardar']"));

    public ChangeStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(newStatus).from(STATUS_DROPDOWN),
                Click.on(SAVE_BUTTON)
        );
    }

    public static ChangeStatus to(String newStatus) {
        return instrumented(ChangeStatus.class, newStatus);
    }
}
