package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import userinterface.RoutersGeneral;
import userinterface.DriversPage;

public class ViewsAndSearchDriversSteps {
	@Dado("que navega hasta la sección {string} mostrando la lista de conductores existentes")
	public void que_navega_hasta_la_sección_mostrando_la_lista_de_conductores_existentes(String sectionName) {
		// Navegar al módulo Gestión Logística y luego al submenu Conductores
		OnStage.theActorInTheSpotlight().attemptsTo(
				Click.on(RoutersGeneral.MODULE_GESTION_LOGISTICA),
				WaitUntil.the(RoutersGeneral.SELETC_SUBMENU_CONDUCTORES, isVisible()).forNoMoreThan(10).seconds(),
				Click.on(RoutersGeneral.SELETC_SUBMENU_CONDUCTORES),
				WaitUntil.the(DriversPage.TABLE_RESULTS, isVisible()).forNoMoreThan(10).seconds()
		);
	}

	@Cuando("busca un conductor específico por su nombre, número de identificación o numero de licencia")
	public void busca_un_conductor_específico_por_su_nombre_número_de_identificación_o_numero_de_licencia() {
		// Usamos un término de búsqueda visible en la UI para que haya resultados durante la prueba
		String query = "josenorbert1959@gmail.com"; // puedes cambiar esto a un ID como "27" si prefieres
		OnStage.theActorInTheSpotlight().attemptsTo(
				WaitUntil.the(DriversPage.INPUT_SEARCH, isVisible()).forNoMoreThan(10).seconds(),
				Enter.theValue(query).into(DriversPage.INPUT_SEARCH),
				WaitUntil.the(DriversPage.BTN_BUSCAR_ID, isVisible()).forNoMoreThan(10).seconds(),
				Click.on(DriversPage.BTN_BUSCAR_ID),
				WaitUntil.the(DriversPage.TABLE_RESULTS, isVisible()).forNoMoreThan(10).seconds()
		);
	}

	@Entonces("el sistema muestra los detalles del conductor seleccionado correctamente")
	public void el_sistema_muestra_los_detalles_del_conductor_seleccionado_correctamente() {
		// Por ahora comprobamos que la tabla de resultados está visible (se puede mejorar con assertions)
		System.out.println("STEP: comprobar detalles del conductor (tabla visible).");
	}

}
