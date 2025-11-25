package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

public class UpdateUserSteps {

    @Dado("que el administrador ha buscado al usuario {string}")
    public void que_el_administrador_ha_buscado_al_usuario(String usuario) {
        System.out.println("STEP: El administrador busca previamente al usuario: " + usuario);
    }

    @Cuando("selecciona la opción de editar usuario")
    public void selecciona_la_opcion_de_editar_usuario() {
        System.out.println("STEP: Seleccionando la opción de editar usuario");
    }

    @Cuando("actualiza la información del usuario")
    public void actualiza_la_informacion_del_usuario() {
        System.out.println("STEP: Actualizando los campos del formulario de usuario");
    }

    @Entonces("los datos del usuario {string} deben quedar actualizados en el sistema")
    public void los_datos_del_usuario_deben_quedar_actualizados_en_el_sistema(String usuario) {
        System.out.println("STEP: Verificando que los datos del usuario " + usuario + " se actualizaron correctamente");
    }
}
