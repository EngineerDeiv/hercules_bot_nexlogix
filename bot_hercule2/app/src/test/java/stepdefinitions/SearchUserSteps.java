package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import questions.SuiteUsers.VerifyUser;
import tasks.Users.RoutersUsers;
import tasks.Users.SearchForUser;
import tasks.auth.Login;
import utils_and_hooks.TestContext;

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

    @Cuando("busca el usuario creado anteriormente")
    public void busca_el_usuario_creado_anteriormente() {
        String email = TestContext.createdUserEmail;
        System.out.println("STEP: Buscando usuario creado con email: " + email);
        theActorInTheSpotlight().attemptsTo(
                SearchForUser.withTerm(email)
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

    @Entonces("el sistema debe mostrar al usuario creado en los resultados")
    public void el_sistema_debe_mostrar_al_usuario_creado_en_los_resultados() {
        String email = TestContext.createdUserEmail;
        System.out.println("STEP: Verificando que se muestra el usuario: " + email);
        
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        VerifyUser.withEmail(email),
                        Matchers.is(true)
                )
        );
        try {
            Thread.sleep(15000); // Espera visual de 15 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
