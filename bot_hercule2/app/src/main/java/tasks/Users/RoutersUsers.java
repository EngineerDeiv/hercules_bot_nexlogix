package tasks.Users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RoutersUsers implements Task {

    public static final Target USERS_MENU_OPTION = Target.the("Opción Usuarios del menú")
            .located(By.xpath("//a[contains(@href, '/manager/gestionUsuarios')]"));

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(USERS_MENU_OPTION)
        );
    }

    public static RoutersUsers toUsersPage() {
        return instrumented(RoutersUsers.class);
    }
}
