package tasks.Users;

import models.Users.createUser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillUserForm implements Task {

    private final createUser user;

    // Targets PROVISIONALES (Verificar con el HTML real)
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
            
    public static final Target PASSWORD_FIELD = Target.the("Campo Contraseña")
            .located(By.name("contrasena")); 
            
    public static final Target SAVE_BUTTON = Target.the("Botón Guardar")
            .located(By.xpath("//button[normalize-space()='Guardar']"));

    public FillUserForm(createUser user) {
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
                Enter.theValue(user.getContrasena()).into(PASSWORD_FIELD),

                // listas desplegables
                ListUtil.withValues(user.getRol(), user.getPuesto(), user.getEstado()),

                // Guardar
                Click.on(SAVE_BUTTON)
        );
    }

    public static FillUserForm withData(createUser user) {
        return instrumented(FillUserForm.class, user);
    }
}
