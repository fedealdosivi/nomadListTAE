package nomadlist.PageComponents;

import WebDriver.Component;
import nomadlist.landing.GridCities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavSearch extends Component {

    @FindBy(className = "search")
    WebElement searchInput;

    public NavSearch(WebElement container) {
        super(container);
    }

    /**
     *
     * @param searchCity
     * @return GridCities
     */
    public GridCities search(String searchCity){
        type(searchInput,searchCity);
        return new GridCities();
    }
}
