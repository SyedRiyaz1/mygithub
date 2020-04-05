package OTP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test130_Get_Otp_From_Twilio_To_Amazon
{
	public static void main(String[] args) throws Exception 
	{
		/*System.setProperty("webdriver.chrome.driver", 
				"E:\\batch 244\\chromedriver.exe");*/
		//WebDriverManager.chromedriver().arch64().version(" 80.0.3987.149").setup();
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver.manage().window().maximize();
		// launch site(SWD)
		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
		// Go To Resgistration(SwD)
		WebElement e=driver.findElement(By.xpath("//*[text()='Hello. Sign in']"));
		Actions a= new Actions(driver);
		a.moveToElement(e).perform();
		Thread.sleep(10000);
		driver.findElement(By.linkText("Start here.")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("customerName")).sendKeys("riyaz");
		driver.findElement(By.xpath("//*[@class='a-dropdown-prompt']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='United States +1']")).click();
		driver.findElement(By.xpath("//*[@placeholder='Mobile number']")).sendKeys("12013477368");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("riyaz.selenium@gmail.com");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("9481538032");
		driver.findElement(By.xpath("//*[@id='continue']")).click();
		Thread.sleep(5000);
		// Enter OTP to Amazzon website from twilio
		final String  ACCOUNT_SID	="AC491c8b8881e6f8d1946d948b3e5a2cfb";
		final String  AUTH_TOKEN   =  "5f086b2660baaa294db5a5f9fbd3c26f";
		// twilio  phone number   >>> 12013477368
		// twilio password >>>>>       9481538032riyaz
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		ResourceSet<Message>msg=Message.reader().read();
		String temp=msg.iterator().next().getBody();
		String otp=temp.split(" ")[0]; // get spice from otp message
		// Enter Otp
		driver.findElement(By.xpath("//*[@type='tel']")).sendKeys(otp);
		System.out.println("well dome bro");
	}
}
