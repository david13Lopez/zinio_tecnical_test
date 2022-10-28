import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
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

        WebElement el6 = driver.findElement(By.id("com.zinio.mobile.android.reader:id/menu_account"));
        el6.click();
        WebElement el7 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup"));
        el7.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement el8 = driver.findElement(By.className("android.widget.Button"));
        el8.click();
        WebElement el9 = driver.findElement(By.id("com.zinio.mobile.android.reader:id/email_field"));
        el9.click();
        el9.sendKeys("testmail@test.com");
        WebElement el10 = driver.findElement(By.id("com.zinio.mobile.android.reader:id/password_field"));
        el10.click();
        el10.sendKeys("password");
        WebElement el11 = driver.findElement(By.id("com.zinio.mobile.android.reader:id/sign_in_button"));
        el11.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement el12 = driver.findElement(By.id("com.zinio.mobile.android.reader:id/menu_read"));
        el12.isDisplayed();


    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
