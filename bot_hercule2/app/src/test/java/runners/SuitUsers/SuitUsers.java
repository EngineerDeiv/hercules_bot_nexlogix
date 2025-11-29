package runners.SuitUsers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import runners.CreateAreaRunner;
import runners.CreateUserRunner;
import runners.auth_nexlogix;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    CreateUserRunner.class
    // runners.SearchUserRunner.class,
    //CreateAreaRunner.class,
    // runners.SearchAreaRunner.class
})

public class SuitUsers {
}