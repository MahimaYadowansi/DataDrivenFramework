package rough;

import java.util.Date;

public class TestTimeStamp {
	public static void main(String[] args) {
		//time stamp so that it will show screenshot of diff page with their diff name
		Date d=new Date();
		
		System.out.println(d);
		 
		//convert date into string
		//date should be the name of screenshot, for that replace ':' and 'spaces' into '_'
		 String ScreenshotName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		System.out.println(ScreenshotName);
		
	}

	
}
