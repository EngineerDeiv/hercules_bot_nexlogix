package runners.SuitUsers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import runners.CreateUserRunner;
import runners.auth_nexlogix;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    auth_nexlogix.class,
    CreateUserRunner.class,
    runners.SearchUserRunner.class
})
public class SuitUsers {
}
