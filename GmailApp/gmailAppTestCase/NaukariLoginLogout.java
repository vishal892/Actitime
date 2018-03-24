package gmailAppTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NaukariLoginLogout {
	@Test
	public void verifyNaukriLoginPage() throws InterruptedException{
		WebDriver d1 = new FirefoxDriver();
		d1.get("https://www.naukri.com/");
		d1.findElement(By.id("login_Layer")).click();
		d1.findElement(By.id("eLogin")).sendKeys("e89w784yiueryieyr87yw");
		//d1.findElement(By.id("next")).click();
		Thread.sleep(2000);
		d1.findElement(By.id("pLogin")).sendKeys("938784y3y7463874");
		d1.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		Thread.sleep(2000);	
		Actions act=new Actions(d1);
		WebElement wb1=d1.findElement(By.xpath("//div[contains(text(),'My Naukri')]"));
		act.moveToElement(wb1).perform();
		
		Thread.sleep(2000);
		d1.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
		
		System.out.println("naukri profile has been succesfully Verified");
		
		d1.close();
		
		
	}
}