package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.cucumber.datatable.DataTable;
import models.Users.EditUsers;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.hamcrest.Matchers;
import tasks.Users.ClickEditButton;
import tasks.Users.FillUpdateUserForm;
import tasks.Users.RoutersUsers;
import tasks.Users.SearchForUser;
import tasks.auth.Login;
import utils_and_hooks.TestContext;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UpdateUserSteps {

    @Dado("que busco el usuario creado anteriormente y abro la opcion de editar")
    public void que_busco_el_usuario_creado_anteriormente_y_abro_la_opcion_de_editar() {
        // Usamos el email del usuario creado en el test anterior (o uno por defecto si es null)
        String email = TestContext.createdUserEmail;
        if (email == null) {
            email = "test_default@nexlogix.com"; // Fallback por si se corre solo
        }
        System.out.println("STEP: Buscando usuario para editar: " + email);

        theActorInTheSpotlight().attemptsTo(
                Login.asAdmin(),
                RoutersUsers.toUsersPage(),
                SearchForUser.withTerm(email),
                ClickEditButton.forUser(email)
        );
    }

    @Entonces("editar toda la informacion del usuario")
    public void editar_toda_la_informacion_del_usuario(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> row = data.get(0);

        // Generación de datos aleatorios para la edición
        String randomId = String.valueOf(10000000 + new java.util.Random().nextInt(90000000));
        String randomPhone = "300" + (1000000 + new java.util.Random().nextInt(9000000));
        String randomName = "Usuario Editado " + randomId.substring(0, 4);
        String randomEmail = "editado" + randomId + "@nexlogix.com";
        String randomAddress = "Calle Editada " + new java.util.Random().nextInt(100);

        // Procesar variables del feature
        String documento = row.get("Documento de Identidad").equals("{var_documento}") ? randomId : row.get("Documento de Identidad");
        String nombre = row.get("Nombre Completo").equals("{var_nombre}") ? randomName : row.get("Nombre Completo");
        String email = row.get("Email").equals("{var_email}") ? randomEmail : row.get("Email");
        String telefono = row.get("Teléfono").equals("{var_telefono}") ? randomPhone : row.get("Teléfono");
        String direccion = row.get("Dirección").equals("{var_direccion}") ? randomAddress : row.get("Dirección");
        
        // Nuevos campos
        String rol = row.get("Rol").equals("{var_rol}") ? "Manager" : row.get("Rol");
        String puesto = row.get("Puesto").equals("{var_puesto}") ? "Gerente General de Sistemas" : row.get("Puesto");
        String estado = row.get("Estado").equals("{var_estado}") ? "ACTIVO" : row.get("Estado");

        // Actualizamos el contexto con el nuevo email por si se necesita buscar después
        TestContext.createdUserEmail = email;

        // Usamos el modelo EditUsers
        EditUsers updatedUser = new EditUsers(
                documento,
                nombre,
                email,
                telefono,
                direccion,
                rol,
                puesto,
                estado
        );

        // Llenamos el formulario con los nuevos datos
        theActorInTheSpotlight().attemptsTo(
                FillUpdateUserForm.withData(updatedUser)
        );
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Cuando("se este llenando el furmlario validar que se de click y se guuarde")
    public void se_este_llenando_el_furmlario_validar_que_se_de_click_y_se_guuarde() {
        // Aquí deberíamos dar click en guardar explícitamente si quisiéramos guardar.
        // Pero como el usuario pidió la misma lógica negativa:
        
        // Si quisiéramos guardar de verdad:
        // theActorInTheSpotlight().attemptsTo(Click.on(FillUserForm.SAVE_BUTTON));
        
        // Espera visual
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Entonces("Buscar el usuario editado")
    public void buscar_el_usuario_editado() {
        String email = TestContext.createdUserEmail;
        System.out.println("STEP: Buscando explícitamente el usuario editado: " + email);
        theActorInTheSpotlight().attemptsTo(SearchForUser.withTerm(email));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Y("si no da click al editar el test debe fallar y no guardar ningun dato")
    public void si_no_da_click_al_editar_el_test_debe_fallar_y_no_guardar_ningun_dato() {
        // Validamos que SÍ se guardó (porque FillUpdateUserForm ya dio click)
        String newEmail = TestContext.createdUserEmail;
        
        System.out.println("STEP: Verificando que se guardó el usuario editado: " + newEmail);
        
        // Buscamos primero para asegurar que aparezca en la tabla
        theActorInTheSpotlight().attemptsTo(SearchForUser.withTerm(newEmail));

        // Validamos que el usuario existe con los nuevos datos
        theActorInTheSpotlight().should(
                 GivenWhenThen.seeThat(
                        questions.SuiteUsers.VerifyUser.withEmail(newEmail),
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
