package tasks.Users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavUsers implements Task {

    public static final Target CREATE_USER_BUTTON = Target.the("Botón Crear usuario")
            .located(By.xpath("//button[contains(@class, 'btn-warning') and contains(text(), 'Crear usuario')]"));

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CREATE_USER_BUTTON)
        );
    }

    public static NavUsers clickCreateUser() {
        return instrumented(NavUsers.class);
    }
}
