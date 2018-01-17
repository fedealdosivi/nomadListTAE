package nomadlist;

import WebDriver.Page;
import WebDriver.WebTest;

public class TestNomadListIndex extends WebTest<HomePage>{

    @Override
    protected HomePage getInitialPage() {
        return new HomePage();
    }

    @Override
    protected String getInitialUrl() {
        return "https://nomadlist.com/";
    }
}
