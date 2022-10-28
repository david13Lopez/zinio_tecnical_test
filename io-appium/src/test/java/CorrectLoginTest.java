import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CorrectLoginTest {
    public  AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "Pixel XL API 28");
        desiredCapabilities.setCapability("appium:platformName", "Android");
        desiredCapabilities.setCapability("appium:platformVersion", "9");
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void correctLoginTest() {

        WebElement el1 = driver.findElement(By.id(ConstantIds.bottomBarProfileItem));
        el1.click();
        WebElement el2 = driver.findElement(By.xpath(ConstantIds.profileMenuSignInElement));
        el2.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement el3 = driver.findElement(By.className(ConstantIds.selectMethodSignInScreenButton));
        el3.click();
        WebElement el4 = driver.findElement(By.id(ConstantIds.signInScreenEmailField));
        el4.click();
        el4.sendKeys(ConstantIds.correctEmailValue);
        WebElement el5 = driver.findElement(By.id(ConstantIds.signInScreenPasswordField));
        el5.click();
        el5.sendKeys(ConstantIds.correctPasswordValue);
        WebElement el6 = driver.findElement(By.id(ConstantIds.signInScreenSignInButton));
        el6.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement el7 = driver.findElement(By.id(ConstantIds.bottomBarLibraryItem));
        el7.isDisplayed();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
