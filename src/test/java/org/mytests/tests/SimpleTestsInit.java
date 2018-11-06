package org.mytests.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import org.mytests.uiobjects.example.site.SiteJdi;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.actions.ActionHelper.ERROR_THROWN;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static org.mytests.uiobjects.example.site.SiteJdi.homePage;

public class SimpleTestsInit {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        initElements(SiteJdi.class);
        homePage.open();
        logger.info("Run Tests");
    }

    @BeforeMethod
    public void before() {
        ERROR_THROWN = false;
    }

    @AfterSuite(alwaysRun = true)
    public void teardown() {
        WebDriverFactory.close();
    }
}
