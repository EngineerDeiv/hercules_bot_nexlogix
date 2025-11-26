package tasks.Areas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import tasks.JSClick;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RoutersAreas implements Task {

    // Target para el link completo de Administración (el <a>)
    public static final Target ADMINISTRATION_MENU = Target.the("Menú Administración")
            .located(By.xpath("//a[contains(@class, 'dropdown-toggle') and .//span[text()='Administración']]"));

    // Target para Áreas 
    public static final Target AREAS_MENU_OPTION = Target.the("Opción Áreas del menú")
            .located(By.xpath("//a[contains(@class, 'submenu-item') and contains(@href, '/manager/verAreas')]"));

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ADMINISTRATION_MENU, isVisible()).forNoMoreThan(10).seconds(),
                JSClick.on(ADMINISTRATION_MENU),
                WaitUntil.the(AREAS_MENU_OPTION, isVisible()).forNoMoreThan(10).seconds(),
                JSClick.on(AREAS_MENU_OPTION)
        );
    }

    public static RoutersAreas toAreasPage() {
        return instrumented(RoutersAreas.class);
    }
}
