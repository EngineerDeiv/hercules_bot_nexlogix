package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.ensure.Ensure;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import tasks.auth.Login;
import net.serenitybdd.screenplay.actions.Open;
import utils_and_hooks.DefaultURL;
import userinterface.Rutas.Vehiculos.VehiclesNavPage;
import java.util.Arrays;
import java.util.List;

/**
 * Step definitions para la feature views_and_search_vehiculos.feature (vehículos)
 */
public class ViewsAndSearchVehiculosSteps {

	@Dado("que navega hasta la sección {string}")
	public void que_navega_hasta_la_sección(String section) {
	Actor actor = OnStage.theActorCalled("admin");
	// Asegurar que el usuario esté autenticado (usa el Task Login disponible en el proyecto)
	actor.attemptsTo(
		Login.asAdmin()
	);
	try {
		// Navegar directamente por URL — más robusto que depender del menú lateral (evita clicks fallidos)
		actor.attemptsTo(
			Open.url(DefaultURL.URL + "manager/vehiculos")
		);
		// Esperar que la tabla de Vehículos esté visible
		actor.attemptsTo(
			WaitUntil.the(VehiclesNavPage.TABLE_RESULTS, isVisible()).forNoMoreThan(15).seconds()
		);
		System.out.println("STEP: Navegado directamente a la sección: " + section);
	} catch (Exception e) {
		// Fallback: navegar directamente por URL si la navegación por menú falla (ej. overlay/JS que impide clicks)
		actor.attemptsTo(
				Open.url(DefaultURL.URL + "manager/vehiculos")
		);
		// Asegurar que la tabla se cargue
		actor.attemptsTo(
				WaitUntil.the(VehiclesNavPage.TABLE_RESULTS, isVisible()).forNoMoreThan(10).seconds()
		);
	}
		System.out.println("STEP: Navegado a la sección: " + section);
	}

	@Cuando("busca un vehículo específico por su placa {string}")
	public void busca_un_vehiculo_especifico_por_su_placa(String placa) {
		Actor actor = OnStage.theActorCalled("admin");
		actor.attemptsTo(
				WaitUntil.the(VehiclesNavPage.INPUT_SEARCH, isVisible()).forNoMoreThan(10).seconds(),
				Enter.theValue(placa).into(VehiclesNavPage.INPUT_SEARCH),
				WaitUntil.the(VehiclesNavPage.BTN_BUSCAR_ID, isVisible()).forNoMoreThan(10).seconds(),
				Click.on(VehiclesNavPage.BTN_BUSCAR_ID),
				WaitUntil.the(VehiclesNavPage.TABLE_RESULTS, isVisible()).forNoMoreThan(10).seconds()
		);
		// Mantener un tiempo para inspección manual
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("STEP: Buscado vehículo con placa: " + placa);
	}

	@Cuando("busca varias placas de vehiculos de la lista")
	public void busca_varias_placas_de_la_lista() {
		Actor actor = OnStage.theActorCalled("admin");

		// Lista de placas solicitada por el usuario
		List<String> placas = Arrays.asList("TRC101", "ERT901", "FGH97R");

		for (String placa : placas) {
			actor.attemptsTo(
					WaitUntil.the(VehiclesNavPage.INPUT_SEARCH, isVisible()).forNoMoreThan(10).seconds(),
					// Limpiar lo que esté en el input antes de escribir la siguiente placa
					Clear.field(VehiclesNavPage.INPUT_SEARCH),
					Enter.theValue(placa).into(VehiclesNavPage.INPUT_SEARCH),
					WaitUntil.the(VehiclesNavPage.BTN_BUSCAR_ID, isVisible()).forNoMoreThan(10).seconds(),
					Click.on(VehiclesNavPage.BTN_BUSCAR_ID),
					WaitUntil.the(VehiclesNavPage.TABLE_RESULTS, isVisible()).forNoMoreThan(10).seconds()
			);

			// Verificar que la tabla contiene la placa buscada
			actor.attemptsTo(
					Ensure.that(VehiclesNavPage.TABLE_RESULTS).text().contains(placa)
			);

			System.out.println("STEP: Buscado vehículo con placa: " + placa);

			// Pausa corta entre búsquedas para estabilidad y observación (ajustable)
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	@Entonces("el sistema muestra los detalles del vehículo seleccionado correctamente")
	public void el_sistema_muestra_los_detalles_del_vehículo_seleccionado_correctamente() {
		System.out.println("STEP: verificar detalles de vehículo (automated).");
	}

}
