package tasks.Users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ListUtil implements Task {

    private final String rol;
    private final String puesto;
    private final String estado;

    // Targets basados en el atributo 'name' visto en las capturas
    public static final Target ROLE_DROPDOWN = Target.the("Lista desplegable de Rol")
            .located(By.cssSelector("select[name='idRole']"));

    public static final Target POSITION_DROPDOWN = Target.the("Lista desplegable de Puesto")
            .located(By.cssSelector("select[name='idPuestos']"));

    public static final Target STATUS_DROPDOWN = Target.the("Lista desplegable de Estado")
            .located(By.cssSelector("select[name='idestado']"));

    public ListUtil(String rol, String puesto, String estado) {
        this.rol = rol;
        this.puesto = puesto;
        this.estado = estado;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(rol).from(ROLE_DROPDOWN),
                SelectFromOptions.byVisibleText(puesto).from(POSITION_DROPDOWN),
                SelectFromOptions.byVisibleText(estado).from(STATUS_DROPDOWN)
        );
    }

    public static ListUtil withValues(String rol, String puesto, String estado) {
        return instrumented(ListUtil.class, rol, puesto, estado);
    }
}
