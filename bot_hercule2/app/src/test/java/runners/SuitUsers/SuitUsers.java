package runners.SuitUsers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import runners.CreateAreaRunner;
import runners.CreateUserRunner;
import runners.SearchAreaRunner;
import runners.SearchUserRunner;
import runners.UpdateUserRunner;
import runners.BlockUserRunner;
import runners.DeleteUserRunner;
import runners.auth_nexlogix;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    CreateUserRunner.class,
    SearchUserRunner.class,
    UpdateUserRunner.class,
    BlockUserRunner.class,
    DeleteUserRunner.class
})

public class SuitUsers {
}