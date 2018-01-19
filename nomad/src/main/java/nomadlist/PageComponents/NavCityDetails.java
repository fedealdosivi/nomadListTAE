package nomadlist.PageComponents;

import WebDriver.Component;
import nomadlist.landing.CityDetailsTabSelected;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavCityDetails extends Component {

    @FindBy(css = ".tabs.ul > h3")
    private List<WebElement> tabs;

    public NavCityDetails(WebElement container) {
        super(container);
    }

    /**
     * Select from the navBar the option
     * choosed by position
     * @param optionTab
     * @return CityDetailsTabSelected
     */
    public CityDetailsTabSelected selectTab(Tabs optionTab){
        switch (optionTab){
            case SCORES:
                click(tabs.get(optionTab.ordinal()));
                break;
            case TRAVEL_GUIDE:
                click(tabs.get(optionTab.ordinal()));
                break;
            case COST_OF_LIVING:
                click(tabs.get(optionTab.ordinal()));
                break;
            case FLIGHTS:
                click(tabs.get(optionTab.ordinal()));
                break;
            case PEOPLE:
                click(tabs.get(optionTab.ordinal()));
                break;
            case NEIGHBORHOODS:
                click(tabs.get(optionTab.ordinal()));
                break;
            case FORUM:
                click(tabs.get(optionTab.ordinal()));
                break;
            case CHAT:
                click(tabs.get(optionTab.ordinal()));
                break;
            case COWORKING:
                click(tabs.get(optionTab.ordinal()));
                break;
            case VIDEO:
                click(tabs.get(optionTab.ordinal()));
                break;
            case REMOTE_JOBS:
                click(tabs.get(optionTab.ordinal()));
                break;
        }
        return new CityDetailsTabSelected();
    }

    public enum Tabs{
        SCORES,TRAVEL_GUIDE,COST_OF_LIVING,
        FLIGHTS,PEOPLE,NEIGHBORHOODS,FORUM,
        CHAT,COWORKING,VIDEO,REMOTE_JOBS
    }


}
