package WebDriver;

import org.openqa.selenium.support.PageFactory;

public class Page extends CommonOperations {
    protected Page() {
        PageFactory.initElements(getDriver(), this);
    }
}
