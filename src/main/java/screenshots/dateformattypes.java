package screenshots;

import java.text.SimpleDateFormat;
import java.util.Date;

import helper.Utility;

public class dateformattypes {

	public static void main(String[] args) {

		SimpleDateFormat formatter = new SimpleDateFormat("d_MM_yyyy_hh_mm_ss");
		Date today = new Date();
		String dateoutput = formatter.format(today);
		System.out.println(dateoutput);
		
		SimpleDateFormat formatters = new SimpleDateFormat("d_MM_yyyy_hh_mm_ss a,z");
		Date todays = new Date();
		String dateoutputs = formatters.format(todays);
		System.out.println(dateoutputs);
		
		String cd=Utility.customdateFormat("EEE, MMM d, yyy");
		System.out.println(cd);
		
		Utility.defaultdateFormat();
		//System.out.println(dd);
	}
}
