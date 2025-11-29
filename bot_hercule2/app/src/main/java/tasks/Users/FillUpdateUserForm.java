package tasks.Users;

import models.Users.EditUsers;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillUpdateUserForm implements Task {

    private final EditUsers user;

    public static final Target DOCUMENT_FIELD = Target.the("Campo Documento de Identidad")
            .located(By.name("documentoIdentidad")); 
            
    public static final Target NAME_FIELD = Target.the("Campo Nombre Completo")
            .located(By.name("nombreCompleto")); 
            
    public static final Target EMAIL_FIELD = Target.the("Campo Email")
            .located(By.name("email")); 
            
    public static final Target PHONE_FIELD = Target.the("Campo Teléfono")
            .located(By.name("numContacto")); 
            
    public static final Target ADDRESS_FIELD = Target.the("Campo Dirección")
            .located(By.name("direccionResidencia")); 
            
    // No Password field in Edit Form
            
    public static final Target SAVE_BUTTON = Target.the("Botón Guardar")
            .located(By.xpath("//button[normalize-space()='Guardar']"));

    public FillUpdateUserForm(EditUsers user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getDocumentoIdentidad()).into(DOCUMENT_FIELD),
                Enter.theValue(user.getNombreCompleto()).into(NAME_FIELD),
                Enter.theValue(user.getEmail()).into(EMAIL_FIELD),
                Enter.theValue(user.getTelefono()).into(PHONE_FIELD),
                Enter.theValue(user.getDireccion()).into(ADDRESS_FIELD),

                // listas desplegables (Rol, Puesto, Estado)
                ListUtil.withValues(user.getRol(), user.getPuesto(), user.getEstado())

                // Nota: El click en guardar se maneja fuera o aquí dependiendo de la lógica.
                // En el CreateUser se decidió dejarlo dentro.
                // Aquí también lo dejaremos dentro para consistencia, 
                // pero el StepDefinition puede decidir no llamar a este Task si no quiere guardar,
                // o el StepDefinition maneja la lógica de "si no da click".
                // El usuario pidió: "Cuando se este llenando el furmlario validar que se de click y se guuarde"
                // Así que lo incluimos.
                , Click.on(SAVE_BUTTON)
        );
    }

    public static FillUpdateUserForm withData(EditUsers user) {
        return instrumented(FillUpdateUserForm.class, user);
    }
}
