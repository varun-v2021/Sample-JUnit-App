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
		System.out.println("fNumber in ArithmaticTest constructor: "+fNumber);
		System.out.println("sNumber in ArithmaticTest constructor: "+sNumber);
		System.out.println("eResult in ArithmaticTest constructor: "+eResult);
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
