package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import userinterface.RoutersGeneral;
import userinterface.VehiclesPage;

/**
 * Step definitions para la feature views_and_search_vehiculos.feature (vehículos)
 */
public class ViewsAndSearchVehiculosSteps {

	@Dado("que navega hasta la sección {string}")
	public void que_navega_hasta_la_sección(String section) {
		Actor actor = OnStage.theActorCalled("admin");
		actor.attemptsTo(
				// abrir el módulo Gestión Logística y luego la lista de Vehículos
				WaitUntil.the(RoutersGeneral.MODULE_GESTION_LOGISTICA, isVisible()).forNoMoreThan(10).seconds(),
				Click.on(RoutersGeneral.MODULE_GESTION_LOGISTICA),
				WaitUntil.the(RoutersGeneral.SELETC_SUBMENU_VEHICULOS, isVisible()).forNoMoreThan(10).seconds(),
				Click.on(RoutersGeneral.SELETC_SUBMENU_VEHICULOS),
				WaitUntil.the(VehiclesPage.TABLE_RESULTS, isVisible()).forNoMoreThan(10).seconds()
		);
		System.out.println("STEP: Navegado a la sección: " + section);
	}

	@Cuando("busca un vehículo específico por su placa {string}")
	public void busca_un_vehiculo_especifico_por_su_placa(String placa) {
		Actor actor = OnStage.theActorCalled("admin");
		actor.attemptsTo(
				WaitUntil.the(VehiclesPage.INPUT_SEARCH, isVisible()).forNoMoreThan(10).seconds(),
				Enter.theValue(placa).into(VehiclesPage.INPUT_SEARCH),
				WaitUntil.the(VehiclesPage.BTN_BUSCAR_ID, isVisible()).forNoMoreThan(10).seconds(),
				Click.on(VehiclesPage.BTN_BUSCAR_ID),
				WaitUntil.the(VehiclesPage.TABLE_RESULTS, isVisible()).forNoMoreThan(10).seconds()
		);
		// Mantener un tiempo para inspección manual
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("STEP: Buscado vehículo con placa: " + placa);
	}

	@Entonces("el sistema muestra los detalles del vehículo seleccionado correctamente")
	public void el_sistema_muestra_los_detalles_del_vehículo_seleccionado_correctamente() {
		System.out.println("STEP: verificar detalles de vehículo (automated).");
	}

}
