package nomadlist;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CityDetails extends NomadListPage {

    @FindBy(className = "itemName")
    private WebElement cityName;

    public String getName(){
        waitFor(visibilityOf(cityName));
        return getText(cityName);
    }

}
