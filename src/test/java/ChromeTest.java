import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChromeTest {
	public static WebDriver driver;

	@BeforeMethod
	public void BeforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(enabled = true)
	public void driverGetMailTest() {
		driver.get("https://mail.ru/");
		String title = "Mail.Ru: почта, поиск в интернете, новости, игры";
		driver.getTitle();
		Assert.assertEquals(driver.getTitle(), title);
		WebElement element = driver.findElement(By.id("mailbox__login"));
		WebElement element1 = driver.findElement(By.id("mailbox__password"));
		element.sendKeys("rebenokan");
		element1.sendKeys("galina2010");
		new Select(driver.findElement(By.id("mailbox__login__domain"))).selectByVisibleText("@inbox.ru");
		element.submit();
		element1.submit();
		WebElement element2 = driver.findElement(By.id("PH_logoutLink"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("span.b-toolbar__btn__text.b-toolbar__btn__text_pad")).click();
		driver.findElement(By.cssSelector("textarea.js-input.compose__labels__input")).sendKeys("rebenokan@inbox.ru");
		
		
	}

	@AfterClass
	public void AfterMethod() {
		// driver.close();
	}
}