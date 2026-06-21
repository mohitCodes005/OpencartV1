package testCases;

//import org.openqa.selenium.logging.Logs;
//import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegTest extends BaseClass {

	@Test(groups = {"Regression","Master"})
	public void verify_Acc_registration() {
		SoftAssert sp = new SoftAssert();
		logger.info("*******Starting TC001_AccountRegTest********");
		try {
		HomePage hp = new HomePage(driver);
		logger.info("Clicking on Account");
		hp.clickMyAcc();
		logger.info("Clicking on Register");

		hp.clickRegister();

		AccountRegistrationPage ap = new AccountRegistrationPage(driver);
		logger.info("Submitting Basic Customer Info");

		ap.setfirstname(randomeString().toUpperCase());
		ap.setlastname(randomeString().toUpperCase());
		ap.setemail(randomeString() + "@gmail.com");
		ap.settelephone(randomeNumber());
		String password = randomeAlphanumeric();
		ap.setpwd(password);
		ap.setconfirmrmpwd(password);
		ap.agreebtn();
		ap.continuebtn();
		logger.info("********Doing Validation*********");
		String msg=ap.getconfirmation_msg();
		
		if(msg.equals("Your Account Has Been Created!")) {
			sp.assertTrue(true);
		
		}
		else {
			
			logger.error("*******Not Validated********");
			logger.debug("Debug logs....");
			sp.assertTrue(false);
		}
		}
		catch(Exception e)
		{
		
			
			sp.fail();
		}
		
		logger.info("**********Finished Tests***********"); 
		sp.assertAll();
	}
	
}