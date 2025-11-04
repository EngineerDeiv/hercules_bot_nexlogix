package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

/**
 * Step definitions (vacías) para la feature views_and_search_drivers.feature
 */
public class ViewsAndSearchDriversSteps {
	@Dado("que navega hasta la sección {string} mostrando la lista de conductores existentes")
	public void que_navega_hasta_la_sección_mostrando_la_lista_de_conductores_existentes(String string) {
		System.out.println("STEP: navegar a la sección '" + string + "' mostrando lista de conductores (stub).");
	}

	@Cuando("busca un conductor específico por su nombre, número de identificación o numero de licencia")
	public void busca_un_conductor_específico_por_su_nombre_número_de_identificación_o_numero_de_licencia() {
		System.out.println("STEP: buscar conductor por nombre/ID/licencia (stub).");
	}

	@Entonces("el sistema muestra los detalles del conductor seleccionado correctamente")
	public void el_sistema_muestra_los_detalles_del_conductor_seleccionado_correctamente() {
		System.out.println("STEP: verificar detalles del conductor seleccionado (stub).");
	}

}
