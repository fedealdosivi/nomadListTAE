package nomadlist;

import nomadlist.Webdriver.MultipleBrowsersTest;
import nomadlist.landing.WikipediaHome;
import org.junit.Test;

public class TestPrueba extends MultipleBrowsersTest<WikipediaHome> {


    @Override
    protected WikipediaHome getInitialPage() {
        return new WikipediaHome();
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
