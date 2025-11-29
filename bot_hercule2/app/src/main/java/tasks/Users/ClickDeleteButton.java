package tasks.Users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickDeleteButton implements Task {

    private final String email;

    public ClickDeleteButton(String email) {
        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Buscamos el botón de eliminar (basura) que esté en la misma fila que el email
        // HTML: <button class="btn btn-sm btn-danger"><i class="bi bi-trash"></i></button>
        Target DELETE_BUTTON = Target.the("Botón Eliminar para el usuario " + email)
                .located(By.xpath("//tr[contains(., '" + email + "')]//button[contains(@class, 'btn-danger')]"));

        actor.attemptsTo(
                Click.on(DELETE_BUTTON)
        );
    }

    public static ClickDeleteButton forUser(String email) {
        return instrumented(ClickDeleteButton.class, email);
    }
}
