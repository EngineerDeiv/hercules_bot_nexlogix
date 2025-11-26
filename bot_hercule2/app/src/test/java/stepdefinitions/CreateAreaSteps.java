package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.datatable.DataTable;
import models.Areas.createArea;
import net.serenitybdd.screenplay.actors.OnStage;
import tasks.Areas.CaptureAreaId;
import tasks.Areas.FillAreaForm;
import tasks.Areas.NavAreas;
import tasks.Areas.RoutersAreas;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateAreaSteps {

    @Cuando("navega a la sección de creación de áreas")
    public void navega_a_la_seccion_de_creacion_de_areas() {
        // Navegamos al menú de áreas y luego damos clic en "Crear área"
        theActorInTheSpotlight().attemptsTo(
                RoutersAreas.toAreasPage(),
                NavAreas.clickCreateArea()
        );
    }

    @Cuando("ingresa los datos de la nueva área")
    public void ingresa_los_datos_de_la_nueva_area(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> row = data.get(0); // Tomamos la primera fila

        // Creamos el modelo con los datos de la tabla
        createArea newArea = new createArea(
                row.get("NombreArea"),
                row.get("DescripcionArea")
        );

        // Ejecutamos la tarea de llenar el formulario
        theActorInTheSpotlight().attemptsTo(
                FillAreaForm.withData(newArea)
        );
    }

    @Entonces("el área debe ser creada exitosamente y aparecer en la lista")
    public void el_area_debe_ser_creada_exitosamente_y_aparecer_en_la_lista() {
        // Capturamos el ID del área creada
        theActorInTheSpotlight().attemptsTo(
                CaptureAreaId.fromTable()
        );
        
        // Aquí iría la validación (Question), por ahora dejamos el log
        System.out.println("STEP: Verificando que el área fue creada y aparece en la lista");
        try {
            Thread.sleep(12000); // Espera de 12 segundos solicitada
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
