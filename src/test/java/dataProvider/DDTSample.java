package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTSample {

	@Test(dataProvider = "login")
	public void fetchData(String fname, String lname) {
		System.out.println("======================");
		System.out.println(fname);
		System.out.println(lname);
		System.out.println("======================");
	}

	@DataProvider(name = "login")
	public Object[][] testDataProvider() {
		
		Object[][] arr = new Object[2][2];

		arr[0][0] = "Yash";
		arr[0][1] = "Ashes";
		
		arr[1][0] = "Mohan";
		arr[1][1] = "Bansh";
		
		return arr;
	}
}
