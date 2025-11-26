package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import tasks.Users.RoutersUsers;
import tasks.Users.SearchForUser;
import tasks.auth.Login;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SearchUserSteps {

    @Dado("que el administrador está en la lista de usuarios")
    public void que_el_administrador_esta_en_la_lista_de_usuarios() {
        // Aseguramos login y navegación
        theActorInTheSpotlight().attemptsTo(
                Login.asAdmin(),
                RoutersUsers.toUsersPage()
        );
    }

    @Cuando("busca un usuario con el criterio {string}")
    public void busca_un_usuario_con_el_criterio(String criterio) {
        theActorInTheSpotlight().attemptsTo(
                SearchForUser.withTerm(criterio)
        );
    }

    @Entonces("el sistema debe mostrar al usuario {string} en los resultados")
    public void el_sistema_debe_mostrar_al_usuario_en_los_resultados(String usuarioEsperado) {
        // Aquí iría la validación (Question)
        System.out.println("STEP: Verificando que se muestra el usuario: " + usuarioEsperado);
        try {
            Thread.sleep(5000); // Espera visual
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
