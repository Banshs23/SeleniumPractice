package dataProvider;

import org.testng.annotations.Test;

public class UsingCDP {

	@Test(dataProvider = "login", dataProviderClass = CustomDataProvider.class)
	public void fetchData(String fname, String lname, String Cname) {
		System.out.println("======================");
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(Cname);
		System.out.println("======================");
	}
}
