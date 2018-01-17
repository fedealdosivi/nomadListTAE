package nomadlist;

import WebDriver.Component;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cities extends Component {

    @FindBy(className = "click")
    WebElement cityLink;

    protected Cities(WebElement container) {
        super(container);
    }

    public CityDetails select(){
        click(cityLink);
        return new CityDetails();
    }
}
