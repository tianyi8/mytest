package login.test.page;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
private static WebElement element = null;

public static WebElement login_UserName(WebDriver driver){
element = driver.findElement(By.id("uid"));
return element;
}

public static WebElement login_Password(WebDriver driver){
element = driver.findElement(By.id("password"));
return element;
}

public static WebElement login_Button(WebDriver driver){
element = driver.findElement(By.id("login_button"));
return element;
}

public static WebElement login_Error_Hint(WebDriver driver){
element = driver.findElement(By.xpath("//*[@id='logArea']/div[3]/span"));
return element;
}

public static WebElement login_User(WebDriver driver){
element = driver.findElement(By.xpath("//*[@id='headContainer']/div/div[4]/div[1]/span[1]"));
return element;
}

public static WebElement logout_Button(WebDriver driver){
element = driver.findElement(By.linkText("ÍË³ö"));
return element;
  }
}


