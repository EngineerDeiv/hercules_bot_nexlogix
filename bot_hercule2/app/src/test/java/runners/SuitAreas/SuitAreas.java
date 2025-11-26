package runners.SuitAreas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import runners.CreateAreaRunner;
import runners.auth_nexlogix;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    auth_nexlogix.class,
    CreateAreaRunner.class,
    runners.SearchAreaRunner.class
})
public class SuitAreas {
}
