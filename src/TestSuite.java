import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	//Being called again here as part of Suite as well
   ErrorCollectorExample.class,
   TestJUnit1.class
})

public class TestSuite {

}
