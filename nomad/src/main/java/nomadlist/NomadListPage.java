package nomadlist;

import WebDriver.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NomadListPage extends Page {

    @FindBy(tagName = "html")
    private WebElement html;

}
