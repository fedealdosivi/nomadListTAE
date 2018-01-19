package nomadlist.PageComponents;

import WebDriver.Component;
import nomadlist.landing.CityDetails;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cities extends Component {

    @FindBy(className = "click")
    private WebElement cityLink;

    public Cities(WebElement container) {
        super(container);
    }

    public CityDetails select(){
        click(cityLink);
        return new CityDetails();
    }
}
