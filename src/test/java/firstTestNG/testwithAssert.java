package firstTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testwithAssert {

	//Assert is used for validating actual and expected results
	
	@Test
	public void login() {
		Assert.assertEquals(12, 12);
	}
	
	@Test
	public void testassert()
	{
		String msg="Amazon forest is amazing";
		Assert.assertTrue(msg.contains("Amazons"), "Amazon");
	}
	
	@Test
	public void testtwo()
	{
		Assert.assertEquals("Test", "Testing", "Expected is Testing");
	}
	
}
