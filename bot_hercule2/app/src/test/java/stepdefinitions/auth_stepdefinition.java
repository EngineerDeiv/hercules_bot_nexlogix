package stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import utils_and_hooks.DefaultURL;

public class auth_stepdefinition {

    private WebDriver driver;
    private WebDriverWait wait;

    @Dado("que el usuario navega a la página web de Nexlogix y se encuentra en la pantalla de inicio de sesión")
    public void que_el_usuario_navega_a_la_página_web_de_nexlogix_y_se_encuentra_en_la_pantalla_de_inicio_de_sesión() {
        System.out.println("Abriendo navegador Chrome...");
        
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(13));
        
        System.out.println("Navegando a: " + DefaultURL.URL);
        driver.get(DefaultURL.URL);
    }
    
    @Cuando("ingrese las siguientes credenciales:")
    public void ingrese_las_siguientes_credenciales(io.cucumber.datatable.DataTable dataTable) {
        System.out.println("Ingresando credenciales...");
        
        // Obtener credenciales de la tabla
        var rows = dataTable.asMaps(String.class, String.class);
        String email = rows.get(0).get("Email");
        String password = rows.get(0).get("Password");
        
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        
        // Buscar y llenar campos
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector(".login-btn"));
        
        emailField.clear();
        emailField.sendKeys(email);
        
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
    }
    
    @Entonces("el sistema deberá autenticarlo correctamente y mostrar el panel de administración")
    public void el_sistema_deberá_autenticarlo_correctamente_y_mostrar_el_panel_de_administración() {
        System.out.println("Verificando que el login fue exitoso...");
        
        // Esperar un poco para ver el resultado
        try {
            Thread.sleep(6000);
            System.out.println(driver.getCurrentUrl());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
