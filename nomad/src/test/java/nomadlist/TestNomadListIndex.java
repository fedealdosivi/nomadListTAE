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
            Cities city = getInitialPage()
                    .getNavSearch()
                    .search("Argentina")
                    .getCities()
                    .get(2);

            city.select();
    }
}
