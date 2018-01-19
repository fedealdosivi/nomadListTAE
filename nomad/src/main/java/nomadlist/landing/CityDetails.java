package nomadlist.landing;

import nomadlist.NomadListPage;
import nomadlist.PageComponents.NavCityDetails;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CityDetails extends NomadListPage {

    @FindBy(className = "itemName")
    private WebElement cityName;

    @FindBy(css = ".tabs")
    private WebElement navCity;

    /**
     * Return the name of the city
     * found by he locator className
     * @return String
     */
    public String getName(){
        waitFor(visibilityOf(cityName));
        return getText(cityName);
    }

    /**
     * Returns the navbar of the city
     * that have been clicked
     * @return NavCityDetails
     */
    public NavCityDetails getNavCityDetails(){
        waitFor(visibilityOf(navCity));
        return new NavCityDetails(navCity);
    }

}
