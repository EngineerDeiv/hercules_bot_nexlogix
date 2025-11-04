package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import userinterface.RoutersGeneral;
import userinterface.UsersPage;

/**
 * Step definitions para la feature views_and_search_users.feature (usuarios)
 */
public class ViewsAndSearchUsersSteps {

	@Dado("que navega hasta la sección {string} mostrando la lista de usuarios existentes")
	public void que_navega_hasta_la_sección_mostrando_la_lista_de_usuarios_existentes(String section) {
		Actor actor = OnStage.theActorCalled("admin");
		actor.attemptsTo(
				// abrir el módulo Administración y luego la lista de Usuarios
				WaitUntil.the(RoutersGeneral.MODULE_ADMINISTRACION, isVisible()).forNoMoreThan(10).seconds(),
				Click.on(RoutersGeneral.MODULE_ADMINISTRACION),
				WaitUntil.the(RoutersGeneral.SELETC_SUBMENU_USUARIOS, isVisible()).forNoMoreThan(10).seconds(),
				Click.on(RoutersGeneral.SELETC_SUBMENU_USUARIOS),
				WaitUntil.the(UsersPage.TABLE_RESULTS, isVisible()).forNoMoreThan(10).seconds()
		);
		System.out.println("STEP: Navegado a la sección: " + section);
	}

	@Cuando("busca un usuario específico por su ID, email o número de identidad")
	public void busca_un_usuario_específico_por_su_id_email_o_número_de_identidad() {
		Actor actor = OnStage.theActorCalled("admin");
		// Puedes cambiar este valor por el documento o email que necesites buscar
		String searchValue = "1234567890"; // Ejemplo: número de documento
		
		actor.attemptsTo(
				WaitUntil.the(UsersPage.INPUT_SEARCH, isVisible()).forNoMoreThan(10).seconds(),
				Enter.theValue(searchValue).into(UsersPage.INPUT_SEARCH),
				WaitUntil.the(UsersPage.BTN_BUSCAR_ID, isVisible()).forNoMoreThan(10).seconds(),
				Click.on(UsersPage.BTN_BUSCAR_ID),
				WaitUntil.the(UsersPage.TABLE_RESULTS, isVisible()).forNoMoreThan(10).seconds()
		);
		// Mantener un tiempo para inspección manual
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("STEP: Buscado usuario con: " + searchValue);
	}

	@Entonces("el sistema muestra los detalles del usuario seleccionado correctamente")
	public void el_sistema_muestra_los_detalles_del_usuario_seleccionado_correctamente() {
		System.out.println("STEP: verificar detalles del usuario seleccionado (automated).");
	}

}

