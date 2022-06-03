package org.mytests.tests.test;

import org.mytests.tests.test.testng.TestNGListener;
import org.mytests.uiobjects.example.site.SiteJdi;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.logger;

@Listeners(TestNGListener.class)
public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    public default void setUp() {
        initSite(SiteJdi.class);
        logger.info("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public default void teardown() {
        killAllSeleniumDrivers();
    }
}
