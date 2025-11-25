package runners.SuitUsers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import runners.auth_nexlogix;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    auth_nexlogix.class
})

public class SuitUsers {
}
