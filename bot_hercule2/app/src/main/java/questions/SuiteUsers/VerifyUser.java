package questions.SuiteUsers;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VerifyUser implements Question<Boolean> {

    private final String email;

    public VerifyUser(String email) {
        this.email = email;
    }

    public static VerifyUser withEmail(String email) {
        return new VerifyUser(email);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Target USER_IN_LIST = Target.the("Usuario con email " + email)
                .located(By.xpath("//*[contains(text(),'" + email + "')]"));

        return USER_IN_LIST.resolveFor(actor).isVisible();
    }
}
