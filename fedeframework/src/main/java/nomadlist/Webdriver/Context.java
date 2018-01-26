package nomadlist.Webdriver;

import org.openqa.selenium.WebDriver;

enum Context {

    INSTANCE;

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
