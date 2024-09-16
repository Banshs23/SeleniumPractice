package firstTestNG;

import org.testng.annotations.Test;

public class testwithPriority {

	//Without priority test executes in Aplhabetical order
	//With Priority test executes with lowest priority first. By default priority is 0.
	
	@Test(priority = 1)
	public void login() {
		System.out.println("User Login");
	}
	
	@Test(priority = 2)
	public void addtoCart() {
		System.out.println("User Adds Item to cart");
	}
	
	@Test(priority = 3)
	public void makePayment() {
		System.out.println("User Makes Payment");
	}
	
	@Test(priority = 4)
	public void logoutApp() {
		System.out.println("User Logged out successfully");
	}
	
	
}
