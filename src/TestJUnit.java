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
