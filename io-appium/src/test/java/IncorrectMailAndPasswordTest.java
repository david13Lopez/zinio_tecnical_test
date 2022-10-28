import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class IncorrectMailAndPasswordTest {

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
        WebElement el1 = driver.findElement(By.id("com.zinio.mobile.android.reader:id/menu_account"));
        el1.click();
        WebElement el2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup"));
        el2.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement el3 = driver.findElement(By.className("android.widget.Button"));
        el3.click();
        WebElement el4 = driver.findElement(By.id("com.zinio.mobile.android.reader:id/email_field"));
        el4.click();
        el4.sendKeys("incorrectMail@test.com");
        WebElement el5 = driver.findElement(By.id("com.zinio.mobile.android.reader:id/password_field"));
        el5.click();
        el5.sendKeys("wrongPassword");
        WebElement el6 = driver.findElement(By.id("com.zinio.mobile.android.reader:id/sign_in_button"));
        el6.click();
        WebElement el7 = driver.findElement(By.id("com.zinio.mobile.android.reader:id/snackbar_text"));
        el7.isDisplayed();
        WebElement el8 = driver.findElement(By.id("com.zinio.mobile.android.reader:id/close_button"));
        el8.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
