package nomadlist.landing;

import nomadlist.NomadListPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CityDetailsTabSelected extends NomadListPage {

    @FindBy(css = "#people-here-now h3")
    private WebElement cantNomads;

    /**
     * Returns the quantity and other info
     * of the nomads that were in that city
     * @return String
     */
    public String getNomads(){
        waitFor(visibilityOf(cantNomads));
        return getText(cantNomads);
    }
}
