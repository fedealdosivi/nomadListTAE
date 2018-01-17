package nomadlist;

import WebDriver.Component;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavSearch extends Component {

    @FindBy(className = "search")
    WebElement searchInput;

    protected NavSearch(WebElement container) {
        super(container);
    }

    public GridCities search(String searchCity){
        type(searchInput,searchCity);
        return new GridCities();
    }
}
