package suites;

import com.protean.legislativetracker.yuna.service.BillServiceTest;
import com.protean.legislativetracker.yuna.service.SessionServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BillServiceTest.class,
        SessionServiceTest.class
})
public class ServiceTests {
}
