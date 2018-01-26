package nomadlist.Webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public abstract class MultipleBrowsersTest<T extends Page> {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected abstract T getInitialPage();

    protected abstract String getInitialUrl();

    @Parameter
    public Class<? extends WebDriver> driverClass;

    @Parameters(name = "{index}: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { { FirefoxDriver.class },
                { ChromeDriver.class } });
    }

    @Before
    public void setupTest() throws Exception {
        WebDriverManager.getInstance(driverClass).setup();
        driver = driverClass.newInstance();
        Context.INSTANCE.setDriver(this.driver);
        wait=new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get(getInitialUrl());
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
