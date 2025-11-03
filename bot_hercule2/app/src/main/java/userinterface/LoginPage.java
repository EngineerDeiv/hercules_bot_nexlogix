package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    
    public static final Target EMAIL_FIELD = Target.the("Campo de email")
            .located(By.id("email"));
    
    public static final Target PASSWORD_FIELD = Target.the("Campo de contraseña")
            .located(By.id("password"));
    
    public static final Target LOGIN_BUTTON = Target.the("Botón de iniciar sesión")
            .located(By.cssSelector(".login-btn"));
    
    public static final Target DASHBOARD_INDICATOR = Target.the("Indicador del panel de administración")
            .located(By.xpath("//h1[contains(text(), 'Dashboard') or contains(text(), 'Panel')] | //div[contains(@class, 'dashboard')]"));
}