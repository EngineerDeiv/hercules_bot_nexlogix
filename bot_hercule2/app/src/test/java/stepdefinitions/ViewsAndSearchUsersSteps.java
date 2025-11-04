package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

/**
 * Step definitions (vacías) para la feature views_and_search_users.feature
 */
public class ViewsAndSearchUsersSteps {

	@Dado("que navega hasta la sección {string} mostrando la lista de usuarios existentes")
	public void que_navega_hasta_la_sección_mostrando_la_lista_de_usuarios_existentes(String string) {
		System.out.println("STEP: navegar a la sección '" + string + "' mostrando lista de usuarios (stub).");
	}

	@Cuando("busca un usuario específico por su ID, email o número de identidad")
	public void busca_un_usuario_específico_por_su_id_email_o_número_de_identidad() {
		System.out.println("STEP: buscar usuario por ID/email/numero identidad (stub).");
	}

	@Entonces("el sistema muestra los detalles del usuario seleccionado correctamente")
	public void el_sistema_muestra_los_detalles_del_usuario_seleccionado_correctamente() {
		System.out.println("STEP: verificar detalles del usuario seleccionado (stub).");
	}

}
