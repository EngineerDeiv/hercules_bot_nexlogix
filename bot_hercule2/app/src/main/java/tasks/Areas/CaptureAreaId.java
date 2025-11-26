package tasks.Areas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CaptureAreaId implements Task {

    // Target para capturar el ID del área desde la primera fila de la tabla
    public static final Target FIRST_AREA_ID = Target.the("ID del área en la primera fila")
            .located(By.xpath("//table[@class='table custom-table']//tbody/tr[1]/td[1]"));

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            // Esperamos un momento para que la tabla se actualice
            Thread.sleep(3000);
            
            // Capturamos el ID del área creada (primera fila de la tabla)
            String areaId = FIRST_AREA_ID.resolveFor(actor).getText();
            
            // Guardamos el ID en el contexto
            utils_and_hooks.TestContext.createdAreaId = areaId;
            
            System.out.println("TASK: Área creada con ID: " + areaId);
        } catch (Exception e) {
            System.err.println("ERROR: No se pudo capturar el ID del área: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static CaptureAreaId fromTable() {
        return instrumented(CaptureAreaId.class);
    }
}
