package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement Account;

    @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement logoutLnk;

	public boolean Acctcheck() {

		try {
			return (Account.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	 public void logout() {
		 logoutLnk.click();
	 }
}