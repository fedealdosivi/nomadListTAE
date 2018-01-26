package nomadlist.landing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GoogleHome extends GooglePage {
    @FindBy(id = "lst-ib")
    private WebElement searchInput;

    public GoogleResults doSearch(String search){
        waitFor(visibilityOf(searchInput));
        searchInput.sendKeys(search);
        submit(searchInput);
        return new GoogleResults();
    }
}
