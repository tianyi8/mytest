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

public class LoginTestError {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeMethod
	public void setUp() throws Exception {
	driver = new ChromeDriver();
	baseUrl = "http://mail.gogbuy.com";
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	//定义对象数组
	@DataProvider(name="user")
	public Object[][] Users(){
	return new Object[][]{
	{"","","请输入用户名和密码"},
	{"testing"," ","密码未输入"},
	{" ","123456","用户名未输入"},
	{"error","error","用户名或密码错误，或登录受到限制"},
	
	   };
	}
	@Test(dataProvider="user")
	public void testCase(String username,String password,String expectText)
	throws Exception {
	driver.get(baseUrl);
	//调用登录模块
	Thread.sleep(1000);
	LoginUser.login(driver,username,password);
	Thread.sleep(2000);
	String text = LoginUser.login_error_info(driver);
	System.out.println(text);
	System.out.println(expectText);
	Assert.assertEquals(text,expectText);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
	driver.quit();
	     }
}
	
	
