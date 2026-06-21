package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups= "DataDriven")
	public void Verify_loginddt(String email, String pwd, String res) {

		
		// HomePage
		logger.info("*******Initiating TC003_LoginTestDDT********");
		try {
			HomePage hp = new HomePage(driver);
			logger.info("Clicking on MyAccount");
			hp.clickMyAcc();
			logger.info("Clicking on Login_Btn");
			hp.clickLogin();
			// LoginPage
			LoginPage lp = new LoginPage(driver);
			logger.info("Submitting mail & pwd for login");
			lp.setemail(email);
			lp.setpwd(pwd);
			lp.loginbtn();
			// AccountPage
			logger.info("*******Validating*******");
			AccountPage macc = new AccountPage(driver);
			boolean targetpge = macc.Acctcheck();

			if (res.equalsIgnoreCase("Valid")) {

				if (targetpge == true) {
					macc.logout();
					Assert.assertTrue(true);
					

				} else {
					logger.error("*******Not Validated********");

					Assert.assertTrue(false);

				}

			}
			if (res.equalsIgnoreCase("Invalid")) {

				if (targetpge == true) {
					logger.error("*******Not Validated********");
					macc.logout();
					Assert.assertTrue(false);

					

				} else {
					Assert.assertTrue(true);
				}

			}
		} catch (Exception e) {
			logger.error("*******Not Validated********");

			Assert.fail();

		}
		logger.info("*******Finished TC003_LoginTestDDT********");
	}
}
