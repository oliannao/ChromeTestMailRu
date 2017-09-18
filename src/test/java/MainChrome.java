import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

public class MainChrome {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.ru");

		System.out.println("Page title is " + driver.getTitle());

		WebElement element = driver.findElement(By.id("mailbox__login"));
		WebElement element1 = driver.findElement(By.id("mailbox__password"));
		WebElement element2 = driver.findElement(By.id("mailbox__login__domain"));

		element.sendKeys("rebenokan");
		element1.sendKeys("galina2010");
		new Select(element2).selectByVisibleText("@inbox.ru");
		element.submit();
		element1.submit();
		Thread.sleep(5000);
		WebElement element3 = driver.findElement(By.id("PH_logoutLink"));
		driver.findElement(By.cssSelector("span.b-toolbar__btn__text.b-toolbar__btn__text_pad")).click();
		driver.findElement(By.cssSelector("textarea.js-input.compose__labels__input")).sendKeys("rebenokan@inbox.ru");

		Thread.sleep(5000);
		WebElement frame = driver.findElement(By.xpath("iframe[id*='compose_419_composeEditor_ifr']"));
		driver.switchTo().frame(frame);
		WebElement type = driver.switchTo().activeElement();
		type.sendKeys("Отправлено с помощью Selenium");
		driver.switchTo().defaultContent();

	}
}
