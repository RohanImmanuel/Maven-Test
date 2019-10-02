package maven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class HelloMaven {
	
  public static final String USERNAME = System.getenv("BSUSER");
  public static final String AUTOMATE_KEY = System.getenv("BSKEY");
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

  public static void main(String[] args) throws Exception {
	  
	DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browser", "Firefox");
    caps.setCapability("browser_version", "70.0 beta");
    caps.setCapability("os", "OS X");
    caps.setCapability("os_version", "Mojave");
    caps.setCapability("resolution", "1024x768");
    caps.setCapability("name", "Jenkins Test");
    caps.setCapability("build", "SUP 509");

    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get("http://www.google.com");
    WebElement element = driver.findElement(By.name("q"));

    element.sendKeys("BrowserStack");
    element.submit();

    System.out.println(driver.getTitle());
    driver.quit();

  }
}