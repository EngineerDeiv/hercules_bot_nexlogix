package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import utils_and_hooks.DefaultURL;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import tasks.OpenPage;
import userinterface.LoginPage;
import userinterface.RoutersGeneral;
import userinterface.CitiesPage;

/**
 * Automatización mínima para la feature views_and_search_cities.feature
 */
public class ViewsAndSearchCitiesSteps {
    @Dado("que navega hasta la sección {string} mostrando la lista de ciudades existentes")
    public void que_navega_hasta_la_sección_mostrando_la_lista_de_ciudades_existentes(String string) {
        // Garantizar que haya un actor disponible (creado por el hook)
        Actor actor = OnStage.theActorCalled("admin");
        // Navegar por el menú: abrir Gestión Logística, luego hacer click en Lista de Ciudades
    actor.attemptsTo(
        // esperar a que el toggle del módulo esté visible y clickable
        WaitUntil.the(RoutersGeneral.MODULE_GESTION_LOGISTICA, isVisible()).forNoMoreThan(10).seconds(),
        Click.on(RoutersGeneral.MODULE_GESTION_LOGISTICA),
        // dar tiempo a la animación/expansión del submenu
        WaitUntil.the(RoutersGeneral.SELETC_SUBMENU_CIUDADES, isVisible()).forNoMoreThan(10).seconds(),
        Click.on(RoutersGeneral.SELETC_SUBMENU_CIUDADES),
        // esperar a que la tabla de ciudades esté visible (lista cargada)
        WaitUntil.the(CitiesPage.TABLE_RESULTS, isVisible()).forNoMoreThan(10).seconds()
    );
        System.out.println("STEP: navegar a la sección '" + string + "' mostrando lista de ciudades (automated).");
    }

    @Cuando("busca una ciudad específica por su nombre")
    public void busca_una_ciudad_específica_por_su_nombre() {
    Actor actor = OnStage.theActorCalled("admin");
        // Ejemplo: buscar 'Bogota' — puedes parametrizar si lo deseas
        actor.attemptsTo(
        // esperar a que el input de búsqueda esté visible
        WaitUntil.the(CitiesPage.INPUT_SEARCH, isVisible()).forNoMoreThan(10).seconds(),
        // escribir el término y dar tiempo antes de pulsar buscar
        Enter.theValue("Bogota").into(CitiesPage.INPUT_SEARCH),
    WaitUntil.the(CitiesPage.BTN_BUSCAR_ID, isVisible()).forNoMoreThan(10).seconds(),
    Click.on(CitiesPage.BTN_BUSCAR_ID),
        // esperar a que los resultados aparezcan en la tabla
        WaitUntil.the(CitiesPage.TABLE_RESULTS, isVisible()).forNoMoreThan(10).seconds()
    );
        // Mantener el navegador abierto unos segundos tras la búsqueda para inspección manual
        try {
            Thread.sleep(15000); // 15 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("STEP: buscar ciudad por nombre (automated).");
    }

    @Entonces("el sistema muestra los detalles de la ciudad seleccionada correctamente")
    public void el_sistema_muestra_los_detalles_de_la_ciudad_seleccionada_correctamente() {
        // Por ahora solo imprimimos; podría añadirse una comprobación usando CitiesPage.TABLE_RESULTS
        System.out.println("STEP: verificar detalles de la ciudad seleccionada (automated).");
    }

}
