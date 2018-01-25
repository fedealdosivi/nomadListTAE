package nomadlist;

import WebDriver.WebTest;
import nomadlist.PageComponents.City;
import nomadlist.landing.HomePage;
import org.junit.Test;

import static nomadlist.PageComponents.NavCityDetails.Tabs.FORUM;
import static nomadlist.PageComponents.NavCityDetails.Tabs.PEOPLE;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertEquals;

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
        City city=getInitialPage()
                .getCities()
                .get(1);

        assertThat("City has a name",city.select().getName(),not(isEmptyString()));
    }

    @Test
    public void TestCityForum(){
        City city=getInitialPage()
                .getCities()
                .get(4);

        String cantNomads=city.select()
                .getNavCityDetails()
                .selectTab(FORUM)
                .getNomads();
        assertThat("is not Empty",cantNomads,not(isEmptyString()));
    }

    @Test
    public void TestCityPeople(){
        City city=getInitialPage()
                .getCities()
                .get(1);

        assertThat("City has nomads",
                city.select().getNavCityDetails().selectTab(PEOPLE).getNomads(),not(isEmptyString()));
    }

    @Test
    public void TestSelectCityUsingScroll(){
        City city=getInitialPage()
                .getBottomCities()
                .get(19);

        assertThat("City has a name",city.select().getName(),not(isEmptyString()));
    }

    @Test
    public void TestSearchArgentinaCitiesAndSelect(){
            City city = getInitialPage()
                    .getNavSearch()
                    .search("Argentina")
                    .getCities()
                    .get(2);

            assertThat("City has a name",city.select().getName(),not(isEmptyString()));
    }
}
