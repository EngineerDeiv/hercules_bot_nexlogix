package tasks.vehiculos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import userinterface.Rutas.Vehiculos.VehiclesNavPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchForVehicle implements Task {

    private final String searchTerm;

    public static final Target SEARCH_INPUT = VehiclesNavPage.INPUT_SEARCH;
    public static final Target SEARCH_BUTTON = VehiclesNavPage.BTN_BUSCAR_ID;

    public SearchForVehicle(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public static SearchForVehicle withTerm(String searchTerm) {
        return instrumented(SearchForVehicle.class, searchTerm);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(searchTerm).into(SEARCH_INPUT),
                Click.on(SEARCH_BUTTON)
        );
    }
}
