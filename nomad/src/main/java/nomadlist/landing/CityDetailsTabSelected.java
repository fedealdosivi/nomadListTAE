package nomadlist.landing;

import nomadlist.NomadListPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CityDetailsTabSelected extends NomadListPage {

    @FindBy(xpath = "//*[@id=\"body\"]/div[1]/div/div[3]/div[3]/div/div[4]/div/h3[1]")
    private WebElement cantNomads;

    @FindBy(css = "#tab-forum.double-width.show.table.tbody > tr ")
    private List<WebElement> linksForum;

    /**
     * Returns the quantity and other info
     * of the nomads that were in that city
     * @return String
     */
    public String getNomads(){
        waitFor(visibilityOf(cantNomads));
        return getText(cantNomads);
    }

    public ForumPost selectForumPost(int pos){
        click(linksForum.get(pos));
        return new ForumPost();
    }
}
