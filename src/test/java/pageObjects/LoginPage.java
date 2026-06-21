package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email_inp;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement pwd_inp;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement login_btn;

	public void setemail(String email) {
		email_inp.sendKeys(email);

	}

	public void setpwd(String pwd) {
		pwd_inp.sendKeys(pwd);

	}

	public void loginbtn() {
		login_btn.click();

	}

}