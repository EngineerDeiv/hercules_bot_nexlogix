package runners.SuiteRouters;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import runners.CreateVehicleRunner;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreateVehicleRunner.class
})
public class SuiteRouters {
}

