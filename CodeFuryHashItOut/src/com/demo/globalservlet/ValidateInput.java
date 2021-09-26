package com.demo.globalservlet;
import java.util.Date;

public class ValidateInput {

	
	public static boolean validateStartDateOfAuction(Date startDate) {
		Date d1 = new Date();
		if (startDate.compareTo(d1) >= 0)
			return true;
		else
			return false;
	}

	public static boolean validateEndDateOfAuction(Date startDate, Date endDate) {
		if (endDate.compareTo(startDate) >= 0 && endDate.compareTo(startDate) <= 3)
			return true;
		else
			return false;
	}

	public static boolean validateMinPrice(double minPrice, double actualPrice) {
		if(minPrice<=actualPrice) return true;
		return false;
	}
}
