package tasks.Areas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class NavAreas implements Task {

    // Target para el botón "Crear área" - más robusto
    public static final Target CREATE_AREA_BUTTON = Target.the("Botón Crear área")
            .located(By.xpath("//button[contains(@class, 'btn-warning') and contains(text(), 'Crear área')]"));

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CREATE_AREA_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(CREATE_AREA_BUTTON)
        );
    }

    public static NavAreas clickCreateArea() {
        return instrumented(NavAreas.class);
    }
}
