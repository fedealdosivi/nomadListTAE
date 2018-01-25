package WebDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import logging.Logging;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.String.format;

public enum Browser implements Initializable, HasCapabilities, Logging {


    CHOME{
        @Override
        public void initialize() {
            INITIALIZED.computeIfAbsent(ordinal(), n -> {
                ChromeDriverManager.getInstance().setup();
                return true;
            });
        }

        @Override
        public Capabilities getCapabilities() {
            return DesiredCapabilities.chrome();
        }
    };

    private static final Map<Integer, Boolean> INITIALIZED = new ConcurrentHashMap<>();

    Browser() {
        getLogger().info(format("Initializing configuration for browser [%s]...", name()));
    }

}
