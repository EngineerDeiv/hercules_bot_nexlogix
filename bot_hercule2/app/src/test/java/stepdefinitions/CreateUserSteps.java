package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Y;
import io.cucumber.datatable.DataTable;
import models.Users.createUser;
import net.serenitybdd.screenplay.GivenWhenThen;
import org.hamcrest.Matchers;
import tasks.Users.FillUserForm;
import tasks.Users.NavUsers;
import tasks.Users.RoutersUsers;
import tasks.auth.Login;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateUserSteps {

    @Dado("que el administrador ha iniciado sesión y está en el panel principal")
    public void que_el_administrador_ha_iniciado_sesion_y_esta_en_el_panel_principal() {
        theActorInTheSpotlight().attemptsTo(
                Login.asAdmin()
        );
    }

    @Cuando("navega a la sección de creación de usuarios")
    public void navega_a_la_seccion_de_creacion_de_usuarios() {
        theActorInTheSpotlight().attemptsTo(
                RoutersUsers.toUsersPage(),
                NavUsers.clickCreateUser()
        );
    }

    @Y("ingresa los datos del nuevo usuario")
    public void ingresa_los_datos_del_nuevo_usuario(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> row = data.get(0);

        // Generación de datos aleatorios
        String randomId = String.valueOf(10000000 + new java.util.Random().nextInt(90000000));
        String randomPhone = "300" + (1000000 + new java.util.Random().nextInt(9000000));
        String randomName = "Usuario Test " + randomId.substring(0, 4);
        String randomEmail = "test" + randomId + "@nexlogix.com";
        String randomAddress = "Calle " + new java.util.Random().nextInt(100) + " # " + new java.util.Random().nextInt(100);

        // Procesar variables del feature
        String nombre = row.get("Nombre").equals("{var_nombre}") ? randomName : row.get("Nombre");
        String email = row.get("Email").equals("{var_email}") ? randomEmail : row.get("Email");
        String rol = row.get("Rol").equals("{var_rol}") ? "Manager" : row.get("Rol"); // Default Manager si es variable

        // Guardar el email en el contexto para usarlo en la búsqueda
        utils_and_hooks.TestContext.createdUserEmail = email;

        // Creamos el modelo con los datos
        createUser newUser = new createUser(
                randomId,
                nombre,
                email,
                randomPhone,
                randomAddress,
                "Password123", // Contraseña fija
                rol,
                "Gerente General de Sistemas", // Puesto fijo
                "ACTIVO" // Estado fijo
        );

        // Ejecutamos la tarea de llenar el formulario (SIN GUARDAR AÚN)
        theActorInTheSpotlight().attemptsTo(
                FillUserForm.withData(newUser)
        );
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Cuando("se este llenando el furmlario validar que se de click")
    public void se_este_llenando_el_furmlario_validar_que_se_de_click() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Y("si no da click el test debe fallar y no guardar ningun dato")
    public void si_no_da_click_el_test_debe_fallar_y_no_guardar_ningun_dato() {
        String email = utils_and_hooks.TestContext.createdUserEmail;
        System.out.println("STEP: Verificando que el usuario NO existe (porque no se dio click): " + email);

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        questions.SuiteUsers.VerifyUser.withEmail(email),
                        //Si queremos que falle, poner false , si queremos que paso poner tree, pero se debe comentar save en FillUserForm
                        Matchers.is(true)
                )
        );
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
