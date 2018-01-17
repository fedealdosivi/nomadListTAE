package nomadlist;

import WebDriver.Page;
import WebDriver.WebTest;
import org.junit.Test;

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
    public void TestSearchArgentinaCities(){
            Cities cities= getInitialPage()
                    .getNavSearch()
                    .search("Argentina")
                    .getCities()
                    .get(6);

            cities.select();
    }
}
