package tasks.Areas;

import models.Areas.createArea;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillAreaForm implements Task {

    private final createArea area;

    // Targets basados en el análisis del frontend VerAreas.tsx
    public static final Target NAME_FIELD = Target.the("Campo Nombre del Área")
            .located(By.xpath("//input[@placeholder='Nombre del Área']"));
            
    public static final Target DESCRIPTION_FIELD = Target.the("Campo Descripción")
            .located(By.xpath("//input[@placeholder='Descripción']"));
            
    public static final Target SAVE_BUTTON = Target.the("Botón Guardar")
            .located(By.xpath("//button[contains(@class, 'btn-success') and contains(text(), 'Guardar')]"));

    public FillAreaForm(createArea area) {
        this.area = area;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(NAME_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(area.getNombreArea()).into(NAME_FIELD),
                Enter.theValue(area.getDescripcionArea()).into(DESCRIPTION_FIELD),
                Click.on(SAVE_BUTTON)
        );
    }

    public static FillAreaForm withData(createArea area) {
        return instrumented(FillAreaForm.class, area);
    }
}
