package date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCheck {

	public static void main(String[] args) throws ParseException {
//		String date="2022-07-10T18:30:00.000Z";
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = inputFormat.parse("2022-07-10T18:30:00.000Z");
		String formattedDate = outputFormat.format(date);
		System.out.println(formattedDate); // prints 10-04-2018
	}
}
