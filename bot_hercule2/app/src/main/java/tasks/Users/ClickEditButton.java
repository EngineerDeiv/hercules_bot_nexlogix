package tasks.Users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickEditButton implements Task {

    private final String email;

    public ClickEditButton(String email) {
        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Buscamos el botón de editar (lápiz) que esté en la misma fila que el email
        Target EDIT_BUTTON = Target.the("Botón Editar para el usuario " + email)
                .located(By.xpath("//tr[contains(., '" + email + "')]//button[contains(@class, 'btn-primary')]"));

        actor.attemptsTo(
                Click.on(EDIT_BUTTON)
        );
    }

    public static ClickEditButton forUser(String email) {
        return instrumented(ClickEditButton.class, email);
    }
}
