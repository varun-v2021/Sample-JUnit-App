# Sample-JUnit-App
/******************************************************************************************************************************/

public class Arithmatic {
	public int sum(int a, int b){
		return a + b;
	}
}

/******************************************************************************************************************************/
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ArithmaticTest {
	private int firstNumber;
	private int secondNumber;
	private int expectedResult;
	private Arithmatic arithmatic;
	
	public ArithmaticTest(int fNumber, int sNumber, int eResult){
		//comment to check git rebase operation for changes in repo
		super();
		this.firstNumber = fNumber;
		this.secondNumber = sNumber;
		this.expectedResult = eResult;
	}
	
	@Before
	public void initialize(){
		//comment as part of changes in a local feature branch
		arithmatic = new Arithmatic();
	}
	
	@Parameterized.Parameters
	public static Collection input(){
			return Arrays.asList(new Object[][]{{1,2,3},{11,22,33},{100,9,109},{111,222,333}});
	}
	
	@Test
	public void testArithmaticTest(){
		System.out.println("Sum of Numbers: "+expectedResult);
		assertEquals(expectedResult,arithmatic.sum(firstNumber, secondNumber));
	}
}

/******************************************************************************************************************************/
import org.junit.Rule;		
import org.junit.Test;		
import org.junit.rules.ErrorCollector;

import junit.framework.Assert;
import junit.framework.TestResult;		

public class ErrorCollectorExample {
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Test
	public void example(){
		 //Throwable is parent of Error and Exception
		collector.addError(new Throwable("There is a error in first line"));
		collector.addError(new Throwable("There is a error in second line"));
		System.out.println("Hello");
		try{
			Assert.assertTrue("A" == "B"); //assertionFailure here
		}catch(Throwable t){
			collector.addError(t);
			
			/*Note: addFailure and addError are two separate methods*/
			//TestResult result = new TestResult();
			//result.addFailure(null, null);
		}
		System.out.println("World");
	}
}

/******************************************************************************************************************************/
import org.junit.After;
import org.junit.AfterClass;

import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Ignore;
import org.junit.Test;

public class ExecutionProcedureJUnit {
	
   //execute only once, in the starting 
   @BeforeClass
   public static void beforeClass() {
      System.out.println("in before class");
   }

   //execute only once, in the end
   @AfterClass
   public static void  afterClass() {
      System.out.println("in after class");
   }

   //execute for each test, before executing test
   @Before
   public void before() {
      System.out.println("in before");
   }
	
   //execute for each test, after executing test
   @After
   public void after() {
      System.out.println("in after");
   }
	
   //test case 1
   @Test
   public void testCase1() {
      System.out.println("in test case 1");
   }

   //test case 2
   @Test
   public void testCase2() {
      System.out.println("in test case 2");
   }
}
/******************************************************************************************************************************/

public class JUnitMessage {				

    private String message;					

    public JUnitMessage(String message) {					
        this.message = message;							
    }		
    		
public String printMessage(){		
    		
    System.out.println(message);					
    		
    return message;					
}    		
    		
public String printHiMessage(){		
    		
    message="Hi!"+ message;							
    		
    System.out.println(message);					
    		
    return message;					
}    		

public void methodThrowingError(){
	System.out.println(message);
	int i = 1/0;
}
    		
}
/******************************************************************************************************************************/
public class PrimeNumberChecker {
   public Boolean validate(final Integer primeNumber) {
      for (int i = 2; i < (primeNumber / 2); i++) {
         if (primeNumber % i == 0) {
            return false;
         }
      }
      return true;
   }
}
/******************************************************************************************************************************/
import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PrimeNumberCheckerTest {
   private Integer inputNumber;
   private Boolean expectedResult;
   private PrimeNumberChecker primeNumberChecker;

   @Before
   public void initialize() {
      primeNumberChecker = new PrimeNumberChecker();
   }

   // Each parameter should be placed as an argument here
   // Every time runner triggers, it will pass the arguments
   // from parameters we defined in primeNumbers() method
	
   public PrimeNumberCheckerTest(Integer inputNumber, Boolean expectedResult) {
      this.inputNumber = inputNumber;
      this.expectedResult = expectedResult;
   }

   @Parameterized.Parameters
   public static Collection primeNumbers() {
      return Arrays.asList(new Object[][] {
         { 2, true },
         { 6, false },
         { 19, true },
         { 22, false },
         { 23, true }
      });
   }

   // This test will run 4 times since we have 5 parameters defined
   @Test
   public void testPrimeNumberChecker() {
      System.out.println("Parameterized Number is : " + inputNumber);
      assertEquals(expectedResult, 
      primeNumberChecker.validate(inputNumber));
   }
}
/******************************************************************************************************************************/
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

//@Ignore	//ignore all the test functions
public class TestJUnit {
	
	public String message = "default message";
	
	JUnitMessage junitMessage = new JUnitMessage(message);
	
	@Test
	public void testSetup() {
		String str = "I am done with Junit setup";

		assertEquals("I am done with Junit setup", str);

		//Fails as both the string are different and comparing them will return not equal
		//assertEquals(str, junitMessage.printMessage());
	}
	
	@Test		
    public void testJUnitHiMessage() {					
        message="Hi!" +message;							
        System.out.println("Junit Hi Message is printing ");					
        assertEquals(message, junitMessage.printHiMessage());					

    }	
	
	//@Ignore("not yet ready , Please ignore.")
    @Test		
    public void testJUnitMessage() {					

        System.out.println("Junit Message is printing ");					
        assertEquals(message, junitMessage.printMessage());					

    }
    
    //NOTE: This will fail as methodThrowingError is throwing ArithmeticException and expected is ArrayIndexOutOfBoundsException
    //@Test(expected = ArrayIndexOutOfBoundsException.class)
    
    @Test(expected = ArithmeticException.class)  
    public void testJUnitErrorExpectation(){
    	System.out.println("Junit message is printing");
    	junitMessage.methodThrowingError();
    }
}

/******************************************************************************************************************************/
import org.junit.Test;

import junit.framework.AssertionFailedError;
import junit.framework.TestResult;

public class TestJUnit1 extends TestResult {
	// add the error
	public void addError(Test test, Throwable t) {
		super.addError((junit.framework.Test) test, t);
	}

	// add the failure
	public void addFailure(Test test, AssertionFailedError t) {
		super.addFailure((junit.framework.Test) test, t);
	}

	@Test
	public void testAdd() {
		// add any test
	}

	// Marks that the test run should stop.
	public void stop() {
		System.out.println("stop the test here");
	}
}

/******************************************************************************************************************************/

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Result result = JUnitCore.runClasses(TestJUnit.class);
		for(Failure failure: result.getFailures()){
			 System.out.println(failure.toString());
		}
		System.out.println("Result=="+result.wasSuccessful());
		runNewTestClass();
		
	}
	
	public static void runNewTestClass(){
		Result result = JUnitCore.runClasses(TestJUnit1.class);
		for(Failure failure: result.getFailures()){
			 System.out.println(failure.toString());
		}
		System.out.println("New Result=="+result.wasSuccessful());
		
		result = JUnitCore.runClasses(ExecutionProcedureJUnit.class);
		for(Failure failure: result.getFailures()){
			 System.out.println(failure.toString());
		}
		System.out.println("New Result 1=="+result.wasSuccessful());
		//comment to learn git rebasing, merging between master and other branches	
		result = JUnitCore.runClasses(TestSuite.class);
		
	}
}

/******************************************************************************************************************************/
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

/******************************************************************************************************************************/
hamcrest-core-1.3.jar
junit-4.12.jar
