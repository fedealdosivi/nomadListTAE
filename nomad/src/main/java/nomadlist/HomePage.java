package nomadlist;

import WebDriver.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends NomadListPage {

    @FindBy(className = "search-container")
    WebElement searchBar;

    @FindBy(className = "grid show view")
    WebElement gridCities;

    public NavSearch getNavSearch(){
        return new NavSearch(searchBar);
    }





}
