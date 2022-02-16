package backbase.qa.webTests;

import backbase.qa.testng.TestNGListener;
import backbase.qa.site.BackBaseSite;
import com.epam.jdi.light.elements.common.Alerts;
import com.epam.jdi.light.elements.composite.WebPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.common.Alerts.*;
import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.init;
import static com.epam.jdi.light.settings.WebSettings.logger;

@Listeners(TestNGListener.class)
public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        killAllSeleniumDrivers();
        initSite(BackBaseSite.class);
        openUrl("https://candidatex:qa-is-cool@qa-task.backbasecloud.com");
        logger.info("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }
}
