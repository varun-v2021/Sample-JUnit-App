
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
		runNewTestClass1();
		
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
	
	public static void runNewTestClass1(){
		Result result = JUnitCore.runClasses(ArithmaticTest.class);
		for(Failure failure: result.getFailures()){
			 System.out.println(failure.toString());
		}
		System.out.println("New Result=="+result.wasSuccessful());
	}
}
