package login.test.cases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import login.test.publics.LoginUser;

public class LoginTestRight {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeMethod
	public void setUp() throws Exception {
	driver = new ChromeDriver();
	baseUrl = "http://mail.gogbuy.com";
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	   //�����������
		@DataProvider(name="user")
		public Object[][] Users(){
		return new Object[][]{
		{"luotianyi@gogbuy.com","108855435@lty","������"},
		
		   };
		}
		
		@Test(dataProvider="user")
		public void testCase(String username,String password,String assertText)
		throws Exception {
		driver.get(baseUrl);
		
		//���õ�¼ģ��
		Thread.sleep(1000);
		LoginUser.login(driver,username,password);
		Thread.sleep(2000);
		String text = LoginUser.login_user_info(driver);
		System.out.println(text);
		System.out.println(assertText);
		Assert.assertEquals(text,assertText);
		}
		
		@AfterMethod
		public void tearDown() throws Exception {
		driver.quit();
		     }
	}
	
	
