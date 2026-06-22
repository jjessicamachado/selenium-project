package support;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected final Core core = new Core();

    @BeforeEach
    public void initDriver() {
        core.initBrowser(ConfigLoader.getProperty("BASE_URL"));
    }

   // @AfterEach
    public void killDriver() {
        core.killDriver();
    }
}
