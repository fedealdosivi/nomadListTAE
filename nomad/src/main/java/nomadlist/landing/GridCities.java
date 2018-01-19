package nomadlist.landing;

import nomadlist.PageComponents.City;
import nomadlist.NomadListPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class GridCities extends NomadListPage {

    @FindBy(css="div.item.show > div.container.lazyloaded")
    private List<WebElement> cities;

    /**
     * Converts and return a list of cities
     * found by the locator css
     * @return List
     */
    public List<City> getCities(){
        waitFor(visibilityOfAllElements(cities));
        return cities.stream().map(City::new).collect(toList());
    }


}
