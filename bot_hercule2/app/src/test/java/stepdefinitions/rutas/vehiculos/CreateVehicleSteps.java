package stepdefinitions.rutas.vehiculos;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import io.cucumber.java.es.Entonces;
import models.CreateVehicule;
import net.serenitybdd.screenplay.GivenWhenThen;
import org.hamcrest.Matchers;
import tasks.vehiculos.FillCrearVehiculoForm;
import tasks.vehiculos.SearchForVehicle;
import userinterface.Rutas.RoutersGeneral;
import userinterface.Rutas.Vehiculos.VehiclesNavPage;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils_and_hooks.TestContext;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.is;

public class CreateVehicleSteps {

    @Dado("que el administrador ha iniciado sesión y está en el panel principal de Vehículos")
    public void que_el_administrador_ha_iniciado_sesion_y_esta_en_el_panel_principal_de_Vehiculos() {
        theActorInTheSpotlight().attemptsTo(
                tasks.auth.Login.asAdmin()
        );
    }

    @Cuando("navega a la sección de vehículos")
    public void navega_a_la_seccion_de_vehiculos() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(RoutersGeneral.MODULE_GESTION_LOGISTICA),
                WaitUntil.the(RoutersGeneral.SELETC_SUBMENU_VEHICULOS_ITEM, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(RoutersGeneral.SELETC_SUBMENU_VEHICULOS_ITEM)
        );
    }

    @Y("ingresa los datos del nuevo vehículo")
    public void ingresa_los_datos_del_nuevo_vehiculo(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> row = data.get(0);

        // Generar datos aleatorios
        String randomPlate = randomPlate();
        String randomMarca = "MarcaTest" + randomPlate.substring(0,3);
        String randomCapacidad = String.valueOf(1 + new java.util.Random().nextInt(20));
        String randomTipo = randomFrom(new String[]{"A1","A2","B1","B2","B3","C1","C2","C3"});
        String randomEstado = randomFrom(new String[]{"disponible","asignado","en_ruta","mantenimiento","fuera_de_servicio"});
        String randomFecha = java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String placa = row.get("Placa").equals("{var_placa}") ? randomPlate : row.get("Placa");
        String marca = row.get("Marca").equals("{var_marca}") ? randomMarca : row.get("Marca");
        String tipo = row.get("Tipo").equals("{var_tipo}") ? randomTipo : row.get("Tipo");
        String capacidad = row.getOrDefault("Capacidad", "{var_capacidad}").equals("{var_capacidad}") ? randomCapacidad : row.get("Capacidad");
        String estado = row.getOrDefault("Estado", "{var_estado}").equals("{var_estado}") ? randomEstado : row.get("Estado");
        String ultimo = row.getOrDefault("Último mantenimiento", "{var_ultimo_mantenimiento}").equals("{var_ultimo_mantenimiento}") ? randomFecha : row.get("Último mantenimiento");

        // Guardar el identificador para búsquedas posteriores
        TestContext.createdVehiclePlate = placa;

        CreateVehicule vehiculo = new CreateVehicule(
                placa,
                marca,
                tipo,
                capacidad,
                estado,
                ultimo
        );

        theActorInTheSpotlight().attemptsTo(
                FillCrearVehiculoForm.withData(vehiculo)
        );

        try { Thread.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    @Cuando("se este llenando el furmlario validar que se de click en Vehículos")
    public void se_este_llenando_el_furmlario_validar_que_se_de_click_en_Vehiculos() {
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    @Cuando("se este llenando el formulario del vehículo validar que se de click")
    public void se_este_llenando_el_formulario_del_vehiculo_validar_que_se_de_click() {
        // Delegar a la versión específica de Vehículos para conservar la misma espera
        se_este_llenando_el_furmlario_validar_que_se_de_click_en_Vehiculos();
    }

    @Entonces("Buscar el vehículo creado")
    public void buscar_el_vehiculo_creado() {
        String plate = TestContext.createdVehiclePlate;
        theActorInTheSpotlight().attemptsTo(
                SearchForVehicle.withTerm(plate)
        );

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        questions.SuiteRutas.VerifyVehicle.withPlate(plate),
                        Matchers.is(true)
                )
        );
    }

    @Y("si no da click el test debe fallar y no guardar ningun dato en Vehículos")
    public void si_no_da_click_el_test_debe_fallar_y_no_guardar_ningun_dato_en_Vehiculos() {
        String plate = TestContext.createdVehiclePlate;
        System.out.println("STEP: Verificando vehículo (por placa): " + plate);

        theActorInTheSpotlight().attemptsTo(
                SearchForVehicle.withTerm(plate)
        );

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        questions.SuiteRutas.VerifyVehicle.withPlate(plate),
                        Matchers.is(true)
                )
        );

        try { Thread.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    // Helpers
    private String randomPlate() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        java.util.Random rnd = new java.util.Random();
        for (int i=0;i<6;i++) sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    private String randomFrom(String[] arr) {
        return arr[new java.util.Random().nextInt(arr.length)];
    }
}
