package tasks.Areas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchForArea implements Task {

    private final String searchTerm;

    // Target basado en el análisis del frontend VerAreas.tsx
    public static final Target SEARCH_INPUT = Target.the("Barra de búsqueda de áreas")
            .located(By.cssSelector("input[placeholder='Buscar área por ID...']"));

    public static final Target SEARCH_BUTTON = Target.the("Botón Buscar por ID")
            .located(By.xpath("//button[contains(text(),'Buscar por ID')]"));

    public SearchForArea(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public static SearchForArea withTerm(String searchTerm) {
        return instrumented(SearchForArea.class, searchTerm);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SEARCH_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(searchTerm).into(SEARCH_INPUT),
                net.serenitybdd.screenplay.actions.Click.on(SEARCH_BUTTON)
        );
    }
}
