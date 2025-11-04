package tasks.auth;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import tasks.OpenPage;
import userinterface.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

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
                WaitUntil.the(LoginPage.EMAIL_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(email).into(LoginPage.EMAIL_FIELD),
                WaitUntil.the(LoginPage.PASSWORD_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(password).into(LoginPage.PASSWORD_FIELD)
        );
        
        // Esperar un momento antes de hacer clic
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Estrategia 1: Click normal de Serenity
        try {
            actor.attemptsTo(
                    WaitUntil.the(LoginPage.LOGIN_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(LoginPage.LOGIN_BUTTON)
            );
            System.out.println("✅ Login: Click normal exitoso");
        } catch (Exception e1) {
            System.out.println("⚠️ Click normal falló, intentando con JavaScript...");
            
            // Estrategia 2: Click con JavaScript
            try {
                JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
                js.executeScript("document.querySelector('button[type=\"submit\"], button').click();");
                System.out.println("✅ Login: JavaScript click exitoso");
            } catch (Exception e2) {
                System.out.println("⚠️ JavaScript click falló, intentando con ENTER...");
                
                // Estrategia 3: Presionar Enter desde el campo de password
                try {
                    actor.attemptsTo(
                            Enter.theValue(Keys.ENTER.toString()).into(LoginPage.PASSWORD_FIELD)
                    );
                    System.out.println("✅ Login: Enter exitoso");
                } catch (Exception e3) {
                    System.out.println("❌ Todas las estrategias de login fallaron");
                    throw new RuntimeException("No se pudo hacer clic en el botón de login", e3);
                }
            }
        }
        
        // Esperar a que la página cargue después del login
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static Login withCredentials(String email, String password) {
        return instrumented(Login.class, email, password);
    }

    public static Login asAdmin() {
        // Minimal default admin credentials for local test runs — change if needed
        return instrumented(Login.class, "deivgonz777@gmail.com", "Hero77777");
    }

}
