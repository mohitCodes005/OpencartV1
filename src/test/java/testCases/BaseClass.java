package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	@Parameters({ "Browser", "os" })
	public void setup(String br, String os) throws IOException {
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		logger = LogManager.getLogger(this.getClass());

		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			if (os.equalsIgnoreCase("Windows")) {
				cap.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("Mac")) {

				cap.setPlatform(Platform.MAC);

			} else if (os.equalsIgnoreCase("Linux")) {

				cap.setPlatform(Platform.LINUX);
			}

			else {
				System.out.println("Invalid Os");
				return;

			}

			switch (br.toLowerCase()) {

			case "chrome":
				cap.setBrowserName("chrome");
				break;
			case "edge":
				cap.setBrowserName("edge");
				break;
			case "firefox":
				cap.setBrowserName("firefox");
				break;

			default:
				System.out.println("Invalid Browser");
				return;
			}
			driver = new RemoteWebDriver(new URL("http://192.168.0.105:4444"), cap);

		}

		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {

			switch (br.toLowerCase()) {

			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;

			default:
				System.out.println("Invalid Browser");
				return;
			}
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		// driver.get("https://tutorialsninja.com/demo/");

	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();

	}

	public String randomeString() {

		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}

	public String randomeNumber() {

		String generatednum = RandomStringUtils.randomNumeric(10);
		return generatednum;
	}

	public String randomeAlphanumeric() {

		String generatedstring = RandomStringUtils.randomAlphabetic(4);
		String generatednum = RandomStringUtils.randomNumeric(4);

		return (generatedstring + "@/" + generatednum);
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}

}
