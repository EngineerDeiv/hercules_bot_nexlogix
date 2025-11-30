package questions.SuiteRutas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VerifyVehicle implements Question<Boolean> {

    private final String plate;

    public VerifyVehicle(String plate) {
        this.plate = plate;
    }

    public static VerifyVehicle withPlate(String plate) {
        return new VerifyVehicle(plate);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Target VEHICLE_IN_LIST = Target.the("Vehículo con placa " + plate)
                .located(By.xpath("//*[contains(text(),'" + plate + "')]") );

        return VEHICLE_IN_LIST.resolveFor(actor).isVisible();
    }
}
