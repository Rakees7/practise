package testcase;

import static org.testng.Assert.*;

import java.util.logging.Logger;

import org.apache.log4j.BasicConfigurator;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import basicFunctions.Common;
import pages.login;
import utills.ExtentFactory;
import utills.dataprovider_data;

@Listeners(utills.listen.class)
public class TC1_login 
{
	//extent
	ExtentReports report;
	ExtentTest test;
	
	login log=new login();
	Common br=new Common();
	boolean b;
	Logger logg=Logger.getLogger("TC1_login.class");
	
	@BeforeTest
	public void browser_launch()
	{
		BasicConfigurator.configure();
		report=ExtentFactory.Instance();
		test=report.startTest("verify browser launched are not");
		br.browser_launch("ie");
		logg.info("browser launched");
	}
	
	@Test(dataProvider="excellvalues",dataProviderClass=dataprovider_data.class)
	public void loginstup(String Un,String PW,String url) throws InterruptedException
	{
		br.url(url);
		b=br.verify_title("OrangeHRM - New Level of HR Management");
		assertTrue(b);
		Reporter.log("login page displayed");
		logg.info("login page displayed");
		Thread.sleep(2000);
		b=log.verification_of_all_loginfields();
		assertTrue(b);
		Thread.sleep(2000);
		logg.info("all feilds displayed");
		log.login_values(Un, PW);
		Thread.sleep(2000);
		b=log.verify_homepage_abovefeilds(Un);
		assertTrue(b);
		Thread.sleep(2000);
		logg.info("all fields and welcome message displayed");
		log.logout();
		logg.info("logged out succesfully");
		b=br.verify_title("OrangeHRM - New Level of HR Management");
		assertTrue(b);
		Reporter.log("login page displayed");
		
	}
	
	@AfterTest
	public void browserclose()
	{
		
	//	br.close();
		//br.quit();
		report.endTest(test);
		report.flush();
	}
	
}
