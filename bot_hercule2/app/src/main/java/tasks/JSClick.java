package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;

public class JSClick implements Task {
    private final Target target;

    public JSClick(Target target) {
        this.target = target;
    }

    public static JSClick on(Target target) {
        return new JSClick(target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
        js.executeScript("arguments[0].click();", target.resolveFor(actor).getWrappedElement());
    }
}

