package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import tasks.auth.Login;

public class view_and_search_routes {


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
    public void que_navega_hasta_la_sección_mostrando_la_lista_de_rutas_existentes(String string) {
        System.out.println("STEP: navegar a la sección: " + string + " (stub).");
    }
    @Cuando("busca una ruta específica por su nombre o código")
    public void busca_una_ruta_específica_por_su_nombre_o_código() {
        System.out.println("STEP: buscar ruta por nombre/código (stub).");
    }
    @Entonces("el sistema muestra los detalles de la ruta seleccionada correctamente")
    public void el_sistema_muestra_los_detalles_de_la_ruta_seleccionada_correctamente() {
        System.out.println("STEP: verificar detalles de ruta (stub).");
    }

}
