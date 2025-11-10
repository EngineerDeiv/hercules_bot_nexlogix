package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        // Ensure there's an actor in the spotlight for steps that call theActorInTheSpotlight()
        OnStage.theActorCalled("admin");
    }

    @After
    public void holdBrowserIfDebug() {
        // If DEBUG_HOLD_MS is set (env var) or system property 'debug.hold.ms' is provided,
        // pause the test after scenario completion to keep the browser open for inspection.
        String holdMs = System.getenv("DEBUG_HOLD_MS");
        if (holdMs == null || holdMs.isEmpty()) {
            holdMs = System.getProperty("debug.hold.ms");
        }
        // If no value provided, default to 0 ms (no hold). Set DEBUG_HOLD_MS env or system property to enable.
        if (holdMs == null || holdMs.isEmpty()) {
            holdMs = "0";
        }
        if (holdMs != null && !holdMs.isEmpty()) {
            try {
                long ms = Long.parseLong(holdMs);
                if (ms > 0) {
                    System.out.println("Debug hold active - keeping browser open for " + ms + " ms");
                    Thread.sleep(ms);
                }
            } catch (NumberFormatException e) {
                System.out.println("DEBUG_HOLD_MS is not a valid number: " + holdMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
