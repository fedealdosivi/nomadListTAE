package nomadlist;

import WebDriver.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends NomadListPage {

    @FindBy(className = "search-container")
    WebElement searchBar;

    @FindBy(css="div.item.show > div.container.lazyloaded")
    private List<WebElement> cities;

    public NavSearch getNavSearch(){
        return new NavSearch(searchBar);
    }





}
