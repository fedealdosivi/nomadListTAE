package nomadlist.landing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class WikipediaHome extends WikipediaPage {
    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(id = "searchButton")
    private WebElement searchBtn;

    public WikipediaResults doSearch(String search){
        waitFor(visibilityOf(searchInput));
        waitFor(visibilityOf(searchBtn));
        searchInput.sendKeys(search);
        searchBtn.click();
        return new WikipediaResults();
    }
}
