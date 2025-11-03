package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import utils_and_hooks.DefaultURL;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenPage implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(DefaultURL.URL)
        );
    }

    public static OpenPage toW3Schools() {
        return instrumented(OpenPage.class);
    }
}
