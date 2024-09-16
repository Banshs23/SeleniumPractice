package firstTestNG;

import org.testng.annotations.Test;

public class testdescription {

	
	@Test(description = "Just for practice")
	public void test1()
	{
		System.out.println("TestNG executed");
	}
	
	@Test(description = "Both methods are same")
	public void test2()
	{
		System.out.println("Try with two methods");
	}
	
}
