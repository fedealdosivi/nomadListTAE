package nomadlist;

import nomadlist.Webdriver.MultipleBrowsersTest;
import nomadlist.Webdriver.Page;
import nomadlist.landing.GoogleHome;
import org.junit.Test;

public class TestPrueba extends MultipleBrowsersTest<GoogleHome> {


    @Override
    protected GoogleHome getInitialPage() {
        return new GoogleHome();
    }

    @Override
    protected String getInitialUrl() {
        return "https://en.wikipedia.org/wiki/Main_Page";
    }

    @Test
    public void doSearch(){
        getInitialPage().doSearch("argentina");
    }
}
