package nomadlist.landing;

import nomadlist.PageComponents.Cities;
import nomadlist.PageComponents.NavSearch;
import nomadlist.NomadListPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class HomePage extends NomadListPage {

    @FindBy(className = "search-container")
    private WebElement searchBar;

    @FindBy(css="div.item.show > div.container.lazyloaded")
    private List<WebElement> cities;

    @FindBy(css = "div.infinity-scroll.loading_spinner.loading_spinner_medium")
    private WebElement spinner;

    @FindBy(css = ".infinity-scroll.loading_spinner")
    private WebElement scroll;

    public NavSearch getNavSearch(){
        return new NavSearch(searchBar);
    }

    public List<Cities> getCities(){
        waitFor(visibilityOfAllElements(cities));
        return cities.stream().map(Cities::new).collect(toList());
    }

    public List<Cities> getBottomCities(){

        waitFor(visibilityOf(scroll));
        waitFor(visibilityOfAllElements(cities));
        return cities.stream().map(Cities::new).collect(toList());
    }

}