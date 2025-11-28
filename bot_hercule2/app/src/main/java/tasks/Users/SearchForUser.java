package tasks.Users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchForUser implements Task {

    private final String searchTerm;

    public static final Target SEARCH_INPUT = Target.the("Barra de búsqueda de usuarios")
            .located(By.cssSelector("input[placeholder='Buscar por ID, documento o email...']"));

    public static final Target SEARCH_BUTTON = Target.the("Botón Buscar")
            .located(By.xpath("//button[contains(text(),'Buscar')]"));

    public SearchForUser(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public static SearchForUser withTerm(String searchTerm) {
        return instrumented(SearchForUser.class, searchTerm);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(searchTerm).into(SEARCH_INPUT),
                net.serenitybdd.screenplay.actions.Click.on(SEARCH_BUTTON)
        );
    }
}
