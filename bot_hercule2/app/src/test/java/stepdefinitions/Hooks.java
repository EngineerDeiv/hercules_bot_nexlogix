package stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        // Ensure there's an actor in the spotlight for steps that call theActorInTheSpotlight()
        OnStage.theActorCalled("admin");
    }

}
