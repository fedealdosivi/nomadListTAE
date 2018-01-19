package nomadlist;

import WebDriver.WebTest;
import nomadlist.PageComponents.Cities;
import nomadlist.landing.HomePage;
import org.junit.Test;

import static nomadlist.PageComponents.NavCityDetails.Tabs.PEOPLE;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;

public class TestNomadListIndex extends WebTest<HomePage>{

    @Override
    protected HomePage getInitialPage() {
        return new HomePage();
    }

    @Override
    protected String getInitialUrl() {
        return "https://nomadlist.com/";
    }


    @Test
    public void TestSelectCityFromHome(){
        Cities city=getInitialPage()
                .getCities()
                .get(1);

        assertThat("City has a name",city.select().getName(),not(isEmptyString()));
    }

    @Test
    public void TestSelectCityUsingScroll(){
        Cities city=getInitialPage()
                .getBottomCities()
                .get(19);

        assertThat("City has a name",city.select().getName(),not(isEmptyString()));
    }

    @Test
    public void TestCityPeople(){
        Cities city=getInitialPage()
                .getCities()
                .get(1);

        assertThat("City has nomads",
                city.select().getNavCityDetails().selectTab(PEOPLE).getNomads(),not(isEmptyString()));
    }

    @Test
    public void TestSearchArgentinaCitiesAndSelect(){
            Cities city = getInitialPage()
                    .getNavSearch()
                    .search("Argentina")
                    .getCities()
                    .get(2);

            assertThat("City has a name",city.select().getName(),not(isEmptyString()));
    }
}
