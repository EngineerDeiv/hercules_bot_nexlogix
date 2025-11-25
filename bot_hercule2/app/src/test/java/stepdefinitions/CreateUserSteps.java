package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;

public class CreateUserSteps {

    @Dado("que el administrador ha iniciado sesión y está en el panel principal")
    public void que_el_administrador_ha_iniciado_sesion_y_esta_en_el_panel_principal() {
        // Aquí iría la lógica de login o verificación de sesión
        System.out.println("STEP: El administrador inicia sesión y va al panel principal");
    }

    @Cuando("navega a la sección de creación de usuarios")
    public void navega_a_la_seccion_de_creacion_de_usuarios() {
        System.out.println("STEP: Navegando a la sección de creación de usuarios");
    }

    @Cuando("ingresa los datos del nuevo usuario")
    public void ingresa_los_datos_del_nuevo_usuario(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String nombre = row.get("Nombre");
            String email = row.get("Email");
            String rol = row.get("Rol");
            System.out.println("STEP: Ingresando datos del usuario - Nombre: " + nombre + ", Email: " + email + ", Rol: " + rol);
        }
    }

    @Entonces("el usuario debe ser creado exitosamente y aparecer en la lista")
    public void el_usuario_debe_ser_creado_exitosamente_y_aparecer_en_la_lista() {
        System.out.println("STEP: Verificando que el usuario fue creado y aparece en la lista");
    }
}
