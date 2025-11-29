package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.GivenWhenThen;
import org.hamcrest.Matchers;
import tasks.Users.ClickDeleteButton;
import tasks.Users.ConfirmDelete;
import tasks.Users.RoutersUsers;
import tasks.Users.SearchForUser;
import tasks.auth.Login;
import utils_and_hooks.TestContext;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteUserSteps {

    @Dado("que busco el usuario para eliminar")
    public void que_busco_el_usuario_para_eliminar() {
        String email = TestContext.createdUserEmail;
        if (email == null) {
            email = "test_default@nexlogix.com";
        }
        System.out.println("STEP: Buscando usuario para eliminar: " + email);

        theActorInTheSpotlight().attemptsTo(
                Login.asAdmin(),
                RoutersUsers.toUsersPage(),
                SearchForUser.withTerm(email)
        );
    }

    @Cuando("hago click en el boton de eliminar")
    public void hago_click_en_el_boton_de_eliminar() {
        String email = TestContext.createdUserEmail;
        theActorInTheSpotlight().attemptsTo(
                ClickDeleteButton.forUser(email)
        );
    }

    @Y("confirmo la eliminacion en el modal")
    public void confirmo_la_eliminacion_en_el_modal() {
        try {
            Thread.sleep(1000); // Espera visual para el modal
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        theActorInTheSpotlight().attemptsTo(
                ConfirmDelete.click()
        );
        try {
            Thread.sleep(3000); // Espera para que se procese la eliminación
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Entonces("Buscar el usuario eliminado")
    public void buscar_el_usuario_eliminado() {
        String email = TestContext.createdUserEmail;
        System.out.println("STEP: Buscando explícitamente el usuario eliminado: " + email);
        theActorInTheSpotlight().attemptsTo(SearchForUser.withTerm(email));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Entonces("el usuario ya no debe existir en el sistema")
    public void el_usuario_ya_no_debe_existir_en_el_sistema() {
        String email = TestContext.createdUserEmail;
        System.out.println("STEP: Verificando que el usuario fue eliminado: " + email);
        
        theActorInTheSpotlight().attemptsTo(SearchForUser.withTerm(email));
        
        // Validamos que NO sea visible (false)
        theActorInTheSpotlight().should(
                 GivenWhenThen.seeThat(
                        questions.SuiteUsers.VerifyUser.withEmail(email),
                        Matchers.is(false)
                )
        );
    }
}
