package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;
import org.mytests.tests.preconditions.Preconditions;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.entities.LeftMenuData.*;
import static org.mytests.uiobjects.example.site.SiteJdi.*;
import static org.testng.Assert.assertTrue;

public class MenuTests extends SimpleTestsInit {

    /*@Test
    public void menuTest() {
        Preconditions.shouldBeLoggedIn();
        homePage.shouldBeOpened();
        leftMenu.select(Service, Dates);
        datesPage.checkOpened();
        leftMenu.select(ElementsPacks, HTML5);
        html5Page.checkOpened();
    }*/
    int count = 0;
    @Test
    public void failedTest1() {
        System.out.println("Retry1: " + count);
        if (count++ % 2 == 0)
            assertTrue(false);
    }
    @Test
    public void failedTest2() {
        System.out.println("Retry2: " + count);
        assertTrue(false);
    }
}
