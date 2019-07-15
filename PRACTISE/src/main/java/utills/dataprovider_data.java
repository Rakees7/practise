package utills;

import org.testng.annotations.DataProvider;

public class dataprovider_data
{

	@DataProvider(name="excellvalues")
	public static Object[][] data_read() throws Exception
	{
		Object[][] data=excellutills.excel_data();
		return data;
	}
	
	
	
}
