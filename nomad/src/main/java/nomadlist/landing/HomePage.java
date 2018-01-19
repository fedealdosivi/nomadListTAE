package nomadlist.landing;

import nomadlist.PageComponents.City;
import nomadlist.PageComponents.NavSearch;
import nomadlist.NomadListPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class HomePage extends NomadListPage {

    @FindBy(className = "search-container")
    private WebElement searchBar;

    @FindBy(css="div.item.show > div.container.lazyloaded")
    private List<WebElement> cities;

    @FindBy(css = "div.infinity-scroll.loading_spinner.loading_spinner_medium")
    private WebElement spinner;

    @FindBy(css = ".infinity-scroll.loading_spinner")
    private WebElement scroll;

    /**
     * Returns the navSearch component which is used
     * to input and search cities
     * @return NAVSEARCH
     */
    public NavSearch getNavSearch(){
        return new NavSearch(searchBar);
    }

    /**
     * Converts and return a list of cities
     * found by the locator css
     * @return List
     */
    public List<City> getCities(){
        waitFor(visibilityOfAllElements(cities));
        return cities.stream().map(City::new).collect(toList());
    }

    public List<City> getBottomCities(){

        waitFor(visibilityOf(scroll));
        waitFor(visibilityOfAllElements(cities));
        return cities.stream().map(City::new).collect(toList());
    }

}
