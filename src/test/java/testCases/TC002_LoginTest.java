package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = {"Sanity","Master"})
	public void verify_login() {
		SoftAssert sp = new SoftAssert();
       //HomePage
		logger.info("*******Initiating TC002_LoginTest********");
		try {
		HomePage hp = new HomePage(driver);
		logger.info("Clicking on MyAccount");
		hp.clickMyAcc();
		logger.info("Clicking on Login_Btn");
		hp.clickLogin();
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		logger.info("Submitting mail & pwd for login");
		lp.setemail(p.getProperty("email"));
		lp.setpwd(p.getProperty("password"));
		lp.loginbtn();
		//AccountPage
		logger.info("*******Validating*******");
		AccountPage macc = new AccountPage(driver);
		boolean targetpge =macc.Acctcheck();
		sp.assertTrue(targetpge,"Login Failed");
		}
		catch(Exception e) {
			sp.fail();
		}
		logger.info("Finished Test");
		
	}
}
