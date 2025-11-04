package tasks.auth;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import tasks.OpenPage;
import userinterface.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private final String email;
    private final String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Open base URL and perform login
        actor.attemptsTo(
                OpenPage.toNexLogix(),
                Enter.theValue(email).into(LoginPage.EMAIL_FIELD),
                Enter.theValue(password).into(LoginPage.PASSWORD_FIELD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }

    public static Login withCredentials(String email, String password) {
        return instrumented(Login.class, email, password);
    }

    public static Login asAdmin() {
        // Minimal default admin credentials for local test runs — change if needed
        return instrumented(Login.class, "deivgonz777@gmail.com", "Hero77777");
    }

}
