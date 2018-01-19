package nomadlist.PageComponents;

import WebDriver.Component;
import nomadlist.landing.CityDetails;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class City extends Component {

    @FindBy(className = "click")
    private WebElement cityLink;

    public City(WebElement container) {
        super(container);
    }

    /**
     * Click the current city
     * @return CityDetails
     */
    public CityDetails select(){
        click(cityLink);
        return new CityDetails();
    }
}
