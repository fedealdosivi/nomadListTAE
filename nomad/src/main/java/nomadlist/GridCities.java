package nomadlist;

import WebDriver.Component;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class GridCities extends NomadListPage {

    @FindBy(css = ".grid show view > div")
    List<WebElement> cities;

    public List<Cities> getCities(){
        waitFor(visibilityOfAllElements(cities));
        return cities.stream().map(Cities::new).collect(toList());
    }


}
