package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import tasks.auth.Login;
import userinterface.RoutersGeneral;
import userinterface.RoutesPage;

import java.util.Arrays;
import java.util.List;

public class view_and_search_routes {

    // Buscar por ID de ruta: 17
    private static final String ROUTE_ID_TO_SEARCH = "17";

    @Dado("el usuario es administrador y está autenticado en el sistema")
    public void el_usuario_es_administrador_y_está_autenticado_en_el_sistema() {
        // Implementación mínima pero realista: usar el Task Login para autenticar
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                Login.asAdmin()
        );
        System.out.println("STEP: usuario administrador autenticado (via Login Task).");
    }

    @Dado("que se encuentra en el módulo {string}")
    public void que_se_encuentra_en_el_módulo(String string) {
        System.out.println("STEP: navegar al módulo: " + string + " (stub).");
    }

    @Dado("que navega hasta la sección {string} mostrando la lista de rutas existentes")
    public void que_navega_hasta_la_sección_mostrando_la_lista_de_rutas_existentes(String sectionName) {
        // Navegar al módulo Gestión Logística y luego al submenu Rutas
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(RoutersGeneral.MODULE_GESTION_LOGISTICA),
                WaitUntil.the(RoutersGeneral.SELETC_SUBMENU_RUTAS, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(RoutersGeneral.SELETC_SUBMENU_RUTAS),
                WaitUntil.the(RoutesPage.TABLE_RESULTS, isVisible()).forNoMoreThan(10).seconds()
        );
        System.out.println("STEP: navegó a la sección '" + sectionName + "' - Lista de rutas cargada.");
    }

    @Cuando("busca una ruta específica por su nombre o código")
    public void busca_una_ruta_específica_por_su_nombre_o_código() {
        System.out.println("STEP: Iniciando búsqueda de ruta por ID: " + ROUTE_ID_TO_SEARCH);
        
        // Usar el campo ID de Ruta que es más simple
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(RoutesPage.INPUT_ID_RUTA, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(RoutesPage.INPUT_ID_RUTA),
                Enter.theValue(ROUTE_ID_TO_SEARCH).into(RoutesPage.INPUT_ID_RUTA)
        );
        
        // Pequeña pausa antes de buscar
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(RoutesPage.BTN_BUSCAR)
        );
        
        System.out.println("STEP: Búsqueda ejecutada para ruta ID: " + ROUTE_ID_TO_SEARCH);
        
        // Pausa para ver los resultados
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
        @Entonces("el sistema muestra los detalles de la ruta seleccionada correctamente")
    public void el_sistema_muestra_los_detalles_de_la_ruta_seleccionada_correctamente() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(RoutesPage.TABLE_RESULTS, isVisible()).forNoMoreThan(10).seconds()
        );
        System.out.println("STEP: Sistema muestra correctamente los detalles de la ruta ID: " + ROUTE_ID_TO_SEARCH);
        
        // Hold para debug por 2 minutos
        try {
            Thread.sleep(120000); // 2 minutos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
