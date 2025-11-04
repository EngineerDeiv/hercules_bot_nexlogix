package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    
    public static final Target EMAIL_FIELD = Target.the("Campo de email")
            .located(By.xpath("//input[@type='email' or @type='text' or contains(@placeholder,'email') or contains(@placeholder,'correo')]"));
    
    public static final Target PASSWORD_FIELD = Target.the("Campo de contraseña")
            .located(By.xpath("//input[@type='password']"));
    
    // Múltiples estrategias para encontrar el botón de login
    public static final Target LOGIN_BUTTON = Target.the("Botón de iniciar sesión")
            .located(By.xpath("//button[contains(., 'Iniciar') or contains(., 'INICIAR') or contains(., 'Login') or contains(., 'LOGIN')] | //button[@type='submit'] | //input[@type='submit']"));
    
    public static final Target DASHBOARD_INDICATOR = Target.the("Indicador del panel de administración")
            .located(By.xpath("//h1[contains(text(), 'Dashboard') or contains(text(), 'Panel')] | //div[contains(@class, 'dashboard')]"));
}