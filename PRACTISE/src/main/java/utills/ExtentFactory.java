package utills;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory 
{
	
	public static  ExtentReports Instance()
	{
		ExtentReports extent;
		String path="D:\\rakesh\\report.html";
		extent=new ExtentReports(path, false);
		return extent;
	}
	

}
