package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.datatable.DataTable;
import models.Users.createUser;
import net.serenitybdd.screenplay.actors.OnStage;
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
        // Usamos la tarea de Login existente para autenticarnos como admin
        theActorInTheSpotlight().attemptsTo(
                Login.asAdmin()
        );
    }

    @Cuando("navega a la sección de creación de usuarios")
    public void navega_a_la_seccion_de_creacion_de_usuarios() {
        // Navegamos al menú de usuarios y luego damos clic en "Crear usuario"
        theActorInTheSpotlight().attemptsTo(
                RoutersUsers.toUsersPage(),
                NavUsers.clickCreateUser()
        );
    }

    @Cuando("ingresa los datos del nuevo usuario")
    public void ingresa_los_datos_del_nuevo_usuario(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> row = data.get(0); // Tomamos la primera fila

        // Creamos el modelo con los datos de la tabla (y algunos defaults para los que no vienen)
        createUser newUser = new createUser(
                "1004541322", // Documento default o aleatorio
                row.get("Nombre"),
                row.get("Email"),
                "3001234567", // Teléfono default
                "Calle Falsa 123", // Dirección default
                "Password123", // Contraseña default
                row.get("Rol"),
                "Gerente General de Sistemas", // Puesto default (ajustar según necesidad)
                "ACTIVO" // Estado default
        );

        // Ejecutamos la tarea de llenar el formulario
        theActorInTheSpotlight().attemptsTo(
                FillUserForm.withData(newUser)
        );
    }

    @Entonces("el usuario debe ser creado exitosamente y aparecer en la lista")
    public void el_usuario_debe_ser_creado_exitosamente_y_aparecer_en_la_lista() {
        // Aquí iría la validación (Question), por ahora dejamos el log
        System.out.println("STEP: Verificando que el usuario fue creado y aparece en la lista");
        try {
            Thread.sleep(12000); // Espera de 12 segundos solicitada
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
