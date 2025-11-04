package tasks.auth;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import tasks.OpenPage;
import userinterface.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * VERSIÓN ALTERNATIVA CON TAB
 * Si la versión principal no funciona, usa esta
 */
public class LoginWithTab implements Task {

    private final String email;
    private final String password;

    public LoginWithTab(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Open base URL and perform login
        actor.attemptsTo(
                OpenPage.toNexLogix(),
                WaitUntil.the(LoginPage.EMAIL_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(email).into(LoginPage.EMAIL_FIELD)
        );
        
        // Presionar TAB para ir al siguiente campo
        actor.attemptsTo(
                SendKeys.of(Keys.TAB).into(LoginPage.EMAIL_FIELD)
        );
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Ingresar password
        actor.attemptsTo(
                Enter.theValue(password).into(LoginPage.PASSWORD_FIELD)
        );
        
        // Presionar TAB para ir al botón
        actor.attemptsTo(
                SendKeys.of(Keys.TAB).into(LoginPage.PASSWORD_FIELD)
        );
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Presionar ENTER o SPACE para activar el botón enfocado
        try {
            JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
            js.executeScript("document.activeElement.click();");
            System.out.println("✅ Login con TAB: Click en elemento enfocado exitoso");
        } catch (Exception e) {
            System.out.println("⚠️ Intentando ENTER desde el campo password...");
            actor.attemptsTo(
                    SendKeys.of(Keys.ENTER).into(LoginPage.PASSWORD_FIELD)
            );
        }
        
        // Esperar a que la página cargue después del login
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static LoginWithTab withCredentials(String email, String password) {
        return instrumented(LoginWithTab.class, email, password);
    }

    public static LoginWithTab asAdmin() {
        return instrumented(LoginWithTab.class, "deivgonz777@gmail.com", "Hero77777");
    }

}
