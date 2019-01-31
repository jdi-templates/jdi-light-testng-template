package org.mytests.tests.example;

import org.mytests.tests.TestsInit;
import org.mytests.uiobjects.example.entities.MarvelUserInfo;
import org.mytests.uiobjects.example.site.custom.MarvelUser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.mytests.tests.preconditions.Preconditions.shouldBeLoggedIn;
import static org.mytests.uiobjects.example.TestData.HEROES_PREVIEW;
import static org.mytests.uiobjects.example.TestData.HEROES_TABLE;
import static org.mytests.uiobjects.example.TestData.SPIDER_MAN;
import static org.mytests.uiobjects.example.site.SiteJdi.usersPage;
import static org.mytests.uiobjects.example.site.pages.UsersPage.*;
import static org.testng.Assert.assertEquals;

public class DataTableTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        usersPage.shouldBeOpened();
    }

    @Test
    public void dataTableTest() {
        assertEquals(users.size(), 4);
        assertEquals(users.count(), 6);
        assertEquals(users.header(), asList("Number", "Type", "User", "Description"));

        String value = users.preview();
        assertEquals(value, HEROES_PREVIEW);
        value = users.getValue();
        assertEquals(value, HEROES_TABLE);
    }
    @Test
    public void filterDataTest() {
        assertEquals(users.data(2), SPIDER_MAN);
        assertEquals(usersSetup.data("Sergey Ivan"), SPIDER_MAN);
        assertEquals(users.data(d -> d.user.contains("Ivan")), SPIDER_MAN);

        List<MarvelUserInfo> filteredData = users.datas(d -> d.user.contains("Ivan"));
        assertEquals(filteredData.size(), 1);
        assertEquals(filteredData.get(0), SPIDER_MAN);
    }

    @Test
    public void filterLinesTest() {
        MarvelUser line =  users.line(2);
        validateUserRow(line);
        line = usersSetup.line("Sergey Ivan");
        validateUserRow(line);
        line =  users.line(d -> d.user.contains("Ivan"));
        validateUserRow(line);

        List<MarvelUser> filteredData = users.lines(d -> d.user.contains("Ivan"));
        assertEquals(filteredData.size(), 1);
        validateUserRow(filteredData.get(0));
    }

    private void validateUserRow(MarvelUser line) {
        line.type.select("Admin");
        assertEquals(line.type.getValue(), "Admin");
        line.type.select("User");
        line.number.assertThat().text(is("2"));
        line.description.image.assertThat().src(containsString("spider"));
        line.description.vip.check();
        line.description.vip.is().selected();

    }
}
