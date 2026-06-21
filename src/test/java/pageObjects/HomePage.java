package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	// locators
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement acclnk;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement registerlnk;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement LoginLnk;

	// Action Methods
	public void clickMyAcc() {
		acclnk.click();

	}

	public void clickRegister() {

		registerlnk.click();
	}

	public void clickLogin() {

		LoginLnk.click();
	}

}
