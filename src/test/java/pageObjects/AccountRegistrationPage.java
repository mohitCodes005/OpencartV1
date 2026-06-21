package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txt_firstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txt_lastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_email;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_pwd;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txt_confpwd;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement boxterm;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btn_cont;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmation_msg;
   //Action Methods 
	public void setfirstname(String fname) {
		txt_firstname.sendKeys(fname);

	}

	public void setlastname(String lname) {
		txt_lastname.sendKeys(lname);
	}

	public void setemail(String mail) {
		txt_email.sendKeys(mail);
	}

	public void settelephone(String tele) {
		telephone.sendKeys(tele);
	}

	public void setpwd(String password) {
		txt_pwd.sendKeys(password);
	}

	public void setconfirmrmpwd(String confirmpassword) {
		txt_confpwd.sendKeys(confirmpassword);
	}

	public void agreebtn() {
		boxterm.click();
	}

	public void continuebtn() {
		btn_cont.click();
	}

	public String getconfirmation_msg() {
		try {
			return (confirmation_msg.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}
	}

}
