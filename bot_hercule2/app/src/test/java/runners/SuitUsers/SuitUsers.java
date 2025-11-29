package runners.SuitUsers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import runners.CreateAreaRunner;
import runners.CreateUserRunner;
import runners.SearchAreaRunner;
import runners.SearchUserRunner;
import runners.auth_nexlogix;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    CreateUserRunner.class,
    SearchUserRunner.class,

})

public class SuitUsers {
}