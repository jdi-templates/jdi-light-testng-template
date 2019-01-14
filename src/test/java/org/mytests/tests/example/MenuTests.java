package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;
import org.mytests.tests.preconditions.Preconditions;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.entities.LeftMenuData.*;
import static org.mytests.uiobjects.example.site.SiteJdi.*;

public class MenuTests extends SimpleTestsInit {

    @Test
    public void menuTest() {
        Preconditions.shouldBeLoggedIn();
        homePage.shouldBeOpened();
        leftMenu.select(Service, Dates);
        datesPage.checkOpened();
        leftMenu.select(ElementsPacks, HTML5);
        html5Page.checkOpened();
    }
}
