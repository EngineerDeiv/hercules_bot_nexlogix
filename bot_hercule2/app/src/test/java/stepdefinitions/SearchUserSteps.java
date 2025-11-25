package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

public class SearchUserSteps {

    @Dado("que el administrador está en la lista de usuarios")
    public void que_el_administrador_esta_en_la_lista_de_usuarios() {
        System.out.println("STEP: El administrador navega a la lista de usuarios");
    }

    @Cuando("busca un usuario con el criterio {string}")
    public void busca_un_usuario_con_el_criterio(String criterio) {
        System.out.println("STEP: Buscando usuario con el criterio: " + criterio);
    }

    @Entonces("el sistema debe mostrar al usuario {string} en los resultados")
    public void el_sistema_debe_mostrar_al_usuario_en_los_resultados(String usuarioEsperado) {
        System.out.println("STEP: Verificando que se muestra el usuario: " + usuarioEsperado);
    }
}
