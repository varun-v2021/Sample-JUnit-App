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
