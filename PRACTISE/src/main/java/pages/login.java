package pages;

import java.util.logging.Logger;

import basicFunctions.Common;

public class login extends Common
{
	
	boolean b;
	
	public boolean verification_of_all_loginfields()
	{
		element_presence("xpath", "//*[@id='Table_01']/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/input");
		element_presence("xpath", "//*[@id='Table_01']/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/input");
		element_presence("xpath", "//*[@id='Table_01']/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[1]/input");
		element_presence("xpath", "//*[@id='Table_01']/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[2]/input");
		return true;
	}
	
	public void login_values(String UN,String PW)
	{
		send_values("name", "txtUserName", UN);
		send_values("name", "txtPassword", PW);
		click("name", "Submit");
	}
	
	public boolean verify_homepage_abovefeilds(String UN)
	{
		verify_text("xpath", "//*[@id='option-menu']/li[1]", "Welcome "+UN);
		element_presence("xpath", "//*[@id='option-menu']/li[3]/a");
		element_presence("xpath", "//*[@id='option-menu']/li[2]/a");
		return true;
	}
	
	public void logout()
	{
		click("xpath", "//*[@id='option-menu']/li[3]/a");
		
	}
	
}
