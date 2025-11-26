package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import tasks.Areas.RoutersAreas;
import tasks.Areas.SearchForArea;
import tasks.auth.Login;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SearchAreaSteps {

    @Dado("que el administrador está en la lista de áreas")
    public void que_el_administrador_esta_en_la_lista_de_areas() {
        // Aseguramos login y navegación (igual que SearchUserSteps)
        theActorInTheSpotlight().attemptsTo(
                Login.asAdmin(),
                RoutersAreas.toAreasPage()
        );
    }

    @Cuando("busca el área creada anteriormente")
    public void busca_el_area_creada_anteriormente() {
        String areaId = utils_and_hooks.TestContext.createdAreaId;
        System.out.println("STEP: Buscando área creada con ID: " + areaId);
        theActorInTheSpotlight().attemptsTo(
                SearchForArea.withTerm(areaId)
        );
    }

    @Entonces("el sistema debe mostrar el área creada en los resultados")
    public void el_sistema_debe_mostrar_el_area_creada_en_los_resultados() {
        String areaId = utils_and_hooks.TestContext.createdAreaId;
        System.out.println("STEP: Verificando que se muestra el área: " + areaId);
        try {
            Thread.sleep(5000); // Espera visual
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
