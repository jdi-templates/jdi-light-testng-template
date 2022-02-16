package backbase.qa.webTests.multiUsers;

import backbase.qa.webTests.TestsInit;
import org.testng.annotations.Test;

import static backbase.qa.site.BackBaseSite.homePage;

public class FormTests implements TestsInit {

    @Test
    public void loginTest() {
        homePage.checkOpened();
    }
}
